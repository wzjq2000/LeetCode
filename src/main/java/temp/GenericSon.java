package temp;

public class GenericSon implements GenericParent {

    @Override
    public Integer get() {
        return 1;
    }

    public static void main(String[] args) {
        GenericParent<String> gp = new GenericSon();
        String s = gp.get();
        System.out.println(s);


    }
}
