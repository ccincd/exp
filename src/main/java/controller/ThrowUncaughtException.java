/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chichen  Date: 16-3-29 Time: 下午2:52
 */
@Controller
@RequestMapping("/test/uncaught")
public class ThrowUncaughtException {

    @RequestMapping("exception.json")
    @ResponseBody
    public ApiResult exception(@RequestParam("sayHi") int sayHi) {
        if (sayHi == 0) {
            throw new IllegalStateException("not say hi");
        } else {
            return ApiResult.succ("hi");
        }
    }
}
