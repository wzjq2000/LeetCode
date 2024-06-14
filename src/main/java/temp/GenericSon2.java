package temp;

public class GenericSon2 implements GenericParent<Integer> {
    @Override
    public Integer get() {
       return 2 ;
    }

    public static void main(String[] args) {
        GenericSon2 genericSon2 = new GenericSon2();
        Integer integer = genericSon2.get();
    }
}
