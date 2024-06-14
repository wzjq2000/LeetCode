import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tests {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.computeIfAbsent(1,k->1);
        System.out.println(map.computeIfAbsent(1,k->2));
        System.out.println(map);

    }
}
