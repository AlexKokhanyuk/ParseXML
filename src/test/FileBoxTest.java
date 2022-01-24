import javax.xml.crypto.Data;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FileBoxTest {
    @org.junit.jupiter.api.Test
    void testFileNode() {
        FileBox fileBox = new FileBox();
        Date date=new Date();
        fileBox.addFile("Hello", date);
        System.out.println(fileBox);
    }

}