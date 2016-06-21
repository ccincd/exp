package toy.json.util;

import java.util.List;

/**
 * JsonUtilTest
 *
 * Created by cc on 16/6/21.
 */
public class JsonUtilTest {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String str = "[[\"hi\", \"there\"],[\"a\", \"b\", \"c\"],[\"1\", \"2\", \"3\"]]";

        setListListString((List<List<String>>) JsonUtil.jsonToObject(str));
    }

    private static void setListListString(List<List<String>> parts) {
        System.out.println(parts);
    }
}
