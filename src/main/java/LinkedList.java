public class LinkedList {
    private Node first;
    private Node correntNode;
    private Node returnedNode;
    private int capacity=0;

    public LinkedList() {
        this.first = null;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(Goods goods) {
        Node node = new Node(goods);
        node.setNext(first);
        first = node;
        correntNode = first;
        capacity++;
    }

    public void cleanAllList() {
        Node temp = first;
        while (first != null) {
            first = first.getNext();
        }
    }

    public void printList() {
        correntNode = first;
        int count = 0;
        while (correntNode != null) {

            correntNode.printNode();
            correntNode = correntNode.getNext();
            count++;
        }
        System.out.println("Всего в списке " + count + " элементов.");
    }

    public boolean iteratorHasNext() {
      return correntNode!=null;
    }
    public Goods iteratorNext() {
            returnedNode = correntNode;
            correntNode = correntNode.getNext();
            return returnedNode.getValue();
    }
    public int getCapacity() {
        return capacity;
    }


}
