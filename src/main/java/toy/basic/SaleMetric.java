package toy.basic;

import java.util.Objects;
/**
 * 售卖情况指标
 *
 * @author chi.chen
 * @date 16-3-11
 * @time 上午11:26
 */
public enum SaleMetric implements EnumTrait {

    PAYED_COUNT(1, "成单量"),
    ROOM_NIGHT_COUNT(2, "订单间夜数"),
    HI(8, "hi"),
    SALE_AMOUNT(3, "销售额"),
    REFUND_AND_CANCEL_COUNT(4, "退款/取消数"),
    REJECT_COUNT(5, "拒单数"),
    USED_PAYED_COUNT(6, "实住订单数"),
    USED_ROOM_NIGHT_COUNT(7, "实住间夜数");

    public static void main(String[] args) {
        SaleMetric[] saleMetrics = SaleMetric.values();
        System.out.println(saleMetrics);
    }

    private final Integer code;

    private final String name;

    private SaleMetric(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SaleMetric codeOf(Integer code) {
        for (SaleMetric saleMetric : values()) {
            if (Objects.equals(code, saleMetric.code)) {
                return saleMetric;
            }
        }

        return null;
    }

    @Override public String toString() {
        return "SaleMetric{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
