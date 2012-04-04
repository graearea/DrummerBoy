package ae.johnr.drummer;

import org.junit.Test;

/**
 * Unit test for simple DrummerBoy.
 */
public class DrummerBoyTest {
    @Test
    public void shouldRun() throws Exception {
        new DrummerBoy(new MidiDeviceHandler(), DrumReceiver.defaultReceiver(), new SysOutDrumListener());
    }

    @Test
    public void shouldPlayWithRandomDrumBeats() {
        DrumKit drumkit = new DrumKit();
        drumkit.addDrummerToKit(PadId.HH, new Bar("xxxxxxxx"));
        drumkit.addDrummerToKit(PadId.kick, new Bar("xoooxxoo"));
        drumkit.addDrummerToKit(PadId.snare, new Bar("ooxoooxo"));

        MidiDeviceHandler midiDeviceHandler = new FakeMidiDeviceHandler(drumkit);
        new DrummerBoy(midiDeviceHandler, DrumReceiver.defaultReceiver(), new SysOutDrumListener());

    }
}
