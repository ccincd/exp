/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package toy.casting;

import controller.ApiResult;

/**
 * FruitGet
 *
 * @author cc
 * @version 1.0, 16/8/9
 */
public class FruitGet implements IGet {

    @Override
    public ApiResult<? extends Fruit> get() {
        return ApiResult.succ(new Apple());
    }
}
