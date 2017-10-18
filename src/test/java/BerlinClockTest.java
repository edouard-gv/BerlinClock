import org.junit.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockTest {

    @Test
    public void testLastMinute0() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(14, 0))[3]).isEqualTo("....");
    }

    @Test
    public void testLastMinute4() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 4))[3]).isEqualTo("0000");
    }

    @Test
    public void testLastMinute5() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 5))[3]).isEqualTo("....");
    }

    @Test
    public void testFirstMinute0() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 0))[2]).isEqualTo("...........");
    }

    @Test
    public void testFirstMinute4() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 4))[2]).isEqualTo("...........");
    }

    @Test
    public void testFirstMinute5() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 5))[2]).isEqualTo("0..........");
    }

    @Test
    public void testFirstMinute59() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 59))[2]).isEqualTo("00000000000");
    }


}
