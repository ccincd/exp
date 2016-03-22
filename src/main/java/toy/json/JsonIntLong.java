package toy.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * JsonIntLong
 *
 * @author chi.chen
 * @date 16-3-22
 * @time 上午10:12
 */
public class JsonIntLong {

    public static void main(String[] args) {
        String jsonStr = "[{\"sellPrice\":1300.00,\"livedRnCnt\":0,\"rejectedCnt\":0,\"livedSellPrice\":0.00,\"livedCommission\":0.00,\"cancelledCnt\":1,\"rnCnt\":2,\"livedCnt\":0,\"reportDate\":\"本期\",\"refundedCnt\":0,\"paidCnt\":1,\"biz\":\"直销现付\",\"hotelSeq\":\"beijing_city_10390\"},{\"sellPrice\":1794.00,\"livedRnCnt\":1,\"rejectedCnt\":0,\"livedSellPrice\":598.00,\"livedCommission\":70.00,\"cancelledCnt\":1,\"rnCnt\":3,\"livedCnt\":1,\"reportDate\":\"去年同期\",\"refundedCnt\":0,\"paidCnt\":2,\"biz\":\"直销现付\",\"hotelSeq\":\"beijing_city_10390\"},{\"sellPrice\":1056.00,\"livedRnCnt\":0,\"rejectedCnt\":0,\"livedSellPrice\":0.00,\"livedCommission\":0.00,\"cancelledCnt\":0,\"rnCnt\":2,\"livedCnt\":0,\"reportDate\":\"去年同期\",\"refundedCnt\":0,\"paidCnt\":1,\"biz\":\"直销预付\",\"hotelSeq\":\"beijing_city_10390\"}]";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Map<String, Object>> data = objectMapper.readValue(jsonStr,
                    new TypeReference<List<Map<String, Object>>>() {
                    });
            Object sellPrice = data.get(0).get("sellPrice");
            Object livedRnCnt = data.get(0).get("livedRnCnt");

            if (sellPrice instanceof Double) {
                System.out.println("sellPrice is double");
            }

            if (livedRnCnt instanceof Integer) {
                System.out.println("livedRnCnt is int");
            }

            if (livedRnCnt instanceof Long) {
                System.out.println("livedRnCnt is long");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
