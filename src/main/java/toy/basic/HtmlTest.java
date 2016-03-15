package toy.basic;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import controller.ApiResult;

/**
 * Created by cc on 16/3/15.
 */
public class HtmlTest {

    public static void main(String[] args) {
        String str = "<div class=\"m-info\">\\\n" + "            <p class=\"m-title\">销售建议</p>\\\n"
                + "            <ul class=\"m-texts\">\\\n"
                + "                <li class=\"text\">1、2016-03-01至2016-03-14，成单总量35，实住间夜量42，销售额6500元。</li>\\\n"
                + "                <li class=\"text\">2、订单数量与上期相比，环比增长5%，与去年同期相比，同比减少2%。</li>\\\n"
                + "                <li class=\"text\">3、各个业务线间夜量分布：团购12，直销预付15，直销现付8，夜销5, 其它2。</li>\\\n"
                + "            </ul>\\\n" + "</div>";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonStr = objectMapper.writeValueAsString(ApiResult.succ(str));

            System.out.println(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
