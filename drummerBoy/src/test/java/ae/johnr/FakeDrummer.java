package ae.johnr;

import javax.sound.midi.ShortMessage;
import javax.sound.midi.Transmitter;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;

public class FakeDrummer implements Runnable {

    private final DrumKit kit;

    public FakeDrummer(DrumKit kit) {
        this.kit = kit;
    }

    public void run() {
        long start = System.currentTimeMillis();
        Random random = new Random(99999999);
        while (true) {
            List<PadId> beats = getBeats();
            for (PadId beat : beats) {

                ShortMessage message = new ShortMessage();
                try {

                    message.setMessage(MidiMessageType.noteOn.msgId
                            ,beat.head,
                            (random.nextInt(5)) +
                                    120
                    );

                    kit.getReceiver().send(message, System.currentTimeMillis() - start);

                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<PadId> getBeats() {
        List<PadId>result=newArrayList();
        Map<PadId,Bar> pads = kit.getKit();
        for (PadId pad: pads.keySet()) {
            if (pads.get(pad).tick()== Bar.Tick.beat)
            {
                result.add(pad);
            }
        }
        return result;
    }
}
