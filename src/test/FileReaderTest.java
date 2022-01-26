import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class FileReaderTest {

    @Test
    void searchFile() {
    }

    @Test
    void showFileStream() {
        FileReader fileReader = new FileReader();
        ArrayList<FilePathAndTime> listOfFiles = fileReader.readFileNameFromFolder(".\\src\\main\\resources\\");
        FilePathAndTime[] arrayOfFiles = listOfFiles.toArray(new FilePathAndTime[0]);
        DoParseXml doParseXml = new DoParseXml();

        for (int i = arrayOfFiles.length-4; i < arrayOfFiles.length; i++) {
            System.out.println(arrayOfFiles[i]);
        }
    }
}