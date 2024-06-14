package temp;

public class GenericSon5 implements GenericParent<Integer>{

    public static <T> T  test(T a){
        return a;
    }


    @Override
    public Integer get() {
        return null;
    }

    public static void main(String[] args) {
    }
}
