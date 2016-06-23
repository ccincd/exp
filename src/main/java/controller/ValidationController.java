package controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import common.base.ChildrenDto;
import common.base.TestConverterDto;
import controller.bean.Box;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import controller.bean.User;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    /*@Resource
    TestMySqlDataSourceDao mySqlDataSourceDao;

    @RequestMapping(value = "testDaoInjection.json", method = RequestMethod.GET)
    @ResponseBody
    public ApiResult testDaoInjection() {
        int toyNum = mySqlDataSourceDao.countSmallToys();
        return ApiResult.succ(toyNum);
    }*/

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

    @RequestMapping(value = "testJsonConverter.json", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<ChildrenDto> testJsonConverter(@RequestBody ChildrenDto dto) {
        System.out.println(dto);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        try {
            String str = objectMapper.writeValueAsString(dto);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ApiResult.succ(dto);
    }

    public static void main(String[] args) {
        String img = "http://7xpjmx.com2.z0.glb.qiniucdn.com/o_1alr02vle17s51irh1sqa179b14nd.jpg";
        List<String> imgs = Lists.newArrayList(img, img, img);
        try {
            System.out.println(new ObjectMapper().writeValueAsString(imgs));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
