package toy.time.joda;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.List;

/**
 * JodaTimeDurationTest
 *
 * @author chi.chen
 * @date 16-3-17
 * @time 上午10:57
 */
public class JodaTimeDurationTest {

    /**
     * 查询两个日期之间的天数，日期格式为yyyy-MM-dd
     *
     * @param beginDate 开始日期
     * @param endDate 结束日期
     * @return 间隔天数
     */
    public static int daysOfDuration(String beginDate, String endDate) {
        Preconditions.checkArgument(StringUtils.isNotBlank(beginDate), "开始日期不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(endDate), "结束日期不能为空");

        String datePattern = "yyyy-MM-dd";
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern(datePattern);

        LocalDate localDateStart = dateFormatter.parseLocalDate(beginDate);
        LocalDate localDateEnd = dateFormatter.parseLocalDate(endDate);

        Days durationDays = Days.daysBetween(localDateStart, localDateEnd);
        return durationDays.getDays();
    }

    public static int daysOfDuration(Date start, Date end) {
        LocalDate localDateStart = new LocalDate(start);
        LocalDate localDateEnd = new LocalDate(end);

        Days durationDays = Days.daysBetween(localDateStart, localDateEnd);
        return durationDays.getDays();
    }

    public static void main(String[] args) {
        String begin = "2016-03-04";
        String end = "2016-03-15";

        List<String> days = Lists.newArrayList();
        String datePattern = "yyyy-MM-dd";
        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern(datePattern);

        LocalDate localDateStart = dateFormatter.parseLocalDate(begin);
        LocalDate localDateEnd = dateFormatter.parseLocalDate(end);
        for (LocalDate workDate = localDateStart; workDate.compareTo(localDateEnd) <= 0;) {
            days.add(workDate.toString("yyyy-MM-dd"));
            workDate = workDate.plusDays(1);
        }

        System.out.println(days);

        LocalDate localDate = new LocalDate();
        System.out.println(localDate.toString("yyyyMMdd"));
    }
}
