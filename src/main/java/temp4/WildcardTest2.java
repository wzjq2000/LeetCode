package temp4;

import temp2.Father;
import temp2.Son;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest2 {
    public static Integer b;
    public Number get(List<? extends Number> a){

        return a.get(0);
    }

    public static void set(List<? super Integer> c){
        b = (Integer) c.get(0);
    }

    public static void main(String[] args) {
        List<? extends Father> list1 = new ArrayList<>();
        List<? super Son> list2 = new ArrayList<>();
//        list1.add(new Father());
//        list1.add(new Son());

//        Father father = list1.get(0);
//        Son object = (Son) list2.get(0);
//        list2.add(new Father());
        list2.add(new Son());


    }
}
