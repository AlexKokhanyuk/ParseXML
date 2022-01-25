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
        ArrayList<FilePathAndTime> listOfFiles = new ArrayList<>();
        try (Stream<Path> filePathStream = Files.walk(Paths.get(folder))) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
//                    System.out.println(filePath);
                    FilePathAndTime filePathAndTime = new FilePathAndTime();
                    String file = filePath.toString();
                    filePathAndTime.setFilePath(file);
                    String[] fileName = filePath.toString().split("\\\\");
                    String name = fileName[fileName.length - 1].substring(0, 5);
                    switch (name) {
                        case "impor":
                            filePathAndTime.setType(Type.IMPORT);
                            break;
                        case "price":
                            filePathAndTime.setType(Type.PRICES);
                            break;
                        case "rests":
                            filePathAndTime.setType(Type.REST);
                    }
                    listOfFiles.add(filePathAndTime);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(listOfFiles);
    }
}
