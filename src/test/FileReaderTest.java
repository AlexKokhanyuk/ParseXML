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
        for (int i = 0; i < 4; i++) {
            System.out.println(arrayOfFiles[i].getFilePath());
        }
        String fileOfGoods01 = ".\\src\\main\\resources\\import___5493abdf-394d-49b9-bd4c-736cbaed61d0.xml";
        String fileOfPrises = ".\\src\\main\\resources\\prices___aa9533e0-4970-4592-9f9f-6480fdf8b99c.xml";
        String fileOfStock = ".\\src\\main\\resources\\rests___5a4c78e7-fca4-4a4f-bc9c-6f849b4f3253.xml";
        System.out.println(fileOfGoods01);
        System.out.println(fileOfPrises);
        System.out.println(fileOfStock);


        assertEquals(12, arrayOfFiles.length);
    }
}