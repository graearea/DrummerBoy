package ae.johnr;

import org.junit.Before;
import org.junit.Test;

import static ae.johnr.Bar.Tick.beat;
import static ae.johnr.Bar.Tick.empty;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class BarTest {

    private Bar bar;

    @Before
    public void setUp() {
        bar = new Bar("oooo");
    }

    @Test
    public void programShouldHaveFourBeats() {
        assertThat(bar.getBeats(), is(equalTo(4)));
    }

    @Test
    public void ticksShouldReturnNothing() {
        for (int i = 0; i < 4; i++) {
            assertThat(bar.tick(), is(empty));
        }
    }
@Test
    public void ticksShouldReturnBeats() {
        bar = new Bar("xxxx");
        for (int i = 0; i < 4; i++) {
            assertThat(bar.tick(), is(beat));
        }
    }

    @Test
    public void barGivenPatternShouldReturnPattern()
    {
        bar=new Bar("xoxoxoxoxoxoxoxo");
        for (int i = 0; i < 16; i++) {
            assertThat(bar.tick(), is(i%2==0? beat:empty));
        }
    }
}