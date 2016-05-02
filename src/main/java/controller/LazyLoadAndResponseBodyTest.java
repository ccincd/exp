package controller;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 测试Lists.transform的懒加载机制以及@ResponseBody注解的处理逻辑
 *
 * Created by cc on 16/5/2.
 */
@Controller
@RequestMapping("/lazy")
public class LazyLoadAndResponseBodyTest {

    @RequestMapping(value = "test.json")
    @ResponseBody
    public ApiResult test() {
        List<Integer> numbers = Lists.newArrayList(1, 2, 5, 0);

        List<Integer> dividedNumbers = Lists.transform(numbers, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                // System.out.println("handling " + input);
                return 100 / input;
            }
        });

        /**
         * 1、MappingJackson2HttpMessageConverter和AbstractJackson2HttpMessageConverter会执行序列化操作
         *
         * 2、序列化过程如果抛出异常则会进入DispatcherServlet的processHandlerException异常处理函数中
         *
         * 3、DispatcherServlet有一个handlerExceptionResolvers异常处理列表，其中包含自定义的GlobalExceptionHandler，
         * 它实现了HandlerExceptionResolver接口，但异常处理是按责任链的方式进行处理，而GlobalExceptionHandler又处在责任链
         * 的底端，所以异常被DefaultHandlerExceptionResolver处理掉，给前端返回了500错误码和异常信息
         *
         * 4、解决办法是让GlobalExceptionHandler实现Ordered接口，重写获取order的方法，设置高优先级
         */
        return ApiResult.succ(dividedNumbers);
    }
}
