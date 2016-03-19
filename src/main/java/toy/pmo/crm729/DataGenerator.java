package toy.pmo.crm729;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 16/3/18.
 */
public class DataGenerator {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static final String summaryDataJsonStrV1 = "[\n" + "     {\n"
            + "     \"reportDate\":\"2016-03-01至2016-03-31\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"直销预付\",\n" + "     \"paidCnt\":\"1822\",\n" + "     \"rnCnt\" :\"2430\",\n"
            + "     \"sellPrice\":\"1399680.00\",\n" + "     \"refundedCnt\" :\"84\",\n"
            + "     \"cancelledCnt\":\"76\",\n" + "     \"rejectedCnt\":\"30\",\n" + "     \"livedCnt\":\"1632\",\n"
            + "     \"livedRnCnt\":\"2022\",\n" + "     \"livedSellPrice\":\"1037886.00\",\n"
            + "     \"livedCommission\":\"109840.68\"\n" + "     },\n" + "     {\n"
            + "     \"reportDate\":\"2016-03-01至2016-03-31\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"夜销\",\n" + "     \"paidCnt\":\"10\",\n" + "     \"rnCnt\" :\"10\",\n"
            + "     \"sellPrice\":\"5842.00\",\n" + "     \"refundedCnt\" :\"1\",\n" + "     \"cancelledCnt\":\"0\",\n"
            + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"9\",\n" + "     \"livedRnCnt\":\"9\",\n"
            + "     \"livedSellPrice\":\"5382.00\",\n" + "     \"livedCommission\":\"478.50\"\n" + "     },\n"
            + "     {\n" + "     \"reportDate\":\"2016-03-01至2016-03-31\",\n"
            + "     \"hotelSeq\":\"beijing_city_4066\",\n" + "     \"biz\": \"团购\",\n" + "     \"paidCnt\":\"5\",\n"
            + "     \"rnCnt\" :\"7\",\n" + "     \"sellPrice\":\"3850.00\",\n" + "     \"refundedCnt\" :\"0\",\n"
            + "     \"cancelledCnt\":\"2\",\n" + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"3\",\n"
            + "     \"livedRnCnt\":\"5\",\n" + "     \"livedSellPrice\":\"1380\",\n"
            + "     \"livedCommission\":\"326.80\"\n" + "     },\n" + "     {\n"
            + "     \"reportDate\":\"2016-03-01至2016-03-31\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"直销现付\",\n" + "     \"paidCnt\":\"20\",\n" + "     \"rnCnt\" :\"26\",\n"
            + "     \"sellPrice\":\"6294.00\",\n" + "     \"refundedCnt\" :\"2\",\n" + "     \"cancelledCnt\":\"1\",\n"
            + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"15\",\n" + "     \"livedRnCnt\":\"19\",\n"
            + "     \"livedSellPrice\":\"5172.00\",\n" + "     \"livedCommission\":\"418.50\"\n" + "     },\n"
            + "     {\n" + "     \"reportDate\":\"2016-03-01至2016-03-31\",\n"
            + "     \"hotelSeq\":\"beijing_city_4066\",\n" + "     \"biz\": \"其他\",\n" + "     \"paidCnt\":\"15\",\n"
            + "     \"rnCnt\" :\"17\",\n" + "     \"sellPrice\":\"3965.26\",\n" + "     \"refundedCnt\" :\"0\",\n"
            + "     \"cancelledCnt\":\"2\",\n" + "     \"rejectedCnt\":\"1\",\n" + "     \"livedCnt\":\"13\",\n"
            + "     \"livedRnCnt\":\"15\",\n" + "     \"livedSellPrice\":\"3245.87\",\n"
            + "     \"livedCommission\":\"366.80\"\n" + "     },\n" + "     {\n"
            + "     \"reportDate\":\"2016-01-29至2016-02-28\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"直销预付\",\n" + "     \"paidCnt\":\"1822\",\n" + "     \"rnCnt\" :\"2430\",\n"
            + "     \"sellPrice\":\"1399680.00\",\n" + "     \"refundedCnt\" :\"84\",\n"
            + "     \"cancelledCnt\":\"76\",\n" + "     \"rejectedCnt\":\"30\",\n" + "     \"livedCnt\":\"1632\",\n"
            + "     \"livedRnCnt\":\"2022\",\n" + "     \"livedSellPrice\":\"1037886.00\",\n"
            + "     \"livedCommission\":\"109840.68\"\n" + "     },\n" + "     {\n"
            + "     \"reportDate\":\"2016-01-29至2016-02-28\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"夜销\",\n" + "     \"paidCnt\":\"10\",\n" + "     \"rnCnt\" :\"10\",\n"
            + "     \"sellPrice\":\"5842.00\",\n" + "     \"refundedCnt\" :\"1\",\n" + "     \"cancelledCnt\":\"0\",\n"
            + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"9\",\n" + "     \"livedRnCnt\":\"9\",\n"
            + "     \"livedSellPrice\":\"5382.00\",\n" + "     \"livedCommission\":\"478.50\"\n" + "     },\n"
            + "     {\n" + "     \"reportDate\":\"2016-01-29至2016-02-28\",\n"
            + "     \"hotelSeq\":\"beijing_city_4066\",\n" + "     \"biz\": \"团购\",\n" + "     \"paidCnt\":\"5\",\n"
            + "     \"rnCnt\" :\"7\",\n" + "     \"sellPrice\":\"3850.00\",\n" + "     \"refundedCnt\" :\"0\",\n"
            + "     \"cancelledCnt\":\"2\",\n" + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"3\",\n"
            + "     \"livedRnCnt\":\"5\",\n" + "     \"livedSellPrice\":\"1380\",\n"
            + "     \"livedCommission\":\"326.80\"\n" + "     },\n" + "     {\n"
            + "     \"reportDate\":\"2016-01-29至2016-02-28\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"直销现付\",\n" + "     \"paidCnt\":\"20\",\n" + "     \"rnCnt\" :\"26\",\n"
            + "     \"sellPrice\":\"6294.00\",\n" + "     \"refundedCnt\" :\"2\",\n" + "     \"cancelledCnt\":\"1\",\n"
            + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"15\",\n" + "     \"livedRnCnt\":\"19\",\n"
            + "     \"livedSellPrice\":\"5172.00\",\n" + "     \"livedCommission\":\"418.50\"\n" + "     },\n"
            + "     {\n" + "     \"reportDate\":\"2016-01-29至2016-02-28\",\n"
            + "     \"hotelSeq\":\"beijing_city_4066\",\n" + "     \"biz\": \"其他\",\n" + "     \"paidCnt\":\"15\",\n"
            + "     \"rnCnt\" :\"17\",\n" + "     \"sellPrice\":\"3965.26\",\n" + "     \"refundedCnt\" :\"0\",\n"
            + "     \"cancelledCnt\":\"2\",\n" + "     \"rejectedCnt\":\"1\",\n" + "     \"livedCnt\":\"13\",\n"
            + "     \"livedRnCnt\":\"15\",\n" + "     \"livedSellPrice\":\"3245.87\",\n"
            + "     \"livedCommission\":\"366.80\"\n" + "     },\n" + "     {\n"
            + "     \"reportDate\":\"2015-03-01至2015-03-31\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"直销预付\",\n" + "     \"paidCnt\":\"1822\",\n" + "     \"rnCnt\" :\"2430\",\n"
            + "     \"sellPrice\":\"1399680.00\",\n" + "     \"refundedCnt\" :\"84\",\n"
            + "     \"cancelledCnt\":\"76\",\n" + "     \"rejectedCnt\":\"30\",\n" + "     \"livedCnt\":\"1632\",\n"
            + "     \"livedRnCnt\":\"2022\",\n" + "     \"livedSellPrice\":\"1037886.00\",\n"
            + "     \"livedCommission\":\"109840.68\"\n" + "     },\n" + "     {\n"
            + "     \"reportDate\":\"2015-03-01至2015-03-31\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"夜销\",\n" + "     \"paidCnt\":\"10\",\n" + "     \"rnCnt\" :\"10\",\n"
            + "     \"sellPrice\":\"5842.00\",\n" + "     \"refundedCnt\" :\"1\",\n" + "     \"cancelledCnt\":\"0\",\n"
            + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"9\",\n" + "     \"livedRnCnt\":\"9\",\n"
            + "     \"livedSellPrice\":\"5382.00\",\n" + "     \"livedCommission\":\"478.50\"\n" + "     },\n"
            + "     {\n" + "     \"reportDate\":\"2015-03-01至2015-03-31\",\n"
            + "     \"hotelSeq\":\"beijing_city_4066\",\n" + "     \"biz\": \"团购\",\n" + "     \"paidCnt\":\"5\",\n"
            + "     \"rnCnt\" :\"7\",\n" + "     \"sellPrice\":\"3850.00\",\n" + "     \"refundedCnt\" :\"0\",\n"
            + "     \"cancelledCnt\":\"2\",\n" + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"3\",\n"
            + "     \"livedRnCnt\":\"5\",\n" + "     \"livedSellPrice\":\"1380\",\n"
            + "     \"livedCommission\":\"326.80\"\n" + "     },\n" + "     {\n"
            + "     \"reportDate\":\"2015-03-01至2015-03-31\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"直销现付\",\n" + "     \"paidCnt\":\"20\",\n" + "     \"rnCnt\" :\"26\",\n"
            + "     \"sellPrice\":\"6294.00\",\n" + "     \"refundedCnt\" :\"2\",\n" + "     \"cancelledCnt\":\"1\",\n"
            + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"15\",\n" + "     \"livedRnCnt\":\"19\",\n"
            + "     \"livedSellPrice\":\"5172.00\",\n" + "     \"livedCommission\":\"418.50\"\n" + "     },\n"
            + "     {\n" + "     \"reportDate\":\"2015-03-01至2015-03-31\",\n"
            + "     \"hotelSeq\":\"beijing_city_4066\",\n" + "     \"biz\": \"其他\",\n" + "     \"paidCnt\":\"15\",\n"
            + "     \"rnCnt\" :\"17\",\n" + "     \"sellPrice\":\"3965.26\",\n" + "     \"refundedCnt\" :\"0\",\n"
            + "     \"cancelledCnt\":\"2\",\n" + "     \"rejectedCnt\":\"1\",\n" + "     \"livedCnt\":\"13\",\n"
            + "     \"livedRnCnt\":\"15\",\n" + "     \"livedSellPrice\":\"3245.87\",\n"
            + "     \"livedCommission\":\"366.80\"\n" + "     }\n" + "]";

    public static final String detailDataJsonStrV1 = "[\n" + "     {\n"
            + "     \"reportDate\":\"2016-03-01至2016-03-31\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"直销预付\",\n" + "     \"paidCnt\":\"1822\",\n" + "     \"rnCnt\" :\"2430\",\n"
            + "     \"sellPrice\":\"1399680.00\",\n" + "     \"refundedCnt\" :\"84\",\n"
            + "     \"cancelledCnt\":\"76\",\n" + "     \"rejectedCnt\":\"30\",\n" + "     \"livedCnt\":\"1632\",\n"
            + "     \"livedRnCnt\":\"2022\",\n" + "     \"livedSellPrice\":\"1037886.00\",\n"
            + "     \"livedCommission\":\"109840.68\"\n" + "     },\n" + "     {\n"
            + "     \"reportDate\":\"2016-03-01至2016-03-31\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"夜销\",\n" + "     \"paidCnt\":\"10\",\n" + "     \"rnCnt\" :\"10\",\n"
            + "     \"sellPrice\":\"5842.00\",\n" + "     \"refundedCnt\" :\"1\",\n" + "     \"cancelledCnt\":\"0\",\n"
            + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"9\",\n" + "     \"livedRnCnt\":\"9\",\n"
            + "     \"livedSellPrice\":\"5382.00\",\n" + "     \"livedCommission\":\"478.50\"\n" + "     },\n"
            + "     {\n" + "     \"reportDate\":\"2016-03-01至2016-03-31\",\n"
            + "     \"hotelSeq\":\"beijing_city_4066\",\n" + "     \"biz\": \"团购\",\n" + "     \"paidCnt\":\"5\",\n"
            + "     \"rnCnt\" :\"7\",\n" + "     \"sellPrice\":\"3850.00\",\n" + "     \"refundedCnt\" :\"0\",\n"
            + "     \"cancelledCnt\":\"2\",\n" + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"3\",\n"
            + "     \"livedRnCnt\":\"5\",\n" + "     \"livedSellPrice\":\"1380\",\n"
            + "     \"livedCommission\":\"326.80\"\n" + "     },\n" + "     {\n"
            + "     \"reportDate\":\"2016-03-01至2016-03-31\",\n" + "     \"hotelSeq\":\"beijing_city_4066\",\n"
            + "     \"biz\": \"直销现付\",\n" + "     \"paidCnt\":\"20\",\n" + "     \"rnCnt\" :\"26\",\n"
            + "     \"sellPrice\":\"6294.00\",\n" + "     \"refundedCnt\" :\"2\",\n" + "     \"cancelledCnt\":\"1\",\n"
            + "     \"rejectedCnt\":\"0\",\n" + "     \"livedCnt\":\"15\",\n" + "     \"livedRnCnt\":\"19\",\n"
            + "     \"livedSellPrice\":\"5172.00\",\n" + "     \"livedCommission\":\"418.50\"\n" + "     },\n"
            + "     {\n" + "     \"reportDate\":\"2016-03-01至2016-03-31\",\n"
            + "     \"hotelSeq\":\"beijing_city_4066\",\n" + "     \"biz\": \"其他\",\n" + "     \"paidCnt\":\"15\",\n"
            + "     \"rnCnt\" :\"17\",\n" + "     \"sellPrice\":\"3965.26\",\n" + "     \"refundedCnt\" :\"0\",\n"
            + "     \"cancelledCnt\":\"2\",\n" + "     \"rejectedCnt\":\"1\",\n" + "     \"livedCnt\":\"13\",\n"
            + "     \"livedRnCnt\":\"15\",\n" + "     \"livedSellPrice\":\"3245.87\",\n"
            + "     \"livedCommission\":\"366.80\"\n" + "     }\n" + "]";

    private static List<Map<String, Object>> generateData(String jsonStr) {
        try {
            List<Map<String, Object>> data = objectMapper.readValue(jsonStr,
                    new TypeReference<List<Map<String, Object>>>() {});
            System.out.println(data);

            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Map<String, Object>> generateSummaryDataV1() {
        return generateData(summaryDataJsonStrV1);
    }

    public static List<Map<String, Object>> generateDetailDataV1() {
        return generateData(detailDataJsonStrV1);
    }

    public static void main(String[] args) {
        // generateSummaryData();
    }
}
