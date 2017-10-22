import java.time.LocalTime;

public class BerlinClock {

    public String[] getTime(LocalTime time) {

        String[] clock  = new String[5];

        clock[0]= (time.getSecond() % 2 == 0 ? "0" : ".");

        clock[1]= getRow(4, time.getHour()/5);
        clock[2]= getRow(4, time.getHour()%5);
        clock[3] = redify(getRow(11, time.getMinute() / 5));
        clock[4] = getRow(4, time.getMinute() % 5);

        return clock;
    }

    private String getRow(int size, int pos) {
        StringBuilder minLastsRow = new StringBuilder();
        for (int i = 0; i < size; i++) {
            minLastsRow.append(i <= pos -1 ? "0" : ".");
        }
        return minLastsRow.toString();
    }

    private String redify(String row) {
        StringBuilder redRow = new StringBuilder();
        for (int i = 0; i < row.length(); i++) {
            redRow.append (row.charAt(i) == '0' && i%3 == 2 ? 'R' : row.charAt(i));
        }
        return redRow.toString();
    }

    public LocalTime parseTime(String[] berlinTime) {
        return LocalTime.of(0,0);
    }

    //should be private, default package to be unittested
    static int getSwitchPos(String str) {
        return (str.indexOf('.') >= 0? str.indexOf('.') : str.length() );
    }

}
