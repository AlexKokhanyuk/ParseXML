import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileReader {


    public void searchFile(String path) {

    }

    public void showFileStream(String folder) {

        try (Stream<Path> filePathStream = Files.walk(Paths.get(folder))) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    System.out.println(filePath);
                    String file=filePath.toString();
                    for (String fileName : file.split("\\")) {
                        System.out.println( fileName);

                    }

                }
                if (Files.isDirectory(filePath)) {
                    System.out.println(filePath + " - It is Folder");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
