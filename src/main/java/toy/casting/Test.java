/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package toy.casting;

import controller.ApiResult;

/**
 * Test
 *
 * @author cc
 * @version 1.0, 16/8/9
 */
public class Test {

    public static void main(String[] args) {
        ApiResult<? extends Fruit> result = new FruitGet().get();
        Apple apple = (Apple) result.getData();
        System.out.println(apple);
    }
}
