package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    @RequestMapping(value = "valid.json", method = RequestMethod.GET)
    @ResponseBody
    public ApiResult valid(@Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ApiResult.fail(bindingResult.getFieldError().getDefaultMessage());
        }

        return ApiResult.succ(user);
    }
}
