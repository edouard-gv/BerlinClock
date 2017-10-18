import java.time.LocalTime;

public class BerlinClock {

    public String[] getTime(LocalTime time) {

        String[] clock  = new String[4];

        int pos1 = 4;
        int size1 = time.getMinute() % 5;
        String s1 = getRow(pos1, size1);
        clock[3] = s1;

        int pos2 = 11;
        int size2 = time.getMinute() / 5;
        String s2 = getRow(pos2, size2);
        clock[2] = s2;

        return clock;
    }

    private String getRow(int pos, int size) {
        StringBuilder minLastsRow = new StringBuilder();
        for (int i = 0; i < pos; i++) {
            minLastsRow.append(i <= size -1 ? "0" : ".");
        }
        return minLastsRow.toString();
    }
}
