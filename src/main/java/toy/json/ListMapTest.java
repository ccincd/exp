package toy.json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * ListMapTest
 *
 * @author chi.chen
 * @date 16-3-11
 * @time 上午9:58
 */
public class ListMapTest {

    public static void main(String[] args) {
        List<Map<String, Object>> mapList = Lists.newArrayList();

        Map<String, Object> mapOne = Maps.newHashMap();
        mapOne.put("reportDate", "2016-03-01");
        mapOne.put("hotelSeq", "beijing_city_4066");
        mapOne.put("biz", "直销预付");
        mapList.add(mapOne);

        Map<String, Object> mapTwo = Maps.newHashMap();
        mapTwo.put("reportDate", "2016-03-01");
        mapTwo.put("hotelSeq", "beijing_city_4066");
        mapTwo.put("biz", "夜宵");
        mapList.add(mapTwo);

        String jsonStr = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonStr = objectMapper.writeValueAsString(mapList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jsonStr);
    }
}
