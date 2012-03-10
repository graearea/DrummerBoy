package ae.johnr;

import com.google.common.collect.Maps;

import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;
import java.util.Map;

public class DrumKit implements Transmitter {


    Map<PadId, Bar> kit = Maps.newHashMap();

    public DrumKit() {
    }

    public void addDrummerToKit(PadId pad, Bar bar) {
        kit.put(pad, bar);
    }

    public Map<PadId, Bar> getKit() {
        return kit;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
        startKit();
    }


    private void startKit() {
        new Thread(new FakeDrummer(this)).start();
    }

    Receiver receiver;

    public void close() {
    }
}
