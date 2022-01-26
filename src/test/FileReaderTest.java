import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    @Test
    void searchFile() {
    }

    @Test
    void readFileNameFromFolder() {
        FileReader fileReader = new FileReader();
        ArrayList<FilePathAndTime> listOfFiles = fileReader.readFileNameFromFolder(".\\src\\main\\resources\\");
        FilePathAndTime[] arrayOfFiles = listOfFiles.toArray(new FilePathAndTime[0]);
//        for (int i = arrayOfFiles.length - 4; i < arrayOfFiles.length; i++) {
//            System.out.println(arrayOfFiles[i]);
//        }
        assertEquals(12, arrayOfFiles.length);
    }
}