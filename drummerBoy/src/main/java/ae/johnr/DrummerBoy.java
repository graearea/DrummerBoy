package ae.johnr;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

/**
 * Hello world!
 *
 */
public class DrummerBoy 
{
    public static void main( String[] args ) throws MidiUnavailableException {
        DrummerBoy drummerBoy = new DrummerBoy();
        Receiver receiver = MidiSystem.getReceiver();
        receiver.send();
        Transmitter transmitter = MidiSystem.getTransmitter();
        transmitter.
    }
    public DrummerBoy() throws MidiUnavailableException {
        MidiReceiver midiReceiver = new MidiReceiver();
    }
}
