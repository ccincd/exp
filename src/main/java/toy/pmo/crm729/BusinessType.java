package toy.pmo.crm729;

import java.util.Objects;
import toy.enums.EnumTrait;

/**
 * 售卖业务类型
 *
 * @author chi.chen
 * @date 16-3-14
 * @time 下午5:46
 */
public enum BusinessType implements EnumTrait {
    TEAM(1, "团购"),
    DIRECT_PRE(2, "直销预付"),
    DIRECT_CASH(3, "直销现付"),
    NIGHT_SALE(4, "夜销"),
    OTHER(5, "其他");

    private final Integer code;

    private final String name;

    private BusinessType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static BusinessType codeOf(Integer code) {
        for (BusinessType businessType : values()) {
            if (Objects.equals(code, businessType.code)) {
                return businessType;
            }
        }

        return null;
    }

    @Override
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
