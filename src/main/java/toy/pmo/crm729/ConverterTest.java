package toy.pmo.crm729;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 16/3/19.
 */
public class ConverterTest {

    private static String templateStr =
            "这是一段测试字符串{0}这是一段测试字符串{1}这是一段测试字符串{2}这是一段测试字符串{3}"
            + "这是一段测试字符串{4}这是一段测试字符串{5}这是一段测试字符串{6}这是一段测试字符串{7}"
                    + "这是一段测试字符串{8}这是一段测试字符串{9}这是一段测试字符串{10}这是一段测试字符串{11}";

    private static String testSaleInfoOverviewToVo() {
        List<Map<String, Object>> data = DataGenerator.generateSummaryDataV1();

        return SaleStatisticsToVoConverter.saleInfoOverviewToVo(data, templateStr);
    }

    public static void main(String[] args) {
        testSaleInfoOverviewToVo();
    }
}
