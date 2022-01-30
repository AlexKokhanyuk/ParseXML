/**
 * @author Oleksandr Kokhaniuk
 * @created 30/11/2021 - 13:31
 */


import java.util.ArrayList;
import java.util.HashMap;


public class ParseXml {
    public static void main(String[] args) throws UncomStuctureException {


        MainController controller = new MainController();
//        ArrayList<HashMap> listOfOnloading = controller.listOfOnloading(".\\src\\main\\resources\\");
//        ArrayList<HashMap> listOfOnloading = controller.listOfOnloading("C:\\tmp\\temp");
        ArrayList<HashMap> listOfOnloading = controller.listOfOnloading("C:\\tmp\\temp1");

        for (HashMap<String, Goods> mapOfGoods : listOfOnloading) {
            mapOfGoods.forEach((sId, goods) -> System.out.println(goods.getName()
                    + ", prise: " + goods.getPriseCommon() + " $ Stock: " + goods.getStockBalanse()+" GUID: "+ goods.getId()));
            System.out.println("Size of map: " + mapOfGoods.size());
            System.out.println("--------------------------------------------");

            Goods good = mapOfGoods.get("2a47a6a5-783b-11ec-80c7-b4b52f64fada");
            if (good != null) {

                System.out.println(good.getName()+", :"+good.getDate()+", Stock:"+good.getStockBalanse());
            }
        }
    }
}



