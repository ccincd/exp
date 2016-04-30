package toy.jvm;

import net.sourceforge.sizeof.SizeOf;

/**
 * 查看数组大小
 *
 * Created by cc on 16/4/30.
 */
public class ArraySize {

    private Integer[] integers = new Integer[3];

    public ArraySize() {
        for (int i = 0; i < 3; i++) {
            integers[i] = i;
        }
    }

    public static void main(String[] args) {
        ArraySize arraySize = new ArraySize();
        System.out.println(SizeOf.sizeOf(arraySize));

        System.out.println(SizeOf.sizeOf(new Integer(1)));
        // 未压缩情况下数组比普通对象多8B来存放长度
        System.out.println(SizeOf.sizeOf(new Integer[1]));
        System.out.println(SizeOf.sizeOf(new int[2]));
    }
}
