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

        DoParseXml doParseXml=new DoParseXml();
        LinkedList list=doParseXml.getListOfGoods(".\\src\\main\\resources\\import.xml");
        HashMap<String, Goods> mapOfGoods = new HashMap();
        int count = 0;
        int countOfZerro = 0;
        while (list.iteratorHasNext()) {
            Goods tempGods = list.iteratorNext();
            mapOfGoods.put(tempGods.getId(), tempGods);
//            int k = tempGods.getKod();
//            System.out.println(k);
//            if (k == 0) {
//                 System.out.println(tempGods.getName());
//                countOfZerro++;
//            }
            count++;
        }
        System.out.println("Capacity of LincedList: " + list.getCapacity());
        System.out.println(count + "  " + countOfZerro);
        System.out.println(mapOfGoods.toString());
    }

}



