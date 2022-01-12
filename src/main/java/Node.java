import javax.sound.midi.Soundbank;

public class Node {
    public Node() {
    }

    public Node(Goods goods) {
        this.value = goods;
    }

    private Goods value;
    private Node next;

    public Goods getValue() {
        return value;
    }

    public void setValue(Goods value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public void printNode(){
        System.out.println(value);
    }
}
