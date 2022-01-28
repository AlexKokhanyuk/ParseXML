import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Stream;

public class FileReader {


    public ArrayList searchGoods(String path) {
        ArrayList<HashMap> listOfMapGoods = new ArrayList<>();


        return listOfMapGoods;
    }

    public ArrayList<FilePathAndTime> readFileNameFromFolder(String folder) {
        ArrayList<FilePathAndTime> listOfFiles = new ArrayList<>();
        try (Stream<Path> filePathStream = Files.walk(Paths.get(folder))) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    FilePathAndTime filePathAndTime = new FilePathAndTime();
                    String file = filePath.toString();
                    filePathAndTime.setFilePath(file);
                    String[] fileName = filePath.toString().split("\\\\");
                    String name = fileName[fileName.length - 1].substring(0, 5);
                    switch (name) {
                        case "impor":
                            filePathAndTime.setType(Type.IMPORT);
                            DoParseXml doParseXml = new DoParseXml();
                            LinkedList list = doParseXml.getListOfGoods(filePathAndTime.getFilePath());
                            if (list.isEmpty()) {
                                filePathAndTime.setType(Type.CATEGORY);
                            }
                            break;
                        case "price":
                            filePathAndTime.setType(Type.PRICES);
                            break;
                        case "rests":
                            filePathAndTime.setType(Type.REST);
                    }
                    if (filePathAndTime.getType() != null) {
                        DoParseXml parseForDate = new DoParseXml();
                        String day = parseForDate.getDate(filePathAndTime.getFilePath()).substring(18, 28);
                        String time = parseForDate.getDate(filePathAndTime.getFilePath()).substring(29, 37);
                        String sDate = day + " " + time;
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                        try {
                            Date date = formatter.parse(sDate);
                            filePathAndTime.setTimeOfCreate(date);
                            listOfFiles.add(filePathAndTime);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Collections.sort(listOfFiles);
        return listOfFiles;
    }
}
