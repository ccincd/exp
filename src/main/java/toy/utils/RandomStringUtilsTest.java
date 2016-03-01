package toy.utils;

import io.crate.shade.org.apache.commons.lang3.RandomStringUtils;

/**
 * RandomStringUtilsTest
 *
 * @author chi.chen
 * @date 16-3-1
 * @time 上午10:26
 */
public class RandomStringUtilsTest {

    public static void main(String[] args) {
        // 产生随机字符串，中文环境下是乱码
        System.out.println(RandomStringUtils.random(10));

        System.out.println(RandomStringUtils.randomAlphabetic(10));

        // 生成从ASCII 32到126组成的随机字符串
        System.out.println(RandomStringUtils.randomAscii(10));

        System.out.println(RandomStringUtils.random(10, new char[] { 'a', 'e', 'i', 'o', 'u' }));

        System.out.println(RandomStringUtils.randomAlphanumeric(10));

        System.out.println(RandomStringUtils.randomNumeric(10));
    }
}
