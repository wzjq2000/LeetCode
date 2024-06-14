package temp;

public class GenericSon3<T> implements GenericParent<T> {

    public T t;
    @Override
    public T get() {
        return t;
    }

    public static void main(String[] args) {
        GenericSon3<Object> objectGenericSon3 = new GenericSon3<>();

    }
}
