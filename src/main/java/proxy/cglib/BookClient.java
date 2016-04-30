/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package proxy.cglib;

/**
 * @author chichen  Date: 16-4-26 Time: 下午6:46
 */
public class BookClient {

    public static void main(String[] args) {
        BookService bookService = BookServiceFactory.getInstance();

        bookService.create();
        bookService.update();
        bookService.query();
        bookService.delete();
    }
}
