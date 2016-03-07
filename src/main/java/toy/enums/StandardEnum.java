package toy.enums;

import java.util.Objects;

/**
 * StandardEnum
 *
 * @author chi.chen
 * @date 16-3-7
 * @time 下午6:35
 */
public enum StandardEnum implements EnumTrait {

    GANDALF(1, "Gandalf", "the white wizard"),
    FRODO(2, "Frodo", "the ring bearer"),
    Pippin(3, "Pippin", "fool of took"),
    Merry(4, "Merry", "Merry Brandybuck")
    ;

    private final Integer code;
    private final String name;
    private final String desc;

    /**
     * 构造函数可声明为private的
     */
    private StandardEnum(Integer code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public static StandardEnum codeOf(Integer code) {
        for (StandardEnum standardEnum : values()) {
            if (Objects.equals(code, standardEnum.code)) {
                return standardEnum;
            }
        }

        return null;
    }

    public static StandardEnum nameOf(String name) {
        for (StandardEnum standardEnum : values()) {
            if (Objects.equals(name, standardEnum.name)) {
                return standardEnum;
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

    public String getDesc() {
        return desc;
    }
}
