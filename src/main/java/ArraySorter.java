import java.util.Calendar;

public class ArraySorter {
    public FilePathAndTime[] bouble(FilePathAndTime[] filePathAndTime, boolean message) {

        int inner, outer;
        Long startTime = Calendar.getInstance().getTime().getTime();
        for (outer = filePathAndTime.length - 1; outer > 1; outer--) {
            for (inner = 0; inner < outer; inner++) {

                if (filePathAndTime[inner].getTimeOfCreate().getTime() > filePathAndTime[inner + 1].getTimeOfCreate().getTime()) {
                    FilePathAndTime temp = filePathAndTime[inner];

                    filePathAndTime[inner] = filePathAndTime[inner + 1];
                    filePathAndTime[inner + 1] = temp;
                }
            }
        }
        Long endTime = Calendar.getInstance().getTime().getTime();
        if (message) {
            System.out.println(String.format("Bubble sorting %s items took %s milliseconds", filePathAndTime.length, (endTime - startTime) ));
        }
        return filePathAndTime;
    }
}
