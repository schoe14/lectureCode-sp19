import java.util.LinkedList;

public class Stack<Item> {
    private LinkedList<Item> L = new LinkedList<Item>();

    public void push(Item x) {
        L.add(x);
    }
}
