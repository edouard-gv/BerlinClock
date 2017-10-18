import java.time.LocalTime;

public class BerlinClock {

    public String[] getTime(LocalTime time) {

        String[] clock  = new String[4];

        StringBuilder minLastsRow = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            minLastsRow.append(i <= time.getMinute()%5 -1 ? "0" : ".");
        }

        clock[3] = minLastsRow.toString();

        StringBuilder minFirstRow = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            minFirstRow.append(i <= time.getMinute()/5 -1 ? "0" : ".");
        }

        clock[2] = minFirstRow.toString();

        return clock;
    }
}
