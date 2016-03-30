package controller;

import controller.bean.Box;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import controller.bean.User;

/**
 * ValidationController
 *
 * @author chi.chen
 * @date 16-3-7
 * @time 下午1:31
 */
@Controller
@RequestMapping("/test/validation")
public class ValidationController {

    /**
     * Validated是Spring的注解 Valid是javax的注解 这里一个@Valid的参数后必须紧挨着一个BindingResult参数，否则spring会在校验不通过时直接抛出异常
     *
     * @param user User
     * @param bindingResult BindingResult
     * @return ApiResult
     */
    @RequestMapping(value = "validGet.json", method = RequestMethod.GET)
    @ResponseBody
    public ApiResult validGet(@Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ApiResult.fail(bindingResult.getFieldError().getDefaultMessage());
        }

        return ApiResult.succ(user);
    }

    /**
     * { "name":"cc", "age":95, "email":null, "address":"street", "friends":[ "cc", "dd", "ee", "ff" ] }
     *
     * Content-Type: application/json
     *
     * @param user User
     * @param bindingResult BindingResult
     * @return ApiResult
     */
    @RequestMapping(value = "validPost.json", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult validPost(@Validated @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ApiResult.fail(bindingResult.getFieldError().getDefaultMessage());
        }

        return ApiResult.succ(user);
    }

    /**
     * HTTP Status 405 - Request method 'GET' not supported
     * 如果method改为GET，则会报400（不带参数，syntactically incorrect）或者404（带参数）
     *
     * @param box {@link controller.bean.Box}
     * @return {@link controller.ApiResult}
     */
    @RequestMapping(value = "requestBodyGet.json", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult requestBodyGet(@RequestBody Box box) {
        return ApiResult.succ(box.toString());
    }
}
