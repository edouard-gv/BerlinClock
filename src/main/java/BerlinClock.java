import java.time.LocalTime;

public class BerlinClock {

    public String[] getTime(LocalTime time) {

        String[] clock  = new String[4];

        clock[3] = getRow(4, time.getMinute() % 5);
        clock[2] = getRow(11, time.getMinute() / 5);

        return clock;
    }

    private String getRow(int size, int pos) {
        StringBuilder minLastsRow = new StringBuilder();
        for (int i = 0; i < size; i++) {
            minLastsRow.append(i <= pos -1 ? "0" : ".");
        }
        return minLastsRow.toString();
    }
}
