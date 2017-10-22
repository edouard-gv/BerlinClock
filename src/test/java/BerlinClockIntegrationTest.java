import org.junit.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockIntegrationTest {

    @Test
    public void testMidnight() throws Exception {
        BerlinClock berlinClock = new BerlinClock();
        LocalTime time = LocalTime.of(0, 0, 0);
        assertThat(berlinClock.getTime(time)[0]).isEqualTo("0");
        assertThat(berlinClock.getTime(time)[1]).isEqualTo("....");
        assertThat(berlinClock.getTime(time)[2]).isEqualTo("....");
        assertThat(berlinClock.getTime(time)[3]).isEqualTo("...........");
        assertThat(berlinClock.getTime(time)[4]).isEqualTo("....");
    }

    @Test
    public void testJustBeforeMidnight() throws Exception {
        BerlinClock berlinClock = new BerlinClock();
        LocalTime time = LocalTime.of(23, 59, 59);
        assertThat(berlinClock.getTime(time)[0]).isEqualTo(".");
        assertThat(berlinClock.getTime(time)[1]).isEqualTo("0000");
        assertThat(berlinClock.getTime(time)[2]).isEqualTo("000.");
        assertThat(berlinClock.getTime(time)[3]).isEqualTo("00R00R00R00");
        assertThat(berlinClock.getTime(time)[4]).isEqualTo("0000");
    }

    @Test
    public void testLeatTime() throws Exception {
        BerlinClock berlinClock = new BerlinClock();
        LocalTime time = LocalTime.of(13, 37, 37);
        assertThat(berlinClock.getTime(time)[0]).isEqualTo(".");
        assertThat(berlinClock.getTime(time)[1]).isEqualTo("00..");
        assertThat(berlinClock.getTime(time)[2]).isEqualTo("000.");
        assertThat(berlinClock.getTime(time)[3]).isEqualTo("00R00R0....");
        assertThat(berlinClock.getTime(time)[4]).isEqualTo("00..");
    }

    @Test
    public void testParseMidnight() throws Exception {
        BerlinClock berlinClock = new BerlinClock();
        String[] berlinTime = {".", "....", "....", "...........", "...."};
        assertThat(berlinClock.parseTime(berlinTime)).isEqualTo(LocalTime.of(0,0));
    }

    //Les tests d'intégration qui suivent ne passent pas, c'est juste pour noter la direction
    //@Test
    public void testParseJustBeforMidnight() throws Exception {
        BerlinClock berlinClock = new BerlinClock();
        String[] berlinTime = {".", "0000", "000.", "00R00R00R00", "0000"};
        assertThat(berlinClock.parseTime(berlinTime)).isEqualTo(LocalTime.of(23,59));
    }

    //@Test
    public void testParseLeatTime() throws Exception {
        BerlinClock berlinClock = new BerlinClock();
        String[] berlinTime = {".", "00..", "000.", "00R00R0....", "00.."};
        assertThat(berlinClock.parseTime(berlinTime)).isEqualTo(LocalTime.of(13,37));
    }

}