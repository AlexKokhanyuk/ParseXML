import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;

class FileBoxTest {
    @org.junit.jupiter.api.Test
    void testFileNode() {
        FileBox fileBox = new FileBox();
        Data data;


        fileBox.addFile("Hello", );
        System.out.println(fileBox);

    }

}