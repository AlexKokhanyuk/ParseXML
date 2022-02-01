import java.util.ArrayList;
import java.util.HashMap;

public class MainController {
    private String path;
    private FileReader fileReader;
    private ArraySorter arraySorter;
    private DoParseXml doParseXml;

    String fImport = "";
    String fPrices = "";
    String fRest = "";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

//    public MainController() {
//    }

    public MainController(String path, FileReader fileReader, ArraySorter arraySorter, DoParseXml doParseXml) {
        this.path = path;
        this.fileReader = fileReader;
        this.arraySorter = arraySorter;
        this.doParseXml=doParseXml;

    }

    public ArrayList<HashMap> listOfOnloading() {
        ArrayList<HashMap> list = new ArrayList<>();
        ArrayList<FilePathAndTime> listOfFiles = fileReader.readFileNameFromFolder(path);
        FilePathAndTime[] arrayOfFiles = listOfFiles.toArray(new FilePathAndTime[0]);
        arraySorter.bouble(arrayOfFiles, false);
        for (int i = 0; i < arrayOfFiles.length; i += 3) {
            long l1 = arrayOfFiles[i].getTimeOfCreate().getTime() / 100000;
            long l2 = arrayOfFiles[i + 1].getTimeOfCreate().getTime() / 100000;
            long l3 = arrayOfFiles[i + 2].getTimeOfCreate().getTime() / 100000;
            System.out.println(l1);
            System.out.println(l2);
            System.out.println(l3);
            System.out.println();
            if (l1 == l2 & l2 == l3) {
                if (arrayOfFiles[i].getType() == Type.IMPORT) {
                    fImport = arrayOfFiles[i].getFilePath().trim();
                }
                if (arrayOfFiles[i + 1].getType() == Type.PRICES) {
                    fPrices = arrayOfFiles[i + 1].getFilePath().trim();
                }
                if (arrayOfFiles[i + 2].getType() == Type.REST) {
                    fRest = arrayOfFiles[i + 2].getFilePath().trim();
                } else {
//                    throw UncomStuctureException;
                    System.out.println("UncomStuctureException");
                }
            }
            HashMap<String, Goods> mapOfGoods = new HashMap();
            LinkedList linkedListist = doParseXml.getListOfGoods(fImport);
            while (linkedListist.iteratorHasNext()) {
                Goods tempGods = (Goods) linkedListist.iteratorNext();
                tempGods.setDate(arrayOfFiles[i].getTimeOfCreate());
                mapOfGoods.put(tempGods.getId(), tempGods);
            }
            doParseXml.addPrisesToGoods(mapOfGoods, fPrices);
            doParseXml.addStockOfGoods(mapOfGoods, fRest);
            list.add(mapOfGoods);
        }
        return list;
    }
}
