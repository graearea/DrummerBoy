package ae.johnr;


import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import java.util.ArrayList;
import java.util.List;

public class DrumReceiver
        implements Receiver {

    private List<BeatListener> beatListeners = new ArrayList<BeatListener>();
    private final BeatFactory beatFactory;

    public DrumReceiver(BeatFactory beatFactory) {
        this.beatFactory =  beatFactory;
    }


    public void send(MidiMessage message, long timeStamp) {
        if (message instanceof ShortMessage) {
            notifyListeners(decodeMessage((ShortMessage) message));
        }
    }

    public void addListener(BeatListener listener)
    {
        beatListeners.add(listener);
    }
    private void notifyListeners(DrumBeat beat) {
        for (BeatListener listener : beatListeners) {
            listener.strike(beat);
        }
    }

    public void close() {
    }

    public DrumBeat decodeMessage(ShortMessage message) {

        return beatFactory.createBeat(message,MidiMessageType.from(message));
    }

}
