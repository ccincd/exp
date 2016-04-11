/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.time.joda;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * @author chichen  Date: 16-4-11 Time: 下午5:55
 */
public class ZeroDateDuration {

    public static void main(String[] args) {
        /**
         * "0000-00-00"的Date并不合法
         */
        // DateTime dateTime = new DateTime("0000-00-00");
        DateTime dateTime = new DateTime("1970-01-01");

        int duration = Days.daysBetween(dateTime, new DateTime()).getDays();
        System.out.println(duration);
    }
}
