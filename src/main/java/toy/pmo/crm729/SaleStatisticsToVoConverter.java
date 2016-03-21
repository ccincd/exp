package toy.pmo.crm729;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 360商家信息Vo转换Converter
 *
 * @author chi.chen
 * @date 16-3-14
 * @time 下午5:00
 */
public class SaleStatisticsToVoConverter {

    // 数据包含的批次（期）数
    public static final Integer DATA_BATCH_COUNT = 3;

    // SaleMetric与数据key的对应关系
    public static final Map<SaleMetric, String> metricMap = Maps.newHashMap();

    static {
        metricMap.put(SaleMetric.PAYED_COUNT, "paidCnt");
        metricMap.put(SaleMetric.ROOM_NIGHT_COUNT, "rnCnt");
        metricMap.put(SaleMetric.SALE_AMOUNT, "sellPrice");
        metricMap.put(SaleMetric.REFUND_COUNT, "refundedCnt");
        metricMap.put(SaleMetric.CANCEL_COUNT, "cancelledCnt");
        metricMap.put(SaleMetric.REJECT_COUNT, "rejectedCnt");
        metricMap.put(SaleMetric.USED_PAYED_COUNT, "livedCnt");
        metricMap.put(SaleMetric.USED_ROOM_NIGHT_COUNT, "livedRnCnt");
    }

    /**
     * 售卖情况概述数据转换
     *
     * @param data raw data
     * @param template 文案模板
     * @return 格式化后的文案
     */
    public static String saleInfoOverviewToVo(List<Map<String, Object>> data, String template) {
        checkSummaryData(data);
        Preconditions.checkArgument(StringUtils.isNotBlank(template), "售卖情况概述模板不能为空！");

        // 成单总量，实住间夜量，销售额，日期范围
        int paidCount = 0;
        int livedRoomNightCount = 0;
        double sellPrice = 0.0f;
        String dateRange;

        // 订单数量环比与同比情况，mom（month over month，环比） yoy（year over year，同比）
        String momRatioStr;
        String yoyRatioStr;
        int momPaidCount;
        int yoyPaidCount;

        // 各个业务线间夜量分布，分别为团购、直销预付、直销现付、夜销、其它
        Map<String, Integer> businessCounts = Maps.newHashMap();

        int baseIndex = 0;

        // 本期数据统计
        dateRange = (String) data.get(baseIndex).get("reportDate");
        for (int j = 0; j < BusinessType.values().length; j++) {
            Map<String, Object> dataSlice = data.get(baseIndex + j);

            String biz = (String) dataSlice.get("biz");
            Integer nightCount = Integer.parseInt((String) dataSlice.get("rnCnt"));
            businessCounts.put(biz, nightCount);

            paidCount += Integer.parseInt((String) dataSlice.get("paidCnt"));
            livedRoomNightCount += Integer.parseInt((String) dataSlice.get("livedRnCnt"));
            sellPrice += Double.valueOf((String) dataSlice.get("sellPrice"));
        }

        baseIndex += BusinessType.values().length;

        // 上期数据统计，用以计算环比数据
        momPaidCount = calcPaidCountOfOneTerm(baseIndex, data);

        baseIndex += BusinessType.values().length;

        // 去年同期数据统计，用以计算同比数据
        yoyPaidCount = calcPaidCountOfOneTerm(baseIndex, data);

        // 计算同比、环比增减信息
        int momDiffCount = paidCount - momPaidCount;
        int yoyDiffCount = paidCount - yoyPaidCount;
        momRatioStr = buildRatioStr(momDiffCount);
        yoyRatioStr = buildRatioStr(yoyDiffCount);

        // 格式化文案
        return MessageFormat.format(template, dateRange, paidCount, livedRoomNightCount, sellPrice, momRatioStr,
                yoyRatioStr, businessCounts.get(BusinessType.TEAM.getName()),
                businessCounts.get(BusinessType.DIRECT_PRE.getName()),
                businessCounts.get(BusinessType.DIRECT_CASH.getName()),
                businessCounts.get(BusinessType.NIGHT_SALE.getName()),
                businessCounts.get(BusinessType.OTHER.getName()));
    }

    /**
     * 售卖信息列表（汇总）数据转换
     *
     * @param data raw data
     * @return 列表数据
     */
    public static List<SaleListVo> saleInfoListToVo(List<Map<String, Object>> data) {
        checkSummaryData(data);

        // 各个业务指标的汇总信息
        List<SaleListVo> saleListVos = Lists.newArrayListWithCapacity(SaleMetric.values().length);
        for (SaleMetric saleMetric : SaleMetric.values()) {
            SaleListVo saleListVo = new SaleListVo();
            saleListVo.setName(saleMetric.getName());
            saleListVo.setId(saleMetric.getCode());

            saleListVos.add(saleListVo);
        }

        Map<SaleMetric, Object> counts = Maps.newHashMap();
        for (SaleMetric saleMetric : SaleMetric.values()) {// 初始化
            if (saleMetric.getCode() == SaleMetric.SALE_AMOUNT.getCode()) {
                counts.put(saleMetric, 0.0);// 销售额是Double类型
            } else {
                counts.put(saleMetric, 0);// 其余量值为Integer类型
            }
        }

        for (int i = 0; i < BusinessType.values().length; i++) {
            // 某项合作业务对应的汇总数据块，只取本期数据
            Map<String, Object> dataSlice = data.get(i);
            // 更新各项指标的汇总数据（每项指标包含各项业务）
            updateCount(counts, dataSlice);
        }

        // 将指标的汇总数据放入返回对象中
        for (SaleListVo saleListVo : saleListVos) {
            int metricId = saleListVo.getId();
            Object count = counts.get(SaleMetric.codeOf(metricId));
            saleListVo.setTotalNum(count.toString());
        }

        return saleListVos;
    }

    /**
     * 同比、环比售卖数据转换
     *
     * @param data raw data
     * @param metricId 售卖指标id
     * @return 对比数据
     */
    public static List<SaleCompareVo> saleCompareInfoToVo(List<Map<String, Object>> data, int metricId) {
        checkSummaryData(data);

        int baseIndex = 0;// 本期数据index
        int momBaseIndex = baseIndex + BusinessType.values().length;// 环比数据index
        int yoyBaseIndex = momBaseIndex + BusinessType.values().length;// 同比数据index
        List<SaleCompareVo> saleCompareVos = Lists.newArrayList();

        int index = 0;
        // 以合作业务为维度分片数据，每次处理本期、上期和去年同期的数据
        for (BusinessType businessType : BusinessType.values()) {
            SaleCompareVo saleCompareVo = new SaleCompareVo();
            saleCompareVo.setName(businessType.getName());

            SaleMetric saleMetric = SaleMetric.codeOf(metricId);
            String dataKey = metricMap.get(saleMetric);

            Map<String, Object> dataSlice = data.get(baseIndex + index);// 本期数据片
            Map<String, Object> momDataSlice = data.get(momBaseIndex + index);// 上期数据片(环比)
            Map<String, Object> yoyDataSlice = data.get(yoyBaseIndex + index);// 去年同期数据片(同比)

            // 本期、上期和去年同期数据存储Map
            Map<String, String> termsData = Maps.newHashMap();

            if (metricId == SaleMetric.SALE_AMOUNT.getCode()) {// 销售额指标，类型为Double
                Double sellPrice = Double.valueOf((String) dataSlice.get(dataKey));
                Double momSellPrice = Double.valueOf((String) momDataSlice.get(dataKey));
                Double yoySellPrice = Double.valueOf((String) yoyDataSlice.get(dataKey));

                termsData.put("本期", sellPrice.toString());
                termsData.put("上期", momSellPrice.toString());
                termsData.put("去年同期", yoySellPrice.toString());
            } else {// 其余指标，类型为Integer
                Integer counter = Integer.parseInt((String) dataSlice.get(dataKey));
                Integer momCounter = Integer.parseInt((String) momDataSlice.get(dataKey));
                Integer yoyCounter = Integer.parseInt((String) yoyDataSlice.get(dataKey));

                termsData.put("本期", counter.toString());
                termsData.put("上期", momCounter.toString());
                termsData.put("去年同期", yoyCounter.toString());
            }

            // 存储各项合作业务的售卖数据到返回对象中
            saleCompareVo.setData(termsData);
            saleCompareVos.add(saleCompareVo);

            index++;
        }

        // 以期为纬度，计算各个合作业务的汇总数据
        SaleCompareVo totalTerms = new SaleCompareVo();
        totalTerms.setName("总计");
        Map<String, String> totalTermsData = Maps.newHashMap();

        if (metricId == SaleMetric.SALE_AMOUNT.getCode()) {
            Double sellPriceTotal = 0.0;
            Double momSellPriceTotal = 0.0;
            Double yoySellPriceTotal = 0.0;

            for (int i = 0; i < BusinessType.values().length; i++) {
                sellPriceTotal += Double.valueOf(saleCompareVos.get(i).getData().get("本期"));
                momSellPriceTotal += Double.valueOf(saleCompareVos.get(i).getData().get("上期"));
                yoySellPriceTotal += Double.valueOf(saleCompareVos.get(i).getData().get("去年同期"));
            }

            totalTermsData.put("本期", sellPriceTotal.toString());
            totalTermsData.put("上期", momSellPriceTotal.toString());
            totalTermsData.put("去年同期", yoySellPriceTotal.toString());
        } else {
            Integer counterTotal = 0;
            Integer momCounterTotal = 0;
            Integer yoyCounterTotal = 0;

            for (int i = 0; i < BusinessType.values().length; i++) {
                counterTotal += Integer.parseInt(saleCompareVos.get(i).getData().get("本期"));
                momCounterTotal += Integer.parseInt(saleCompareVos.get(i).getData().get("上期"));
                yoyCounterTotal += Integer.parseInt(saleCompareVos.get(i).getData().get("去年同期"));
            }

            totalTermsData.put("本期", counterTotal.toString());
            totalTermsData.put("上期", momCounterTotal.toString());
            totalTermsData.put("去年同期", yoyCounterTotal.toString());
        }

        // 存储汇总数据到返回对象中
        totalTerms.setData(totalTermsData);
        saleCompareVos.add(totalTerms);

        return saleCompareVos;
    }

    /**
     * 售卖信息详情数据转换
     *
     * @param data raw data
     * @param metricId 售卖指标id
     * @param duration 查询天数
     * @return 详情数据
     */
    public static SaleDetailVo saleInfoDetailToVo(List<Map<String, Object>> data, int metricId, int duration) {
        checkDetailData(data, duration);

        // 日期列表
        List<String> dates = Lists.newArrayListWithCapacity(duration);
        // 以合作业务为维度的汇总数据，如团购在一段日期范围内的销售总量
        Map<String, String> totals = Maps.newHashMapWithExpectedSize(BusinessType.values().length);
        // 以合作业务为维度的详细数据，每个合作业务包含一段日期范围内每天的销售量列表
        Map<String, List<String>> countsMap = Maps.newHashMapWithExpectedSize(BusinessType.values().length);
        // 初始化
        for (BusinessType businessType : BusinessType.values()) {
            countsMap.put(businessType.getName(), Lists.<String> newArrayListWithCapacity(duration));
            totals.put(businessType.getName(), StringUtils.EMPTY);
        }

        for (int i = 0; i < duration; i++) {// 每天的数据
            for (int j = 0; j < BusinessType.values().length; j++) {// 每天中的每项合作业务数据
                Map<String, Object> dataSlice = data.get(i * BusinessType.values().length + j);
                scanDataSlice(dataSlice, countsMap, metricId);// 扫描数据片并转换

                if (j == 0) {// 记录当日的日期
                    String reportDate = (String) dataSlice.get("reportDate");
                    dates.add(reportDate);
                }
            }
        }

        // 计算以合作业务为维度的汇总数据
        calcTotalsData(countsMap, totals, metricId);

        // 初始化总计数据容器（每项为各个合作业务相应数据的汇总）
        Object totalWhole;
        List<Object> totalsPerDay = Lists.newArrayListWithExpectedSize(duration);
        if (metricId == SaleMetric.SALE_AMOUNT.getCode()) {
            totalWhole = 0.0;
            for (int i = 0; i < duration; i++) {
                totalsPerDay.add(0.0);
            }
        } else {
            totalWhole = 0;
            for (int i = 0; i < duration; i++) {
                totalsPerDay.add(0);
            }
        }

        // 根据以业务为维度的汇总数据和详细数据计算总计数据
        for (BusinessType businessType : BusinessType.values()) {
            List<String> countsPerBiz = countsMap.get(businessType.getName());
            String totalCountPerBiz = totals.get(businessType.getName());

            if (metricId == SaleMetric.SALE_AMOUNT.getCode()) {
                totalWhole = (Double) totalWhole + Double.valueOf(totalCountPerBiz);
            } else {
                totalWhole = (Integer) totalWhole + Integer.parseInt(totalCountPerBiz);
            }

            for (int i = 0; i < countsPerBiz.size(); i++) {
                if (metricId == SaleMetric.SALE_AMOUNT.getCode()) {
                    totalsPerDay.set(i, (Double) totalsPerDay.get(i) + Double.valueOf(countsPerBiz.get(i)));
                    totalWhole = (Double) totalWhole + Double.valueOf(countsPerBiz.get(i));
                } else {
                    totalsPerDay.set(i, (Integer) totalsPerDay.get(i) + Integer.parseInt(countsPerBiz.get(i)));
                    totalWhole = (Integer) totalWhole + Integer.parseInt(countsPerBiz.get(i));
                }
            }
        }

        // 将计算出的总计数据存入SaleDetailPerBizVo对象中
        SaleDetailPerBizVo totalBizVo = new SaleDetailPerBizVo();
        totalBizVo.setBizName("总计");
        totalBizVo.setTotal(totalWhole.toString());
        List<String> counts = Lists.newArrayListWithCapacity(duration);
        for (int i = 0; i < duration; i++) {
            counts.add(totalsPerDay.get(i).toString());
        }
        totalBizVo.setCounts(counts);

        // 填充返回结果对象
        SaleDetailVo saleDetailVo = new SaleDetailVo();
        saleDetailVo.setDates(dates);
        List<SaleDetailPerBizVo> detailPerBizVos = Lists.newArrayListWithCapacity(BusinessType.values().length);
        for (BusinessType businessType : BusinessType.values()) {
            SaleDetailPerBizVo perBizVo = new SaleDetailPerBizVo();

            perBizVo.setBizName(businessType.getName());
            perBizVo.setCounts(countsMap.get(businessType.getName()));
            perBizVo.setTotal(totals.get(businessType.getName()));

            detailPerBizVos.add(perBizVo);
        }

        detailPerBizVos.add(totalBizVo);
        saleDetailVo.setSaleInfo(detailPerBizVos);

        return saleDetailVo;
    }

    private static void checkSummaryData(List<Map<String, Object>> data) {
        Preconditions.checkNotNull(data, "数据不能为空！");
        // data应当包含本期、上期以及去年同期三批数据，每批数据包含所有SaleBusinessType类型
        Preconditions.checkArgument(data.size() == BusinessType.values().length * DATA_BATCH_COUNT, "数据格式有误");
    }

    private static void checkDetailData(List<Map<String, Object>> data, int duration) {
        Preconditions.checkNotNull(data, "数据不能为空！");
        // data包含的数据批次应为所有业务类型数的整数倍
        Preconditions.checkArgument(data.size() % BusinessType.values().length == 0, "数据格式有误");

        int batchCount = data.size() / BusinessType.values().length;
        Preconditions.checkArgument(duration == batchCount, "数据不完整");
    }

    private static String buildRatioStr(int diffCount) {
        if (diffCount > 0) {
            return "增长" + diffCount + "%";
        } else if (diffCount < 0) {
            return "减少" + (-diffCount) + "%";
        } else {
            return "相同";
        }
    }

    private static void updateCount(Map<SaleMetric, Object> counts, Map<String, Object> dataSlice) {
        for (SaleMetric saleMetric : SaleMetric.values()) {
            String dataKey = metricMap.get(saleMetric);

            String dataStr = (String) dataSlice.get(dataKey);

            if (saleMetric.getCode() == SaleMetric.SALE_AMOUNT.getCode()) {
                Double newCount = (Double) counts.get(saleMetric) + Double.valueOf(dataStr);
                counts.put(saleMetric, newCount);
            } else {
                Integer newCount = (Integer) counts.get(saleMetric) + Integer.parseInt(dataStr);
                counts.put(saleMetric, newCount);
            }
        }
    }

    private static void scanDataSlice(Map<String, Object> dataSlice, Map<String, List<String>> countsMap,
            int metricId) {
        String dataKey = metricMap.get(SaleMetric.codeOf(metricId));

        Object count;
        String dataStr = (String) dataSlice.get(dataKey);
        if (metricId == SaleMetric.SALE_AMOUNT.getCode()) {
            count = Double.valueOf(dataStr);
        } else {
            count = Integer.parseInt(dataStr);
        }

        String sliceBizName = (String) dataSlice.get("biz");
        countsMap.get(sliceBizName).add(count.toString());
    }

    private static void calcTotalsData(Map<String, List<String>> countsMap, Map<String, String> totals, int metricId) {
        for (Map.Entry<String, List<String>> entry : countsMap.entrySet()) {
            if (metricId == SaleMetric.SALE_AMOUNT.getCode()) {
                Double total = 0.0;
                for (String dataStr : entry.getValue()) {
                    total += Double.valueOf(dataStr);
                }
                totals.put(entry.getKey(), total.toString());
            } else {
                Integer total = 0;
                for (String dataStr : entry.getValue()) {
                    total += Integer.parseInt(dataStr);
                }
                totals.put(entry.getKey(), total.toString());
            }
        }
    }

    private static int calcPaidCountOfOneTerm(int baseIndex, List<Map<String, Object>> data) {
        int totalPaidCount = 0;

        for (int j = 0; j < BusinessType.values().length; j++) {
            Map<String, Object> dataSlice = data.get(baseIndex + j);

            totalPaidCount += Integer.parseInt((String) dataSlice.get("paidCnt"));
        }

        return totalPaidCount;
    }
}
