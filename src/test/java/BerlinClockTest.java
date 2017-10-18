import org.junit.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockTest {

    @Test
    public void test() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(14, 0))[3]).isEqualTo("....");
        assertThat(berlinClock.getTime(LocalTime.of(14, 1))[3]).isEqualTo("0...");
        assertThat(berlinClock.getTime(LocalTime.of(14, 4))[3]).isEqualTo("0000");
        assertThat(berlinClock.getTime(LocalTime.of(14, 5))[3]).isEqualTo("....");
        assertThat(berlinClock.getTime(LocalTime.of(14, 10))[3]).isEqualTo("....");
    }
}
