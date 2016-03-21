package toy.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * DateToString
 *
 * @author chi.chen
 * @date 16-3-21
 * @time 下午3:03
 */
public class DateToString {

    public static void main(String[] args) {
        String dateStr = "2016-03-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(dateStr);
            System.out.println(date.toString());

            System.out.println(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, List<Map<String, Object>>> mapGroup(List<Map<String, Object>> dataList,
            String groupField) {
        Map<String, List<Map<String, Object>>> resultMap = new LinkedHashMap<>();
        for (Map<String, Object> map : dataList) {
            String groupValue = (String) map.get(groupField);
            if (resultMap.containsKey(groupValue)) {
                resultMap.get(map.get(groupField)).add(map);
            } else {
                List<Map<String, Object>> list = new ArrayList<>();
                list.add(map);
                resultMap.put(groupValue, list);
            }
        }

        return resultMap;
    }
}
