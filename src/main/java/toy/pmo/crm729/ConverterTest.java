package toy.pmo.crm729;

import java.util.List;
import java.util.Map;

/**
 * Tester
 *
 * Created by cc on 16/3/19.
 */
public class ConverterTest {

    private static String templateStr =
            "这是一段测试字符串{0}这是一段测试字符串{1,number,#}这是一段测试字符串{2,number,#}这是一段测试字符串{3,number,#.##}"
            + "这是一段测试字符串{4}这是一段测试字符串{5}这是一段测试字符串{6,number,#}这是一段测试字符串{7,number,#}"
                    + "这是一段测试字符串{8,number,#}这是一段测试字符串{9,number,#}这是一段测试字符串{10,number,#}";

    private static String testSaleInfoOverviewToVo() {
        List<Map<String, Object>> data = DataGenerator.generateSummaryDataV1();

        return SaleStatisticsToVoConverter.saleInfoOverviewToVo(data, templateStr);
    }

    private static List<SaleListVo> testSaleInfoListToVo() {
        List<Map<String, Object>> saleInfoList = DataGenerator.generateSummaryDataV1();

        return SaleStatisticsToVoConverter.saleInfoListToVo(saleInfoList);
    }

    public static List<SaleCompareVo> testSaleCompareInfoToVo(int metricId) {
        List<Map<String, Object>> saleInfoList = DataGenerator.generateSummaryDataV1();

        return SaleStatisticsToVoConverter.saleCompareInfoToVo(saleInfoList, metricId);
    }

    public static SaleDetailVo testSaleInfoDetailToVo(int metricId) {
        return SaleStatisticsToVoConverter.saleInfoDetailToVo(DataGenerator.generateDetailDataV1(), metricId, 3);
    }

    public static void main(String[] args) {
        /*String str = testSaleInfoOverviewToVo();
        System.out.println(str);*/

        /*List<SaleListVo> saleListVos = testSaleInfoListToVo();
        System.out.println(saleListVos);*/

        /*for (SaleMetric saleMetric : SaleMetric.values()) {
            List<SaleCompareVo> saleCompareVos = testSaleCompareInfoToVo(saleMetric.getCode());
            System.out.println(saleCompareVos);
        }*/

        /*List<SaleCompareVo> saleCompareVos = testSaleCompareInfoToVo(SaleMetric.SALE_AMOUNT.getCode());
        System.out.println(saleCompareVos);*/

        for (SaleMetric saleMetric : SaleMetric.values()) {
            SaleDetailVo saleDetailVo = testSaleInfoDetailToVo(saleMetric.getCode());
            System.out.println(saleDetailVo);
        }
    }
}
