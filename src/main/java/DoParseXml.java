import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class DoParseXml {

    public HashMap getGods(String fImport, String fPrices, String fRest, Date date) {

        HashMap<String, Goods> mapOfGoods = new HashMap();
        DoParseXml doParseXml = new DoParseXml();
        LinkedList list = doParseXml.getListOfGoods(fImport);
        while (list.iteratorHasNext()) {
            Goods tempGods = (Goods) list.iteratorNext();
            tempGods.setDate(date);
            mapOfGoods.put(tempGods.getId(), tempGods);
        }
        doParseXml.addPrisesToGoods(mapOfGoods, fPrices);
        doParseXml.addStockOfGoods(mapOfGoods, fRest);
        return mapOfGoods;
    }


    private Document getDocument(String fileName) {
        File inputFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        Document doc = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public String getDate(String fileName) {
        String sDate;
        Document doc = getDocument(fileName);
        NodeList timeList = doc.getElementsByTagName("КоммерческаяИнформация");
        sDate = timeList.item(0).getAttributes().getNamedItem("ДатаФормирования").toString().trim();
        return sDate;
    }

    public LinkedList getListOfGoods(String fileName) {
        LinkedList list = new LinkedList();
        String kodGoods;
        char kod[] = new char[3];
        char id[] = new char[11];
        try {
            Document doc = getDocument(fileName);

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
            System.out.println("Exceeding prop values Import");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public HashMap addPrisesToGoods(HashMap goods, String fileName) {
        try {
            File inputFile = new File(fileName);
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
                    NodeList priseNodeList = ((Element) nNode).getElementsByTagName("ЦенаЗаЕдиницу");
                    for (int j = 0; j < priseNodeList.getLength(); j++) {
                        Node priseNode = priseNodeList.item(j);
                        if (priseNode.getNodeType() == Node.ELEMENT_NODE) {
                            Double d = Double.parseDouble(priseNode.getTextContent().strip());
                            switch (j) {
                                case 0:
                                    goodsTmp.setPriseCommon(d);
                                    break;
                                case 1:
                                    goodsTmp.setPriseWhole(d);
                                    break;
                                case 2:
                                    goodsTmp.setPriseVip(d);
                            }
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

    public HashMap addStockOfGoods(HashMap goods, String fileName) {
        try {
            Document doc = getDocument(fileName);
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
                        Integer intStock = Integer.parseInt(stockOfGoods);
                        goodsTmp.setStockBalanse(intStock);
                        goods.replace(sId, goodsTmp);
                    }
                }
            }
        } catch (
                NullPointerException e) {
            System.out.println("Exceeding prop values Rest");
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return goods;
    }
}
