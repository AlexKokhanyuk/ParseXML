/**
 * @author Oleksandr Kokhaniuk
 * @created 30/11/2021 - 13:31
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ParseXml {
    public static void main(String[] args) {

        DoParseXml doParseXml = new DoParseXml();
        String fileOfGoods = ".\\src\\main\\resources\\import.xml";
        String fileOfGoods01 = ".\\src\\main\\resources\\import___5493abdf-394d-49b9-bd4c-736cbaed61d0.xml";
        String fileOfGoods02 = ".\\src\\main\\resources\\import___d49c4025-5fa1-49e4-9308-867c73d5c675.xml";
        String fileOfPrises = ".\\src\\main\\resources\\prices___aa9533e0-4970-4592-9f9f-6480fdf8b99c.xml";
        String fileOfStock = ".\\src\\main\\resources\\rests___5a4c78e7-fca4-4a4f-bc9c-6f849b4f3253.xml";

        LinkedList list = doParseXml.getListOfGoods(fileOfGoods01);
        HashMap<String, Goods> mapOfGoods = new HashMap();
        int count = 0;
        int countOfZerro = 0;
        while (list.iteratorHasNext()) {
            Goods tempGods = list.iteratorNext();
            mapOfGoods.put(tempGods.getId(), tempGods);
            count++;
        }
        doParseXml.addPrisesToGoods(mapOfGoods, fileOfPrises);
        doParseXml.addStockOfGoods(mapOfGoods, fileOfStock);

//        if (!list.isEmpty()) {
//            System.out.println("Capacity of LincedList: " + list.getCapacity());
//            System.out.println(count + "  " + countOfZerro);
//        } else {
//            System.out.println("Goods is not found");
//        }
        mapOfGoods.forEach((sId, goods) -> System.out.println(goods.getName()
                + ", prise: " + goods.getPriseCommon() + " $ Stock: "+goods.getStockBalanse()));
        System.out.println("Size of map: " + mapOfGoods.size());
    }
}



