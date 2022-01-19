import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class DoParseXml {

    public LinkedList getListOfGoods(String file) {
        LinkedList list = new LinkedList();
        String kodGoods;
        char kod[] = new char[3];
        char id[] = new char[11];
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
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
        return list;
    }

    public HashMap addPrisesToGoods(HashMap goods, String file) {
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Предложение");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String sId = eElement.getElementsByTagName("Ид")
                            .item(0).getTextContent().strip();
                    Goods goodsTmp = (Goods) goods.get(sId);
                    NodeList priseNodeList = ((Element) nNode).getElementsByTagName("Количество");
                    for (int j = 0; j < priseNodeList.getLength(); j++) {
                        Node priseNode = priseNodeList.item(j);
                        if (priseNode.getNodeType() == Node.ELEMENT_NODE) {
                            Integer iStock = Integer.parseInt(priseNode.getTextContent().strip());
                            System.out.println(iStock);
                            goodsTmp.setStockBalanse(iStock);
                        }

                    }
                    goods.replace(sId, goodsTmp);
                }
            }
        } catch (
                NullPointerException e) {
            System.out.println("Выход за пределы значений реквизита");
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found");
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return goods;
    }

    public HashMap addStockOfGoods(HashMap goods, String file) {
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Предложение");
            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String sId = eElement.getElementsByTagName("Ид")
                            .item(0).getTextContent().strip();
                    Goods goodsTmp = (Goods) goods.get(sId);
                    Node childNode = (Node) nNode.getChildNodes();
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element sElement = (Element) childNode;
                        String stockOfGoods = sElement.getElementsByTagName("Количество")
                                .item(0).getTextContent().strip();
//                        System.out.println(stockOfGoods);
                        Integer intStock=Integer.parseInt(stockOfGoods);
                        goodsTmp.setStockBalanse(intStock);
                    goods.replace(sId, goodsTmp);
                    }
                }
            }
        } catch (
                NullPointerException e) {
            System.out.println("Выход за пределы значений реквизита");
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found");
        } catch (
                Exception e) {
            e.printStackTrace();
        }

        return goods;
    }

}
