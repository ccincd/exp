package toy.basic;

/**
 * StringConcatTest
 *
 * @author chi.chen
 * @date 16-3-14
 * @time 下午6:58
 */
public class StringConcatTest {

    private static String buildRatioStr(int diffCount) {
        if (diffCount > 0) {
            return "增长" + diffCount + "%";
        } else if (diffCount < 0) {
            return "减少" + (-diffCount) + "%";
        } else {
            return "相同";
        }
    }

    public static void main(String[] args) {
        System.out.println(buildRatioStr(-1));
        System.out.println(buildRatioStr(5));
        System.out.println(buildRatioStr(0));
    }
}
