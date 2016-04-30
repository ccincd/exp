package toy.jvm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 持续创建不可回收的对象导致堆OOM
 *
 * -Xms20m -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 *
 * Created by cc on 16/4/30.
 */
public class HeapOOM {

    static class OOMObject {

        private int age;

        private String name;

        public OOMObject(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<OOMObject> oomObjects = Lists.newArrayList();

        while (true) {
            oomObjects.add(new OOMObject(1, "hi"));
        }
    }
}
