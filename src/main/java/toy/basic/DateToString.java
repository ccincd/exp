package toy.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
