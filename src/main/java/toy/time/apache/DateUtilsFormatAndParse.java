package toy.time.apache;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * DateFormatUtils格式化Demo
 *
 * Created by cc on 16/3/26.
 */
public class DateUtilsFormatAndParse {

    public static void main(String[] args) {
        String dayOne = "2016-01-01";
        String dayTwo = "2016/01/02";
        String dayThree = "2016 01 03 13:15:36";
        String dayFour = "2016 01 03 23:15:36";

        try {
            Date dateOne = DateUtils.parseDate(dayOne, "yyyy-MM-dd");
            Date dateTwo = DateUtils.parseDate(dayTwo, "yyyy/MM/dd");
            Date dateThree = DateUtils.parseDate(dayThree, "yyyy MM dd HH:mm:ss");
            Date dateFour = DateUtils.parseDate(dayFour, "yyyy*MM*dd", "yyyy MM dd hh:mm:ss");

            System.out.println(DateFormatUtils.format(dateFour, "yyyy MM dd hh:mm:ss"));

            System.out.println(dateOne);
            System.out.println(dateTwo);
            System.out.println(dateThree);
            System.out.println(dateFour);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
