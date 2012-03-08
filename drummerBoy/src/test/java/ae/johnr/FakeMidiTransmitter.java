package ae.johnr;

import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Transmitter;

public class FakeMidiTransmitter extends Thread implements Transmitter {

    @Override
    public void start() {
        long start = System.currentTimeMillis();
        while (true) {
            ShortMessage message = new ShortMessage();
            try {
                message.setMessage(MidiMessageType.noteOn.msgId
                        , PadId.snare.head, (Integer.parseInt((Math.random() * 126) + "")));

                receiver.send(message, System.currentTimeMillis() - start);

                wait(1000);
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
        start();
    }

    Receiver receiver;

    public void close() {
    }
}
