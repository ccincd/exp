package toy.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtilsTest
 *
 * @author chi.chen
 * @date 16-2-29
 * @time 下午9:14
 */
public class StringUtilsTest {

    public static void main(String[] args) {
        System.out.println(StringUtils.substring("dskabcee", 3));

        StringUtils.substringBefore("dskeabcee", "e");
    }
}
