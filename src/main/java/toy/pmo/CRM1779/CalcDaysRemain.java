/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.pmo.CRM1779;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chichen  Date: 16-3-30 Time: 下午6:44
 */
public class CalcDaysRemain {

    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date lastVist = sdf.parse("2016-02-29");
            long remain = calculateDaysRemain(lastVist);

            System.out.println(remain);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static long calculateDaysRemain(Date visitDate) {

        DateTime lastVisitDate = new DateTime(visitDate);

        // 将时间对齐到每天的开始时间
        DateTime currentDate = new DateTime();

        // 计算截止日期。一个月的提醒一次需要计算到当月的月底，所以是月份数减１
        DateTime rightMargin = calculateRightMargin(currentDate, lastVisitDate, getMonths() - 1);

        return Days.daysBetween(currentDate, rightMargin).getDays();
    }

    public static DateTime calculateRightMargin(DateTime currentDate, DateTime visitDate, int months) {

        // 计算离拜访记录最近的一次右边界
        DateTime margin = visitDate.plusMonths(months).dayOfMonth().withMaximumValue().plusHours(24);

        // 如果右边界在当前日期之前，那么需要增加一个周期的步长。直至右边界在当前日期之后为止。
        while (currentDate.isAfter(margin)) {
            margin = margin.plusMonths(months).dayOfMonth().withMaximumValue().plusHours(24);
        }

        return margin;
    }

    protected static int getMonths() {
        // 过期时间为1个月
        return 2;
    }
}
