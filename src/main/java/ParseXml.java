/**
 * @author Oleksandr Kokhaniuk
 * @created 30/11/2021 - 13:31
 */


import java.util.ArrayList;
import java.util.HashMap;


public class ParseXml {
    public static void main(String[] args) throws UncomStuctureException {


        FileReader fileReader = new FileReader();
        ArrayList<FilePathAndTime> listOfFiles = fileReader.readFileNameFromFolder(".\\src\\main\\resources\\");
        FilePathAndTime[] arrayOfFiles = listOfFiles.toArray(new FilePathAndTime[0]);
        String fImport = "";
        String fPrices = "";
        String fRest = "";
        for (int i = 0; i < 4; i += 4) {
            long l1 = arrayOfFiles[i].getTimeOfCreate().getTime() / 100000;
            long l2 = arrayOfFiles[i + 1].getTimeOfCreate().getTime() / 100000;
            long l3 = arrayOfFiles[i + 2].getTimeOfCreate().getTime() / 100000;
            long l4 = arrayOfFiles[i + 3].getTimeOfCreate().getTime() / 100000;
            if (l1 == l2 & l2 == l3 & l3 == l4) {
                System.out.println(arrayOfFiles[i].getTimeOfCreate());
                if (arrayOfFiles[i + 1].getType() == Type.IMPORT) {
                    fImport = arrayOfFiles[i + 2].getFilePath().trim();
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
//            System.out.println(fImport);
//            System.out.println(fPrices);
//            System.out.println(fRest);
            fImport = arrayOfFiles[1].getFilePath();
            fPrices = String.valueOf(arrayOfFiles[2].getFilePath());
            fRest = String.valueOf(arrayOfFiles[3].getFilePath());
            DoParseXml doParseXml = new DoParseXml();
            HashMap<String, Goods> mapOfGoods = doParseXml.getGods(fImport, fPrices, fRest);
            ;
            mapOfGoods.forEach((sId, goods) -> System.out.println(goods.getName()
                    + ", prise: " + goods.getPriseCommon() + " $ Stock: " + goods.getStockBalanse()));
            System.out.println("Size of map: " + mapOfGoods.size());
        }
    }
}



