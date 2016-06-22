package toy.basic;

import java.text.DecimalFormat;

/**
 * Test
 *
 * Created by cc on 16/6/22.
 */
public class FloatFormat {

    private static String formatPrice(float price) {
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        return decimalFormat.format(price / 10000);
    }

    public static void main(String[] args) {
        float f = 12343.2f;
        System.out.println(formatPrice(f));
    }
}
