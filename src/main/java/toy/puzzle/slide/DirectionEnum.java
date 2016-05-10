package toy.puzzle.slide;

import toy.enums.EnumTrait;

import java.util.Objects;

/**
 * 移动方向枚举
 *
 * Created by cc on 16/5/9.
 */
public enum DirectionEnum implements EnumTrait {

    RIGHT(1, "向右移动"),
    LEFT(2, "向左移动"),
    UP(3, "向上移动"),
    DOWN(4, "向下移动");

    private final Integer code;

    private final String text;

    DirectionEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public static DirectionEnum codeOf(Integer code) {
        for (DirectionEnum directionEnum : values()) {
            if (Objects.equals(code, directionEnum.code)) {
                return directionEnum;
            }
        }

        return null;
    }

    @Override
    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
