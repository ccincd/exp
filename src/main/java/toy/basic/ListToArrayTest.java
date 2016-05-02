package toy.basic;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 查看调用List.toArray方法返回的是不是一份copy
 *
 * Created by cc on 16/5/2.
 */
public class ListToArrayTest {

    public static void main(String[] args) {
        List<String> strList = Lists.newArrayList("hi", "there");
        /**
         * toArray会产生一份拷贝
         */
        Object[] strArray = strList.toArray();
        // String[] strArray = strList.toArray(new String[strList.size()]);

        strList.set(0, "hello");
        System.out.println(strList.get(0));
        System.out.println(strArray[0]);
    }
}
