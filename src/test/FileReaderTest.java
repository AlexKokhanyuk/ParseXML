import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void searchFile() {
    }

    @Test
    void showFileStream() {
        FileReader fileReader=new FileReader();
        fileReader.showFileStream(".\\src\\main\\resources\\");

    }
}