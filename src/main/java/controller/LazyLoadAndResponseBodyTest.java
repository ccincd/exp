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

        return ApiResult.succ(dividedNumbers);
    }
}
