import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    @Test
    void searchFile() {

    }

    @Test
    void readFileNameFromFolder() {
        Long startTime = Calendar.getInstance().getTime().getTime();
        FileReader fileReader = new FileReader();
//        ArrayList<FilePathAndTime> listOfFiles = fileReader.readFileNameFromFolder(".\\src\\main\\resources\\");
        ArrayList<FilePathAndTime> listOfFiles = fileReader.readFileNameFromFolder("C:\\tmp\\temp1\\");
        //обработать пустую дирректорию
//        ArrayList<FilePathAndTime> listOfFiles = fileReader.readFileNameFromFolder("C:\\tmp\\temp\\");
        FilePathAndTime[] arrayOfFiles = listOfFiles.toArray(new FilePathAndTime[0]);

        ArraySorter sorter=new ArraySorter();
        sorter.bouble(arrayOfFiles, true);
        for(FilePathAndTime f:arrayOfFiles){
            System.out.println(f.getType()+"  "+f.getTimeOfCreate());
        }
        Long endTime = Calendar.getInstance().getTime().getTime();

            System.out.println(String.format("Reading date from file took %s seconds", (endTime - startTime)/1000 ));

    }
}