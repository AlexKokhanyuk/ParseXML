public class LinkListTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(new Goods("зарядка", 10005));
        list.insert(new Goods("батарейка", 8804));
        list.printList();
        list.cleanAllList();
        list.printList();

    }
}
