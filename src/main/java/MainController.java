import java.util.ArrayList;
import java.util.HashMap;

public class MainController {


    public ArrayList<HashMap> listOfloading(String path) {
        ArrayList<HashMap> list = new ArrayList<>();
        FileReader fileReader = new FileReader();
        ArrayList<FilePathAndTime> listOfFiles = fileReader.readFileNameFromFolder(path);
        FilePathAndTime[] arrayOfFiles = listOfFiles.toArray(new FilePathAndTime[0]);
        String fImport = "";
        String fPrices = "";
        String fRest = "";
        for (int i = 0; i < arrayOfFiles.length; i += 4) {
            long l1 = arrayOfFiles[i].getTimeOfCreate().getTime() / 100000;
            long l2 = arrayOfFiles[i + 1].getTimeOfCreate().getTime() / 100000;
            long l3 = arrayOfFiles[i + 2].getTimeOfCreate().getTime() / 100000;
            long l4 = arrayOfFiles[i + 3].getTimeOfCreate().getTime() / 100000;
            if (l1 == l2 & l2 == l3 & l3 == l4) {
//                System.out.println(arrayOfFiles[i].getTimeOfCreate());
                if (arrayOfFiles[i + 1].getType() == Type.IMPORT) {
                    fImport = arrayOfFiles[i + 1].getFilePath().trim();
                }
                if (arrayOfFiles[i + 2].getType() == Type.PRICES) {
                    fPrices = arrayOfFiles[i + 2].getFilePath().trim();
                }
                if (arrayOfFiles[i + 3].getType() == Type.REST) {
                    fRest = arrayOfFiles[i + 3].getFilePath().trim();
                } else {
//                    throw UncomStuctureException;
                    System.out.println("UncomStuctureException");
                }
            }
            DoParseXml doParseXml = new DoParseXml();
            HashMap<String, Goods> mapOfGoods = doParseXml.getGods(fImport, fPrices, fRest, arrayOfFiles[i+1].getTimeOfCreate());
            list.add(mapOfGoods);
        }
        return list;
    }
}
