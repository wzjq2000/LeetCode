package temp2;

public class Node <T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        System.out.println("This is Father...");
        this.t = t;
    }
}
