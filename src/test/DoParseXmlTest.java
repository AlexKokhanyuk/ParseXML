import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DoParseXmlTest {

    @Test
    void getGods() {
//        DoParseXml doParseXml = new DoParseXml();
//        String fileOfGoods01 = ".\\src\\main\\resources\\import___5493abdf-394d-49b9-bd4c-736cbaed61d0.xml";
//        String fileOfPrises = ".\\src\\main\\resources\\prices___aa9533e0-4970-4592-9f9f-6480fdf8b99c.xml";
//        String fileOfStock = ".\\src\\main\\resources\\rests___5a4c78e7-fca4-4a4f-bc9c-6f849b4f3253.xml";
//
//
//        HashMap<String, Goods> mapOfGoods = doParseXml.getGods(fileOfGoods01, fileOfPrises, fileOfStock);
//        mapOfGoods.forEach((sId, goods) -> System.out.println(goods.getName()
//                + ", prise: " + goods.getPriseCommon() + " $ Stock: " + goods.getStockBalanse()));
//        System.out.println("Size of map: " + mapOfGoods.size());

    }

    @Test
    void getAllGods() {
        DoParseXml doParseXml = new DoParseXml();
        String fileOfGoods01 = ".\\src\\main\\files\\import___5493abdf-394d-49b9-bd4c-736cbaed61d0.xml";
        String fileOfPrises = ".\\src\\main\\files\\prices___aa9533e0-4970-4592-9f9f-6480fdf8b99c.xml";
        String fileOfStock = ".\\src\\main\\files\\rests___5a4c78e7-fca4-4a4f-bc9c-6f849b4f3253.xml";

        LinkedList list = doParseXml.getListOfGoods(fileOfGoods01);
        HashMap<String, Goods> mapOfGoods = new HashMap();
        int count = 0;
        int countOfZerro = 0;
        while (list.iteratorHasNext()) {
            Goods tempGods = (Goods) list.iteratorNext();
            mapOfGoods.put(tempGods.getId(), tempGods);
            count++;
        }
        doParseXml.addPrisesToGoods(mapOfGoods, fileOfPrises);
        doParseXml.addStockOfGoods(mapOfGoods, fileOfStock);
        mapOfGoods.forEach((sId, goods) -> System.out.println(goods.getName()
                + ", prise: " + goods.getPriseCommon() + " $ Stock: " + goods.getStockBalanse()));
        System.out.println("Size of map: " + mapOfGoods.size());
    }

    @Test
    void getDate() {
    }

    @Test
    void getListOfGoods() {
        DoParseXml doParseXml = new DoParseXml();
        String fileOfGoods01 = ".\\src\\main\\resources\\import___5493abdf-394d-49b9-bd4c-736cbaed61d0.xml";
        String fileOfPrises = ".\\src\\main\\resources\\prices___aa9533e0-4970-4592-9f9f-6480fdf8b99c.xml";
        String fileOfStock = ".\\src\\main\\resources\\rests___5a4c78e7-fca4-4a4f-bc9c-6f849b4f3253.xml";

        FileReader fileReader = new FileReader();
        ArrayList<FilePathAndTime> listOfFiles = fileReader.readFileNameFromFolder(".\\src\\main\\resources\\");
        FilePathAndTime[] arrayOfFiles = listOfFiles.toArray(new FilePathAndTime[0]);

        String fImport = arrayOfFiles[1].getFilePath();
        String fPrices = String.valueOf(arrayOfFiles[2].getFilePath());
        String fStock = String.valueOf(arrayOfFiles[3].getFilePath());


        LinkedList list = doParseXml.getListOfGoods(fImport);
//        LinkedList list = doParseXml.getListOfGoods(fileOfGoods01);
        HashMap<String, Goods> mapOfGoods = new HashMap();
        int count = 0;
        int countOfZerro = 0;
        while (list.iteratorHasNext()) {
            Goods tempGods = (Goods) list.iteratorNext();
            mapOfGoods.put(tempGods.getId(), tempGods);
            count++;
        }
        mapOfGoods = doParseXml.addPrisesToGoods(mapOfGoods, fPrices);
        doParseXml.addStockOfGoods(mapOfGoods, fStock);
        mapOfGoods.forEach((sId, goods) -> System.out.println(goods.getName()
                + ", prise: " + goods.getPriseCommon() + " $ Stock: " + goods.getStockBalanse()));
        System.out.println("Size of map: " + mapOfGoods.size());
    }

    @Test
    void addPrisesToGoods() {

    }

    @Test
    void addStockOfGoods() {
    }
}