package temp2;

import java.util.Collections;
import java.util.List;

public class NodeSon extends Node<Son> {
    @Override
    public void setT(Son son) {
//        super.setT(son);
        System.out.println("Son doing set()...");
    }

    @Override
    public Son getT() {
        System.out.println("Son doing get()...");
        return super.getT();
    }

    public static void main(String[] args) {
        List<Node> nodes =  Collections.singletonList(new NodeSon());
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            Father f = new Son();
            node.setT(f);
//           node.setT(new Son());
            node.getT();

        }
    }
}
