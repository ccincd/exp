/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package toy.casting;

import controller.ApiResult;

/**
 * IGet
 *
 * @author cc
 * @version 1.0, 16/8/9
 */
public interface IGet {

    ApiResult<? extends Fruit> get();
}
