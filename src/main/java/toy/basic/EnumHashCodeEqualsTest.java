package toy.basic;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * EnumHashCodeEqualsTest
 *
 * @author chi.chen
 * @date 16-3-16
 * @time 下午7:15
 */
public class EnumHashCodeEqualsTest {

    public static void main(String[] args) {
        Map<SaleMetric, Integer> map = Maps.newHashMap();

        int counter = 1;
        for (SaleMetric saleMetric : SaleMetric.values()) {
            map.put(saleMetric, counter++);
        }

        System.out.println(map.get(SaleMetric.PAYED_COUNT));
    }
}
