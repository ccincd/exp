package toy.time.apache;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * DateFormatUtils格式化Demo
 * 1 DateUtils
 * 2 DateFormatUtils
 * 3 FastDateFormat
 * 4 DurationFormatUtils
 * 5 StopWatch
 *
 * Created by cc on 16/3/26.
 */
public class DateUtilsFormatAndParse {

    public static void main(String[] args) {
        String dayOne = "2016-01-01";
        String dayTwo = "2018/01/02";
        String dayThree = "2016 01 03 13:15:36";
        String dayFour = "2016 01 03 23:15:36";

        try {
            /**
             * parseDate可以输入多个parsePattern参数，逐次进行匹配
             */
            Date dateOne = DateUtils.parseDate(dayOne, "yyyy-MM-dd");
            Date dateTwo = DateUtils.parseDate(dayTwo, "yyyy/MM/dd");
            Date dateThree = DateUtils.parseDate(dayThree, "yyyy MM dd HH:mm:ss");
            Date dateFour = DateUtils.parseDate(dayFour, "yyyy*MM*dd", "yyyy MM dd hh:mm:ss");

            System.out.println(dateOne);
            System.out.println(dateTwo);
            System.out.println(dateThree);
            System.out.println(dateFour);

            /**
             * format成String类型
             */
            System.out.println(DateFormatUtils.format(dateFour, "yyyy MM dd hh:mm:ss"));

            /**
             * 第二个参数指定截取级别，可以理解为保留精度
             */
            Date truncatedDate = DateUtils.truncate(dateThree, Calendar.MONTH);
            System.out.println(truncatedDate);

            /**
             * 比较两个日期是否是同一天
             */
            System.out.println(DateUtils.isSameDay(dateFour, dateOne));

            /**
             * FastDateFormat is a fast and thread-safe version of SimpleDateFormat
             */
            FastDateFormat isoDateFormat = DateFormatUtils.ISO_DATE_FORMAT;
            System.out.println(isoDateFormat.format(dateFour));

            /**
             * 不会影响原对象，第二个参数可为负数
             */
            System.out.println(DateUtils.addDays(dateOne, 15));

            /**
             * 2016 01 03 13:15:36 返回936
             * 所有大于等于fragment单位的字段将被忽略
             */
            System.out.println(DateUtils.getFragmentInSeconds(dateThree, Calendar.HOUR_OF_DAY));
            // java.lang.IllegalArgumentException: The fragment 10 is not supported
            /*System.out.println(DateUtils.getFragmentInSeconds(dateThree, Calendar.HOUR));*/

            /**
             * 一段时间 formatDuration
             * 结果 0000-00-04 13:20:10
             * 如果使用hh而非HH则返回 0000-00-04 hh:800:10
             */
            String pattern = "yyyy-MM-dd HH:mm:ss";
            long durationMillis = (10+20*60+13*3600+4*24*3600) * 1000;// 4天13小时20分钟10秒
            String formatDate = DurationFormatUtils.formatDuration(durationMillis, pattern);
            System.out.println(formatDate);

            /**
             * 一段时间 formatPeriod
             * 结果 0000-00-01 00:00:00
             * 开始日期不能大于结束日期 不然会抛出异常
             */
            long dayOneMilli = DateUtils.getFragmentInMilliseconds(dateOne, Calendar.YEAR);
            long dayTwoMilli = DateUtils.getFragmentInMilliseconds(dateTwo, Calendar.YEAR);
            System.out.println(DurationFormatUtils.formatPeriod(dayOneMilli, dayTwoMilli, "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
