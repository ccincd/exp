package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "valid.json", method = RequestMethod.GET)
    @ResponseBody
    public ApiResult valid(@RequestParam("name") String name) {
        return ApiResult.succ(name);
    }
}
