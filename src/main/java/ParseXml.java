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

//        String nameGoods;
        String kodGoods;

        char kod[] = new char[3];
        char id[] = new char[11];
        LinkedList list = new LinkedList();
        String fileName = new String(".\\src\\main\\resources\\import.xml");

        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
//            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Товар");

            for (int i = 0; i < nList.getLength(); i++) {
                Goods goods = new Goods();
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    goods.setName(eElement.getElementsByTagName("Наименование")
                            .item(0).getTextContent());
                    goods.setId(eElement.getElementsByTagName("Ид")
                            .item(0).getTextContent());
                    for (int j = 1; j < 8; j++) {
                        kodGoods = eElement
                                .getElementsByTagName("ЗначениеРеквизита")
                                .item(j).getTextContent().strip();
                        kodGoods.getChars(0, 3, kod, 0);
                        if (kod[0] == 'К' & kod[1] == 'о' & kod[2] == 'д') {
                            int leng = kodGoods.length();
                            kodGoods.getChars(leng - 11, leng, id, 0);
                            goods.setKod(Integer.parseInt(new String(id)));
                            break;
                        }
                    }
                }
                list.insert(goods);
            }
        } catch (NullPointerException e) {
            System.out.println("Выход за пределы значений реквизита");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String, Goods> mapOfGoods = new HashMap();

//        list.printList();
        int count = 0;
        int countOfZerro = 0;


        while (list.iteratorHasNext()) {

            Goods tempGods = list.iteratorNext();
            mapOfGoods.put(tempGods.getId(), tempGods);
            int k = tempGods.getKod();

            System.out.println(k);
            if (k == 0) {
                 System.out.println(tempGods.getName());
                countOfZerro++;
            }
            count++;

        }
        System.out.println("Capacity of LincedList: " + list.getCapacity());
        System.out.println(count + "  " + countOfZerro);
        System.out.println(mapOfGoods.toString());
    }

}



