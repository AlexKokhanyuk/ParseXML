public class Goods {
    public Goods() {
        priseCommon = 0.0;
        priseWhole = 0.0;
        priseVip = 0.0;
        stockBalanse = 0;
    }

    public Goods(String name, int cod) {
        this.name = name;
        this.kod = kod;

    }

    private String name;
    private int kod;
    private String id;
    private double priseCommon;
    private double priseWhole;
    private double priseVip;
    private int stockBalanse;

    public double getPriseWhole() {
        return priseWhole;
    }

    public void setPriseWhole(double priseWhole) {
        this.priseWhole = priseWhole;
    }

    public double getPriseVip() {
        return priseVip;
    }

    public void setPriseVip(double priseVip) {
        this.priseVip = priseVip;
    }

    public int getStockBalanse() {
        return stockBalanse;
    }

    public void setStockBalanse(int stockBalanse) {
        this.stockBalanse = stockBalanse;
    }

    public double getPriseCommon() {
        return priseCommon;
    }

    public void setPriseCommon(double priseCommon) {
        this.priseCommon = priseCommon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", kod=" + kod +
                ", id='" + id + '\'' +
                ", priseCommon=" + priseCommon +
                ", priseWhole=" + priseWhole +
                ", priseVip=" + priseVip +
                ", stockBalanse=" + stockBalanse +
                '}';
    }
}
