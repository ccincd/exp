package Time;

import org.joda.time.DateTime;

/**
 * JodaTimeTest
 *
 * @author chi.chen
 * @date 16-1-26
 * @time 下午3:51
 */
public class JodaTimeTest {

    public static void main(String[] args) {
        DateTime currentTime = new DateTime();
        System.out.println(currentTime.toString("E MM/dd/yyyy HH:mm:ss.SSS"));

        long l = System.currentTimeMillis();
        DateTime fromMilli = new DateTime(l);
        System.out.println(fromMilli.toString("dd-MM-yyyy HH:mm:ss"));

        DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        System.out.println(dateTime.plusDays(90).toString("E MM/dd/yyyy HH:mm:ss.SSS"));

        String timeString = "2006-01-26T13:30:00+08:00";
        DateTime dateTime1 = new DateTime(timeString);
        timeString = "2006-01-26T06:15:30.000";
        DateTime dateTime2 = new DateTime(timeString);

        System.out.println(dateTime1.toString("E MM/dd/yyyy HH:mm:ss.SSS"));
        System.out.println(dateTime2.toString("E MM/dd/yyyy HH:mm:ss.SSS"));
    }
}
