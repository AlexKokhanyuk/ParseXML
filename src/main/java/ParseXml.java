/**
 * @author Oleksandr Kokhaniuk
 * @created 30/11/2021 - 13:31
 */


import java.util.ArrayList;
import java.util.HashMap;


public class ParseXml {
    public static void main(String[] args) {


        FileReader fileReader = new FileReader();
        ArrayList<FilePathAndTime> listOfFiles = fileReader.readFileNameFromFolder(".\\src\\main\\resources\\");
        FilePathAndTime[] arrayOfFiles = listOfFiles.toArray(new FilePathAndTime[0]);
        String fPrices = "";
        String fImport = "";
        String fRest = "";
        HashMap<String, Goods> mapOfGoods = new HashMap<>();
        for (int i = 0; i < 4; i++) {

            switch (arrayOfFiles[i].getType()) {
                case IMPORT:
                    fImport = arrayOfFiles[i].getFilePath();
                    System.out.println("Import file is "+ arrayOfFiles[i]);
                    break;
                case PRICES:
                    fPrices = arrayOfFiles[i].getFilePath();
                    System.out.println("Prices file is "+ arrayOfFiles[i]);
                    break;
                case REST:
                    fRest = arrayOfFiles[i].getFilePath();
                    System.out.println("Rest file is "+ arrayOfFiles[i]);
                    break;
            }
            DoParseXml doParseXml = new DoParseXml();

            mapOfGoods = doParseXml.getGods(fImport, fPrices, fRest);
        }

        mapOfGoods.forEach((sId, goods) -> System.out.println(goods.getName()
                + ", prise: " + goods.getPriseCommon() + " $ Stock: " + goods.getStockBalanse()));
        System.out.println("Size of map: " + mapOfGoods.size());
    }
}



