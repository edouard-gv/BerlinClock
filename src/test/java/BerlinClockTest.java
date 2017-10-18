import org.junit.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockTest {

    @Test
    public void test() {
        BerlinClock berlinClock = new BerlinClock();
        assertThat(berlinClock.getTime(LocalTime.of(14, 0))[3]).isEqualTo("....");
    }
}
