import org.junit.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockTest {

    @Test
    public void testLastMinute0() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(14, 0))[4]).isEqualTo("....");
    }

    @Test
    public void testLastMinute4() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 4))[4]).isEqualTo("0000");
    }

    @Test
    public void testLastMinute5() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 5))[4]).isEqualTo("....");
    }

    @Test
    public void testFirstMinute0() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 0))[3]).isEqualTo("...........");
    }

    @Test
    public void testFirstMinute4() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 4))[3]).isEqualTo("...........");
    }

    @Test
    public void testFirstMinute5() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 5))[3]).isEqualTo("0..........");
    }

    @Test
    public void testFirstMinute59() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(17, 59))[3]).isEqualTo("00R00R00R00");
    }

    @Test
    public void testFirstHours0() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(0, 59))[1]).isEqualTo("....");
    }

    @Test
    public void testFirstHours23() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(23, 59))[1]).isEqualTo("0000");
    }

    @Test
    public void testFirstHours4() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(4, 59))[1]).isEqualTo("....");
    }

    @Test
    public void testFirstHours5() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(5, 59))[1]).isEqualTo("0...");
    }


    @Test
    public void testLastHours0() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(0, 59))[2]).isEqualTo("....");
    }

    @Test
    public void testLastHours4() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(4, 59))[2]).isEqualTo("0000");
    }

    @Test
    public void testLastHours5() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(5, 59))[2]).isEqualTo("....");
    }

    @Test
    public void testOddSecond() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(5, 59, 1))[0]).isEqualTo(".");
    }

    @Test
    public void testEvenSecond() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(5, 59, 24))[0]).isEqualTo("0");
    }

}
