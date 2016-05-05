package redis;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 对网站文章的投票计分功能
 *
 * Created by cc on 16/5/5.
 */
public class VoteDemo {

    public static final int ONE_WEEK_IN_SECONDS = 7 * 24 * 60 * 60;

    public static final int PRIME_ARTICLE_VOTE_COUNT_THRESHOLD = 200;

    public static final int VOTE_SCORE = 24 * 60 * 60 / PRIME_ARTICLE_VOTE_COUNT_THRESHOLD;

    public static final String TIME_KEYWORD = "time:";

    public static final String VOTED_KEYWORD = "voted:";

    public static final String SCORE_KEYWORD = "score:";

    public static final String ARTICLE_KEYWORD = "article:";

    public static final String TITLE_FIELD = "title";

    public static final String LINK_FIELD = "link";

    public static final String POSTER_FIELD = "poster";

    public static final String TIME_FIELD = "time";

    public static final String VOTE_COUNT_FIELD = "votes";

    public static final String COLON_SEPARATOR = ":";

    private AtomicLong articleIdCounter = new AtomicLong(1);

    /**
     * 对文章进行投票
     */
    public void voteAnArticle(Jedis jedis, String userId, String articleId) {
        double oneWeekBefore = (double) (System.currentTimeMillis() - ONE_WEEK_IN_SECONDS);

        if (jedis.zscore(TIME_KEYWORD, articleId) < oneWeekBefore) {
            return;
        }

        String strippedArticleId = articleId.substring(articleId.indexOf(COLON_SEPARATOR) + 1);

        boolean hasVoted = jedis.sismember(VOTED_KEYWORD + strippedArticleId, userId);
        if (!hasVoted) {
            jedis.sadd(VOTED_KEYWORD + strippedArticleId, userId);
            jedis.zincrby(SCORE_KEYWORD, VOTE_SCORE, articleId);
            jedis.hincrBy(articleId, VOTE_COUNT_FIELD, VOTE_SCORE);
        }
    }

    /**
     * 发布文章
     */
    public String postAnArticle(Jedis jedis, String userId, String url, String title) {
        long strippedArticleId = articleIdCounter.getAndIncrement();
        String newArticleId = ARTICLE_KEYWORD + strippedArticleId;
        long currentMillis = System.currentTimeMillis();

        /*
        jedis.hset(newArticleId, TITLE_FIELD, title);
        jedis.hset(newArticleId, LINK_FIELD, url);
        jedis.hset(newArticleId, POSTER_FIELD, userId);
        jedis.hset(newArticleId, TIME_FIELD, String.valueOf(currentMillis));
        jedis.hset(newArticleId, VOTE_COUNT_FIELD, String.valueOf(0));
        */

        Map<String, String> articleFields = Maps.newHashMap();
        articleFields.put(TITLE_FIELD, title);
        articleFields.put(LINK_FIELD, url);
        articleFields.put(POSTER_FIELD, userId);
        articleFields.put(TIME_FIELD, String.valueOf(currentMillis));
        articleFields.put(VOTE_COUNT_FIELD, String.valueOf(0));
        jedis.hmset(newArticleId, articleFields);

        jedis.sadd(VOTED_KEYWORD + strippedArticleId, userId);
        // 设置文章的用户投票集合过期时间为一周
        jedis.expire(VOTED_KEYWORD + strippedArticleId, ONE_WEEK_IN_SECONDS);

        jedis.zadd(TIME_KEYWORD, (double) currentMillis, newArticleId);

        jedis.zadd(SCORE_KEYWORD, (double) currentMillis, newArticleId);

        return newArticleId;
    }

    /**
     * 分页获取高评分文章信息
     */
    public List<Map<String, String>> getTopScoreArticlesByPage(
            Jedis jedis, int pageNumber, int pageSize, String articleSet) {
        int startPos = pageNumber * pageSize;
        int endPos = startPos + pageSize;
        List<Map<String, String>> articleInfoList = Lists.newArrayList();

        Set<String> topScoreArticleIds = jedis.zrevrange(articleSet, startPos, endPos);
        for (String articleId : topScoreArticleIds) {
            Map<String, String> articleInfo = jedis.hgetAll(articleId);
            // 添加文章id信息
            articleInfo.put("id", articleId);
            articleInfoList.add(articleInfo);
        }

        return articleInfoList;
    }

    /**
     * 获取指定分组的高评分文章信息
     */
    public List<Map<String, String>> getTopScoreArticlesByGroupAndPage(
            Jedis jedis, String groupId, int pageNumber, int pageSize) {
        String combinedKey = SCORE_KEYWORD + groupId;
        if (!jedis.exists(combinedKey)) {
            ZParams zParams = new ZParams();
            zParams.aggregate(ZParams.Aggregate.MAX);

            jedis.zinterstore(combinedKey, zParams, SCORE_KEYWORD, groupId);
            jedis.expire(combinedKey, 60);
        }

        return getTopScoreArticlesByPage(jedis, pageNumber, pageSize, combinedKey);
    }

    /**
     * 添加文章到群组
     */
    public void addAnArticleToGroup(Jedis jedis, String articleId, List<String> groupIdList) {
        for (String groupId : groupIdList) {
            jedis.sadd(groupId, articleId);
        }
    }

    /**
     * 从群组中删除文章
     */
    public void removeAnArticleFromGroup(Jedis jedis, String articleId, List<String> groupIdList) {
        for (String groupId : groupIdList) {
            jedis.srem(groupId, articleId);
        }
    }
}
