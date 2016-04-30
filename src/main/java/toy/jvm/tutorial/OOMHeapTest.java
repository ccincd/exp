package toy.jvm.tutorial;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OOMHeapTest {
    public static void main(String[] args){
        oom();
    }

    private static void oom(){
        Map<String, Pilot> map = new HashMap<>();
        Object[] array = new Object[1000000];
        for(int i=0; i<1000000; i++){
            String d = new Date().toString();
            Pilot p = new Pilot(d, i);
            map.put(i+"oom test", p);
            array[i]=p;
        }
    }
}