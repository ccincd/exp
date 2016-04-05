package toy.time.joda;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Easy to use
 * Interoperable with JDK
 *
 * Created by cc on 16/4/4.
 */
public class JodaTimeDemo {

    public static void main(String[] args) {
        /**
         * 加15天 使用Calendar实现
         */
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.APRIL, 4, 23, 9, 20);
        calendar.add(Calendar.DAY_OF_MONTH, 15);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(calendar.getTime()));

        /**
         * 加15天 使用joda time实现
         */
        DateTime dateTime = new DateTime(2016, 4, 4, 23, 9, 20);
        System.out.println(dateTime.plusDays(15).toString("yyyy-MM-dd HH:mm:ss"));

        /**
         * 特殊日期
         * 2016年的2月29减1年结果 2015-02-28T12:35:23.000+08:00
         */
        DateTime febTwentyNine = new DateTime(2016, 2, 29, 12, 35, 23);
        DateTime specialFeb = febTwentyNine.minusYears(1);
        System.out.println(specialFeb.toString());

        /**
         * 某一日期45天之后的下个月当日
         */
    }
}
