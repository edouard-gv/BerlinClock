import java.time.LocalTime;

public class BerlinClock {

    public String[] getTime(LocalTime time) {

        String[] clock  = new String[4];

        int pos1 = 4;
        int size1 = time.getMinute() % 5;
        StringBuilder minLastsRow = new StringBuilder();
        for (int i = 0; i < pos1; i++) {
            minLastsRow.append(i <= size1 -1 ? "0" : ".");
        }
        String s1 = minLastsRow.toString();
        clock[3] = s1;

        int pos2 = 11;
        int size2 = time.getMinute() / 5;
        StringBuilder minFirstRow = new StringBuilder();
        for (int i = 0; i < pos2; i++) {
            minFirstRow.append(i <= size2 -1 ? "0" : ".");
        }
        String s2 = minFirstRow.toString();
        clock[2] = s2;

        return clock;
    }
}
