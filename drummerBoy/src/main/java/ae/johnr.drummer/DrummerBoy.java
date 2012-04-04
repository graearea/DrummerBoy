package ae.johnr.drummer;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Transmitter;
import java.io.IOException;

/**
 * Hello world!
 */
public class DrummerBoy {

    public void main(String[] args) {
        MidiDeviceHandler midiDeviceHandler = new MidiDeviceHandler();
        new DrummerBoy(midiDeviceHandler, DrumReceiver.defaultReceiver(), new SysOutDrumListener());
    }

    public DrummerBoy(MidiDeviceHandler midiDeviceHandler, DrumReceiver drumReceiver, SysOutDrumListener listener) {
        MidiDevice inputDevice = midiDeviceHandler.getDevice();
        drumReceiver.addListener(listener);

        try {
            Transmitter t = inputDevice.getTransmitter();
            t.setReceiver(drumReceiver);
        } catch (MidiUnavailableException e) {
            System.out.println("wasn't able to connect the device's Transmitter to the Receiver:");
            e.printStackTrace();
            inputDevice.close();
            System.exit(1);
        }

        try {
            System.in.read();
        } catch (IOException ioe) {
        }
        inputDevice.close();

    }
}
