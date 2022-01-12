public class Goods {
    public Goods() {
    }

    public Goods(String name, int cod) {
        this.name = name;
        this.kod = kod;

    }

    private String name;
    private int kod;
    private String id;
//    private int guid;
//
//
//    public int getGuid() {
//        return guid;
//    }
//
//    public void setGuid(int guid) {
//        this.guid = guid;
//    }

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
        return "'" + name + '\'' +
                ", kod : " + kod + ", GUID : " +id;
    }
}
