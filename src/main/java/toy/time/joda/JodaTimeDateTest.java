/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.time.joda;

import org.joda.time.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chichen Date: 16-3-23 Time: 上午11:56
 */
public class JodaTimeDateTest {

    public static void main(String[] args) {
        String oneDay = "2016-03-15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(oneDay);
            System.out.println(date);

            LocalDate localDate = new LocalDate(date);
            System.out.println(localDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
