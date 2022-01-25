import java.util.Date;
import java.util.Objects;

public class FilePathAndTime {


    private String filePath;
    private Date timeOfCreate;
    private Type type;
    FilePathAndTime(String filePath){

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
}

enum Type {
    IMPORT, PRICES, REST
}