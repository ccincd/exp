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
        boolean theSame = StringUtils.equalsIgnoreCase("Hi, There", "hi, tHerE");
        System.out.println(theSame);

        // **************************************************************************
        System.out.println(StringUtils.substring("dskabcee", 3));

        System.out.println(StringUtils.substringBefore("dskeabcee", "e"));
        System.out.println(StringUtils.substringBeforeLast("dskeabcee", "e"));

        System.out.println(StringUtils.substringAfter("dskeabcedeh", "ske"));
        System.out.println(StringUtils.substringAfterLast("dskeabcedeh", "e"));

        /* public static String substringBetween(final String str, final String tag) */
        System.out.println(StringUtils.substringBetween("dskeabcedeh", "ds"));
        System.out.println(StringUtils.substringBetween("dskeabcedeh", "ds", "e"));

        // 不处理嵌套
        String[] strs = StringUtils.substringsBetween("dskeabcedsehdsabc", "ds", "c");
        System.out.println(strs);
    }
}
