package temp4;

import temp.GenericParent;
import temp.GenericSon3;
import temp2.Father;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WildcardTest {
    public static List<? extends Integer> test(List<? extends Integer> objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
        return objects;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        List<? extends Number> test = test(integers);
        System.out.println(test);
    }
}
