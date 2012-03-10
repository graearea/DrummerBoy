package ae.johnr;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;
import java.util.ArrayList;
import java.util.List;

public class FakeMidiDeviceHandler extends MidiDeviceHandler {

    private final DrumKit drumkit;

    public FakeMidiDeviceHandler(DrumKit drumkit) {
        this.drumkit = drumkit;
    }

    @Override
    public MidiDevice getDevice() {

        return new FakeMidiDevice(drumkit);
    }


    private class FakeMidiDevice implements MidiDevice {

        private final Transmitter fakeMidiTransmitter;

        public FakeMidiDevice(Transmitter fakeMidiTransmitter) {
            this.fakeMidiTransmitter = fakeMidiTransmitter;
        }

        public Info getDeviceInfo() {
            return null;
        }

        public void open() throws MidiUnavailableException {
        }

        public void close() {
        }

        public boolean isOpen() {
            return true;
        }

        public long getMicrosecondPosition() {
            return 0;
        }

        public int getMaxReceivers() {
            return 0;
        }

        public int getMaxTransmitters() {
            return 0;
        }

        public Receiver getReceiver() throws MidiUnavailableException {
            return null;
        }

        public List<Receiver> getReceivers() {
            return null;
        }

        public Transmitter getTransmitter() throws MidiUnavailableException {
            return fakeMidiTransmitter;
        }

        public List<Transmitter> getTransmitters() {
            List<Transmitter> list= new ArrayList<Transmitter>();
            try {
                list.add(getTransmitter());
            } catch (MidiUnavailableException e) {
                }
            return list
                    ;  //To change body of implemented methods use File | Settings | File Templates.
        }


    }
}
