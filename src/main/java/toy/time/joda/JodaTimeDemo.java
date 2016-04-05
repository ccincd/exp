package toy.time.joda;

import org.joda.time.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Easy to use
 * Interoperable with JDK
 *
 * Created by cc on 16/4/4.
 */
public class JodaTimeDemo {

    public static DateTime nowDateTime = new DateTime();

    public static Date nowDate = new Date(System.currentTimeMillis());

    public static final long nowMilli = System.currentTimeMillis();

    public static SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static SimpleDateFormat secondFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final String DAY_FORMAT = "yyyy-MM-dd";

    public static final String SECOND_FORMAT = "yyyy-MM-dd HH:mm:ss";

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
         * 某一日期45天之后的下个月当日所在的周的最后一天
         * 如果设置为2015年则会抛出 org.joda.time.IllegalFieldValueException
         */
        try {
            DateTime complexTrial = new DateTime(2016, 2, 29, 12, 35, 23);
            String complexTrialStr = complexTrial.plusDays(45).plusMonths(1).
                    dayOfWeek().withMaximumValue().toString("yyyy-MM-dd HH:mm:ss");
            System.out.println(complexTrialStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * joda time和JDK的互操作性
         */
        Calendar compatibleCalendar = Calendar.getInstance();
        compatibleCalendar.setTime(dateTime.toDate());
        System.out.println(secondFormat.format(compatibleCalendar.getTime()));
        System.out.println(secondFormat.format(dateTime.toDate()));

        DateTime compatibleDateTime = new DateTime(nowDate);
        System.out.println(compatibleDateTime.toString(SECOND_FORMAT));

        DateTime nowDateTimeFromMilli = new DateTime(nowMilli);
        System.out.println(nowDateTimeFromMilli.toString(SECOND_FORMAT));

        /**
         * 如果使用2016 06 27会抛出异常
         */
        String graduate = "2016-06-27";
        DateTime graduateDate = new DateTime(graduate);
        System.out.println(graduateDate.toString(DAY_FORMAT));

        /**
         * LocalTime和LocalDate
         * 某个时间片段和某个时刻
         */
        LocalDate birthDay = new LocalDate(1988, 9, 27);
        System.out.println(birthDay);

        LocalTime birthTime = new LocalTime(20, 45, 36, 125);
        System.out.println(birthTime);

        /**
         * 某个时间跨度
         *
         * Duration：这个类表示一个绝对的精确跨度，使用毫秒为单位。这个类提供的方法可以用于通过标准的数学转换
         * （比如 1 分钟 = 60 秒，1 天 = 24 小时），将时间跨度转换为标准单位（比如秒、分和小时）。
         *
         * Period：这个类表示与 Duration 相同的概念，但是以人们比较熟悉的单位表示，比如年、月、周。
         * 您可以在以下情况使用 Period：您并不关心这段时期必须在何时发生，
         * 或者您更关心检索单个字段的能力，这些字段描述由 Period 封装的时间跨度。
         *
         * Interval：这个类表示一个特定的时间跨度，将使用一个明确的时刻界定这段时间跨度的范围。Interval 为半开 区间，
         * 这表示由 Interval 封装的时间跨度包括这段时间的起始时刻，但是不包含结束时刻。
         */
        DateTime start = new DateTime(2011, 2, 26, 21, 35);
        DateTime end = new DateTime(2015, 7, 1, 8, 45);
        Duration duration = new Duration(start, end);
        Period period = new Period(start, end);
        Interval interval = new Interval(start, end);

        System.out.println(interval.contains(new DateTime(2012, 5, 20, 15, 35)));
        System.out.println(duration.getMillis());

        System.out.println(period.getYears());
        System.out.println(period.getDays());
        System.out.println(period.getMillis());
        // System.out.println(period.get(DurationFieldType.days()));

        /**
         * 计算上个月的最后一天
         *
         * dayOfMoth返回的是Property
         * 类似的有 yearOfCentury dayOfYear monthOfYear dayOfWeek millisOfDay
         */
        DateTime inLuguLake = new DateTime("2015-01-01");
        System.out.println(inLuguLake.minusMonths(1).dayOfMonth().
                withMaximumValue().toString(DAY_FORMAT));

        /**
         * 11月中第一个星期二
         */
        LocalDate inLuguLakeLocal = new LocalDate("2015-01-01");
        LocalDate firstTuesdayInNovember = inLuguLakeLocal.monthOfYear().setCopy(11).
                dayOfMonth().withMinimumValue().
                plusDays(6).dayOfWeek().setCopy(1).plusDays(1);
        System.out.println(firstTuesdayInNovember);

        /**
         * 这个月的最后一个星期二
         */
        LocalDate nowLocalDate = new LocalDate(nowDate);
        System.out.println(nowLocalDate.dayOfMonth().withMaximumValue().
                minusDays(1).dayOfWeek().setCopy(2).toString(DAY_FORMAT));

        /**
         * 五年后第二个月的最后一天
         */
        LocalDate complexCalc = inLuguLakeLocal.plusYears(5).monthOfYear().setCopy(2).
                dayOfMonth().withMaximumValue();
        System.out.println(complexCalc);

        /**
         * 本月的第一天的凌晨三点进行批处理任务
         */
        System.out.println(nowDateTime.withTimeAtStartOfDay().plusHours(3).toDate());

        /**
         * 两个日期相差几天
         */
        System.out.println(nowLocalDate.dayOfMonth().getDifference(inLuguLake));

        System.out.println(Days.daysBetween(nowDateTime, inLuguLake).getDays());
        System.out.println(Days.daysBetween(inLuguLake, nowDateTime).getDays());

        /*Date badDate = new Date(2013, 1, 6);
        System.out.println(badDate);*/

        /**
         * 获取今天的开始时间
         */
        System.out.println(nowDateTime.withTimeAtStartOfDay().toString(SECOND_FORMAT));

        /**
         * 获取今天的结束时间
         */
        System.out.println(nowDateTime.millisOfDay().withMaximumValue().toString(SECOND_FORMAT));

        /**
         * 现在离今天结束还有多长时间
         */
        Period millisLeft = new Period(
                nowDateTime.millisOfDay().withMaximumValue().getMillis() - nowDateTime.getMillis());
        System.out.println(millisLeft.getHours());
    }
}
