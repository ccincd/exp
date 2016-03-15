package toy.time;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * JodaTimeDayTest
 *
 * @author chi.chen
 * @date 16-3-15
 * @time 下午6:57
 */
public class JodaTimeDayTest {

    /**
     * 如果不加L则会当成int来计算从而造成数据溢出
     */
    // public static long NINETY_DAYS_MILLI = 90 * 24 * 3600 * 1000L;

    public static void main(String[] args) {
        String dayStrBegin = "2016-03-14";
        String dayStrEnd = "2016-03-20";

        String datePattern = "yyyy-MM-dd";
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern(datePattern);

        LocalDate localDateStart = dateFormatter.parseLocalDate(dayStrBegin);
        LocalDate localDateEnd = dateFormatter.parseLocalDate(dayStrEnd);

        // 比较大小，不返回相差的天数
        // localDateStart.compareTo(localDateEnd);

        // 减去一个Period，不能应用于localDateEnd
        // localDateStart.minus(ReadablePeriod);

        // minus的入参是ReadablePeriod
        // Duration ninetyDays = new Duration(NINETY_DAYS_MILLI);

        /*
         * Period ninetyDays = new Period(NINETY_DAYS_MILLI); LocalDate limitStart = localDateEnd.minus(ninetyDays); if
         * (localDateStart.compareTo(limitStart) != -1) { System.out.println("Hi, there"); }
         */

        Days durationDays = Days.daysBetween(localDateStart, localDateEnd);
        if (durationDays.getDays() <= 90) {
            System.out.println("Hi, there");
        }
    }
}
