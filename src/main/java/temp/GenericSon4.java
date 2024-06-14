package temp;

public class GenericSon4 extends GenericSon3<Integer>{
    public Integer t =1;

    @Override
    public Integer get() {
        super.t=t;
        return super.get();
    }

    public static void main(String[] args) {
        GenericSon4 genericSon4 = new GenericSon4();
        System.out.println(genericSon4.get());
    }
}
