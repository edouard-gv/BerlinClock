import java.time.LocalTime;

public class BerlinClock {

    private static final char NO_LIGHT = '.';
    private static final char YELLOW_LIGHT = '0';
    private static final char RED_LIGHT = 'R';

    public String[] getTime(LocalTime time) {

        String[] clock  = new String[5];

        clock[0]= (time.getSecond() % 2 == 0 ? String.valueOf(YELLOW_LIGHT) : String.valueOf(NO_LIGHT));

        clock[1]= getRow(4, time.getHour()/5);
        clock[2]= getRow(4, time.getHour()%5);
        clock[3] = redify(getRow(11, time.getMinute() / 5));
        clock[4] = getRow(4, time.getMinute() % 5);

        return clock;
    }

    private String getRow(int size, int pos) {
        StringBuilder minLastsRow = new StringBuilder();
        for (int i = 0; i < size; i++) {
            minLastsRow.append(i <= pos -1 ? String.valueOf(YELLOW_LIGHT) : String.valueOf(NO_LIGHT));
        }
        return minLastsRow.toString();
    }

    private String redify(String row) {
        StringBuilder redRow = new StringBuilder();
        for (int i = 0; i < row.length(); i++) {
            redRow.append (row.charAt(i) == YELLOW_LIGHT && i%3 == 2 ? RED_LIGHT : row.charAt(i));
        }
        return redRow.toString();
    }

    public LocalTime parseTime(String[] berlinTime) {
        return LocalTime.of(
                5*getSwitchPos(berlinTime[1])+getSwitchPos(berlinTime[2]),
                5*getSwitchPos(berlinTime[3])+getSwitchPos(berlinTime[4]));
    }

    //should be private, default package to be unittested
    static int getSwitchPos(String str) {
        return (str.indexOf(NO_LIGHT) >= 0? str.indexOf(NO_LIGHT) : str.length() );
    }

}
