import java.util.Date;
import java.util.Objects;

public class FilePathAndTime implements Comparable<FilePathAndTime>{
    private String filePath;
    private Date timeOfCreate;
    private Type type;

    FilePathAndTime() {

    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setTimeOfCreate(Date timeOfCreate) {
        this.timeOfCreate = timeOfCreate;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFilePath() {
        return filePath;
    }

    public Date getTimeOfCreate() {
        return timeOfCreate;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilePathAndTime)) return false;
        FilePathAndTime that = (FilePathAndTime) o;
        return getTimeOfCreate().equals(that.getTimeOfCreate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimeOfCreate());
    }

    @Override
    public String toString() {
        return "filePath='" + filePath + '\'' +
                ", Date=" + timeOfCreate +
                ", type=" + type
                ;
    }

    @Override
    public int compareTo(FilePathAndTime o) {
        int result=0;
        long lResult=timeOfCreate.getTime()-o.timeOfCreate.getTime();
        result=(int) lResult/100;

        return result;
    }
}

enum Type {
    IMPORT, PRICES, REST, CATEGORY
}