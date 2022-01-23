public class LinkedList <T>{

    private Node first;
    private Node correntNode;
    private Node returnedNode;
    private int capacity = 0;

    public LinkedList() {
        this.first = null;

    }


    public class Node<T> {
        private T value;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }

        protected Node next;

        public T getValue() {
            return  value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void printNode() {
            System.out.print(value);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(T t) {
        Node node = new Node(t);
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
        capacity = 0;
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
        return correntNode != null;
    }

    public T iteratorNext() {
        returnedNode = correntNode;
        correntNode = correntNode.getNext();
        return (T) returnedNode.getValue();
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", correntNode=" + correntNode +
                ", returnedNode=" + returnedNode +
                ", capacity=" + capacity +
                '}';
    }
}
