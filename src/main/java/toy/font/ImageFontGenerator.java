package toy.font;

import java.awt.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;

import org.apache.commons.lang3.StringUtils;

/**
 * ttf字体文件
 */
public class ImageFontGenerator {

    private static final int FONT_HEIGHT = 33;

    private Font ttfFont;

    public Font getTtfFont() {
        return ttfFont;
    }

    /**
     * 获取字体
     *
     * @return 字体
     */
    private Font generateFont() {
        try {
            Font baseFont = Font.createFont(Font.TRUETYPE_FONT,
                    new ByteArrayInputStream(hex2byte(getFontByteStr())));
            return baseFont.deriveFont(Font.PLAIN, FONT_HEIGHT);
        } catch (Exception e) {
            return new Font("Arial", Font.PLAIN, FONT_HEIGHT);
        }
    }

    /**
     * 对字符串二进制编码
     *
     * @param str 字符串
     * @return 二进制数组
     */
    private byte[] hex2byte(String str) {
        if (str == null) {
            return null;
        }
        str = str.trim();
        int len = str.length();
        if (len == 0 || len % 2 == 1) {
            return null;
        }

        byte[] b = new byte[len / 2];
        try {
            for (int i = 0; i < str.length(); i += 2) {
                b[i / 2] = (byte) Integer
                        .decode("0x" + str.substring(i, i + 2)).intValue();
            }
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ttf字体文件的十六进制字符串
     *
     * @return 字体文件的十六进制字符串
     */
    private String getFontByteStr() {
        StringBuilder stringBuilder = new StringBuilder();
        String ttfFontPath = "ttfFontHexData";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(ttfFontPath));
            String lineStr;
            while ((lineStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(lineStr);
            }

            bufferedReader.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    public static void main(String[] args) {
        ImageFontGenerator generator = new ImageFontGenerator();
        generator.generateFont();
    }
}
