/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.time.java;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * SimpleDateFormat线程安全问题
 * {@link SimpleDateFormat} line 1473
 * {@link java.text.CalendarBuilder} line 145
 *
 * @author chichen  Date: 16-3-25 Time: 下午6:45
 */
public class SimpleDateFormatConcurrencyProblem {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Date date = sdf.parse("2016-01-01");
                    System.out.println(date.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);

                    Date date = sdf.parse("1970-01-01");
                    System.out.println(date.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();
    }
}
