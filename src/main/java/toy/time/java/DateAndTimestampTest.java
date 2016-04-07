/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.time.java;

import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * @author chichen  Date: 16-4-7 Time: 下午7:26
 */
public class DateAndTimestampTest {

    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        Date date = DateUtils.truncate(timestamp, Calendar.MILLISECOND);
        System.out.println(date);
    }
}
