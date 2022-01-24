
import java.util.Arrays;
import java.util.Date;

public class FileBox {

    //    public FileNode FileNode;
    private int capasity;
    FileNode mainArray[];

    public FileBox() {
        capasity = 100;
        mainArray = new FileNode[capasity];
    }

    public class FileNode {
        private Date timeOfCreate;
        private LinkedList<String> listOfFile;

        public FileNode() {

        }

        public FileNode(String fileName, Date timeOfCreate) {
            this.timeOfCreate =  timeOfCreate;
            listOfFile=new LinkedList<>();
            this.listOfFile.insert(fileName);
        }
        public Date getTimeOfCreate() {
            return timeOfCreate;
        }

        public void setTimeOfCreate(Date timeOfCreate) {
            this.timeOfCreate = timeOfCreate;
        }

        public void addFile(String fileName, Date dateOfCreate) {
            listOfFile.insert(fileName);
        }

        @Override
        public String toString() {
            return "FileNode{" +
                    "timeOfCreate=" + timeOfCreate.getTime() +
                    ", listOfFile=" + listOfFile +
                    '}';
        }
    }

    public void addFile(String fileName, Date timeOfCreate) {


        FileNode fileNode = new FileNode(fileName, timeOfCreate);
        mainArray[0] = fileNode;
//        choosing a cell to place a node +- 10 minutes
//        node call
//        adding file path



    }

    @Override
    public String toString() {
        return "FileBox{capasity=" + capasity +
                ", mainArray=" + Arrays.toString(mainArray) +
                '}';
    }
}
