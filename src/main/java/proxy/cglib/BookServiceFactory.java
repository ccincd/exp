/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package proxy.cglib;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * @author chichen  Date: 16-4-26 Time: 下午6:34
 */
@NotThreadSafe
public class BookServiceFactory {

    private static BookService service = null;

    private BookServiceFactory() {
        // Empty
    }

    public static BookService getInstance() {
        if (service != null) {
            return service;
        }

        service = new BookService();
        return service;
    }
}
