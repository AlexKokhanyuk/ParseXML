import javax.xml.crypto.Data;
import java.util.Arrays;

public class FileBox {

    //    public FileNode FileNode;
    private int capasity;
    FileNode mainArray[];

    public FileBox() {
        capasity = 100;
        mainArray = new FileNode[capasity];
    }

    public class FileNode {
        private Data timeOfCreate;
        private LinkedList<String> listOfFile;

        public FileNode() {
        }

        public FileNode(String fileName, Data timeOfCreate) {
            this.timeOfCreate = timeOfCreate;
            this.listOfFile.insert(fileName);
        }

        public Data getTimeOfCreate() {
            return timeOfCreate;
        }

        public void setTimeOfCreate(Data timeOfCreate) {
            this.timeOfCreate = timeOfCreate;
        }

        public void addFile(String fileName, Data dateOfCreate) {
            listOfFile.insert(fileName);
        }

        @Override
        public String toString() {
            return "FileNode{" +
                    "timeOfCreate=" + timeOfCreate +
                    ", listOfFile=" + listOfFile +
                    '}';
        }
    }

    public void addFile(String fileName, Data timeOfCreate) {
        FileNode fileNode = new FileNode(fileName, timeOfCreate);
        mainArray[0] = fileNode;
        System.out.println(fileNode);
    }

    @Override
    public String toString() {
        return "FileBox{" +
                "FileNode=" + FileNode +
                ", capasity=" + capasity +
                ", mainArray=" + Arrays.toString(mainArray) +
                '}';
    }
}
