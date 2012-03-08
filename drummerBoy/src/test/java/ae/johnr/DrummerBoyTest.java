package ae.johnr;

import org.junit.Test;

/**
 * Unit test for simple DrummerBoy.
 */
public class DrummerBoyTest
{
    @Test
    public void shouldRun() throws Exception{
        new DrummerBoy(new MidiDeviceHandler(), DrumReceiver.defaultReceiver(), new SysOutDrumListener());
    }

    @Test
    public void shouldPlayWithRandomDrumBeats()
    {
        MidiDeviceHandler midiDeviceHandler = new FakeMidiDeviceHandler();
        new DrummerBoy(midiDeviceHandler, DrumReceiver.defaultReceiver(), new SysOutDrumListener());

    }
}
