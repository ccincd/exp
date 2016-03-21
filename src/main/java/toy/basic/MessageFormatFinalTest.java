package toy.basic;

import java.text.MessageFormat;

/**
 * 测试模板字符串可不可以是final的
 *
 *
 FormatElement:
 { ArgumentIndex }
 { ArgumentIndex , FormatType }
 { ArgumentIndex , FormatType , FormatStyle }

 FormatType:
 number
 date
 time
 choice（需要使用ChoiceFormat）

 FormatStyle:
 short
 medium
 long
 full
 integer
 currency
 percent
 SubformatPattern（子模式）
 *
 * Created by cc on 16/3/19.
 */
public class MessageFormatFinalTest {

    private static final String str = "hi, {0}, I'm {1}, {2} to see you";

    /**
     * 如果想输出单引号则需要使用两个单引号
     */
    private static final String singleQuot = "there standing a strange man, "
            + "people call him ''Mr. Strange'', his name is {0}";

    /**
     * 由于单引号的作用，{0}并不会被替换
     */
    private static final String singleQuotEscape = "my name is '{0}'";

    /**
     * '不起作用也不显示
     */
    private static final String oneSingleQuotWrong = "i know it, you can look '{0, number, #.#} as pi";

    /**
     * i know it, you can look  3.1 as pi 小数点后只显示一位
     * ! #的个数表示小数点的位数
     */
    private static final String oneSingleQuotRight = "i know it, you can look {0, number, #.#######} as pi";

    /**
     * 匹配成功，不会抛异常
     */
    private static final String leftCurlyBrace = "hi, there. I'm { {0}";

    /**
     * 匹配成功，不会抛异常
     */
    private static final String rightCurlyBrace = "hi, there, I'm } {0}";

    /**
     * 会尝试去匹配，但会抛出异常
     */
    private static final String anotherLeftCurlyBrace = "oh, { is a pig";

    /**
     * 没有遇到{，会尝试去匹配，但不会抛出异常
     */
    private static final String anotherRightCurlyBrace = "oh, } is a pig";

    /**
     * 如果不加FormatType和FormatStyle，则5000会格式化为5,000，然而加了同样也会
     * 可以使用{0, number, #}的形式来去掉,
     */
    private static final String integerStr = "hi, China is {0, number, #.##} years old";

    public static void main(String[] args) {
        // String sayHello = MessageFormat.format(str, "there", "cc", "glad");
        Object[] arguments = new Object[] {"there", "cc", "glad"};

        String sayHello = MessageFormat.format(str, arguments);
        System.out.println(sayHello);

        //////////////////////////////

        System.out.println(MessageFormat.format(singleQuot, "not cc"));

        //////////////////////////////

        System.out.println(MessageFormat.format(singleQuotEscape, "cc"));

        //////////////////////////////

        System.out.println(MessageFormat.format(oneSingleQuotWrong, 3.1415926));

        //////////////////////////////

        System.out.println(MessageFormat.format(oneSingleQuotRight, 3.1415926));

        //////////////////////////////

        System.out.println(MessageFormat.format(leftCurlyBrace, "cc"));

        //////////////////////////////

        System.out.println(MessageFormat.format(rightCurlyBrace, "cc"));

        //////////////////////////////

        // System.out.println(MessageFormat.format(anotherLeftCurlyBrace, "cc"));

        //////////////////////////////

        System.out.println(MessageFormat.format(anotherRightCurlyBrace, "cc"));

        /**
         * From web, modified
         */
        String pig = "{0}hi, there{1} {2}   {3}{4}{5}{6}{7}{8}{9}{10}{11}{12}{13}{14}{15}{16}";

        Object[] array = new Object[]{"Aaa","Bbb","Ccc","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"};

        String value = MessageFormat.format(pig, array);

        System.out.println(value);

        /**
         * Tester, failed again. hi, there, Im {1}, {2} to see you
         * !!! I'm中的单引号影响了{1}和之后的解析
         */
        String anotherPig = "hi, {0}, I''m {1}, {2} to see you";

        Object[] anotherArray = new Object[]{"there", "cc", "nice"};

        String anotherValue = MessageFormat.format(anotherPig, anotherArray);

        System.out.println(anotherValue);

        //////////////////////////////

        System.out.println(MessageFormat.format(integerStr, 5000));
    }
}
