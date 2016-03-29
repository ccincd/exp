/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 从已序列化好的value值中只能反序列化出来Double而非BigDecimal
 *
 * @author chichen  Date: 16-3-29 Time: 下午3:13
 */
public class ObjectInfoPresentation {

    public static void main(String[] args) {
        String jsonStr = "[{\"sellPrice\":117.00,\"livedRnCnt\":1.0,\"rejectedCnt\":0.0,\"livedSellPrice\":117.00,\"livedCommission\":11.70,\"rnCnt\":1.0,\"cancelledCnt\":0.0,\"reportDate\":\"本期\",\"livedCnt\":1.0,\"refundedCnt\":0.0,\"paidCnt\":1.0,\"biz\":\"全站\",\"hotelSeq\":\"beijing_city_21638\"},{\"sellPrice\":117.00,\"livedRnCnt\":1.0,\"rejectedCnt\":0.0,\"livedSellPrice\":117.00,\"livedCommission\":11.70,\"rnCnt\":1.0,\"cancelledCnt\":0.0,\"reportDate\":\"本期\",\"livedCnt\":1.0,\"refundedCnt\":0.0,\"paidCnt\":1.0,\"biz\":\"直销预付\",\"hotelSeq\":\"beijing_city_21638\"},{\"sellPrice\":440.00,\"livedRnCnt\":2.0,\"rejectedCnt\":0.0,\"livedSellPrice\":440.00,\"livedCommission\":44.70,\"rnCnt\":3.0,\"cancelledCnt\":0.0,\"reportDate\":\"上期\",\"livedCnt\":2.0,\"refundedCnt\":0.0,\"paidCnt\":2.0,\"biz\":\"全站\",\"hotelSeq\":\"beijing_city_21638\"},{\"sellPrice\":440.00,\"livedRnCnt\":2.0,\"rejectedCnt\":0.0,\"livedSellPrice\":440.00,\"livedCommission\":44.70,\"rnCnt\":3.0,\"cancelledCnt\":0.0,\"reportDate\":\"上期\",\"livedCnt\":2.0,\"refundedCnt\":0.0,\"paidCnt\":2.0,\"biz\":\"直销预付\",\"hotelSeq\":\"beijing_city_21638\"},{\"sellPrice\":360.00,\"livedRnCnt\":0.0,\"rejectedCnt\":0.0,\"livedSellPrice\":0.00,\"livedCommission\":0.00,\"rnCnt\":3.0,\"cancelledCnt\":0.0,\"reportDate\":\"去年同期\",\"livedCnt\":0.0,\"refundedCnt\":0.0,\"paidCnt\":3.0,\"biz\":\"其它\",\"hotelSeq\":\"beijing_city_21638\"},{\"sellPrice\":360.00,\"livedRnCnt\":0.0,\"rejectedCnt\":0.0,\"livedSellPrice\":0.00,\"livedCommission\":0.00,\"rnCnt\":3.0,\"cancelledCnt\":0.0,\"reportDate\":\"去年同期\",\"livedCnt\":0.0,\"refundedCnt\":0.0,\"paidCnt\":3.0,\"biz\":\"全站\",\"hotelSeq\":\"beijing_city_21638\"}]";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Map<String, Object>> result = objectMapper.readValue(jsonStr, new TypeReference<List<Map<String, Object>>>() {});

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
