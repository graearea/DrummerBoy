package ae.johnr.javamidi;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: John
 * Date: 25/02/12
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */
public class MidiInDumpTest {
    @Test
    public void shouldListHelp() throws Exception {
        MidiInDump.main(new String[]{"-h"});
    }
    @Test
    public void shouldListDevices() throws Exception {
        MidiInDump.main(new String[]{"-l"});
    }

    @Test
    public void shouldConnect() throws Exception {

        MidiInDump.main(new String[]{"-D","-n0"});
    }
}
