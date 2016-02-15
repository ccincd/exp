package basic;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * commonTest
 *
 * @author chi.chen
 * @date 16-2-15
 * @time 下午5:33
 */
public class CommonTest {
    /**
     * strs不应该为public的，可提供不可变List
     */
    private static final String[] strs = { "Hi", "There" };
    private static final List<String> unmodiStrs = Collections.unmodifiableList(Arrays.asList(strs));

    /**
     * BigInteger不是final的
     *
     * @param val val
     * @return BigInteger
     */
    public static BigInteger safeInstance(BigInteger val) {
        if (val.getClass() != BigInteger.class) {
            return new BigInteger(val.toByteArray());
        }

        return val;
    }

    public static void main(String[] args) {
        //
    }
}
