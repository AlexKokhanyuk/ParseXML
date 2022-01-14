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
        String fileOfGoods =".\\src\\main\\resources\\import.xml";
        String fileOfGoods01 =".\\src\\main\\resour\\src\\main\\resources\\CES\\import___5493abdf-394d-49b9-bd4c-736cbaed61d0.xml";
        String fileOfGoods02 =".\\src\\main\\resour\\src\\main\\resources\\CES\\import___d49c4025-5fa1-49e4-9308-867c73d5c675.xml";
        LinkedList list=doParseXml.getListOfGoods(fileOfGoods02);
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



