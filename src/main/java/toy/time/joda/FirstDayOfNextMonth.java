/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.time.joda;

import org.joda.time.DateTime;

/**
 * @author chichen  Date: 16-3-30 Time: 下午5:46
 */
public class FirstDayOfNextMonth {

    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.toString("E MM/dd/yyyy HH:mm:ss.SSS"));

        DateTime next = dateTime.plusMonths(0).dayOfMonth().withMaximumValue().plusHours(24);
        System.out.println(next.toString("E MM/dd/yyyy HH:mm:ss.SSS"));
    }
}
