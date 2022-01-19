import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void insert() {
        LinkedList list = new LinkedList();
        list.insert(new Goods("зарядка", 10005));
        list.insert(new Goods("батарейка", 8804));
        assertEquals(2,list.getCapacity());
    }
    @org.junit.jupiter.api.Test
    void getCapacity() {
        LinkedList list = new LinkedList();
        list.insert(new Goods("зарядка", 10005));
        list.insert(new Goods("батарейка", 8804));
        assertEquals(2,list.getCapacity());
    }

    @org.junit.jupiter.api.Test
    void cleanAllList() {
        LinkedList list = new LinkedList();
        list.insert(new Goods("зарядка", 10005));
        list.insert(new Goods("батарейка", 8804));
        list.cleanAllList();
        assertEquals(0,list.getCapacity());
    }

    @org.junit.jupiter.api.Test
    void printList() {
    }

    @org.junit.jupiter.api.Test
    void iteratorHasNext() {
    }

    @org.junit.jupiter.api.Test
    void iteratorNext() {
    }

}