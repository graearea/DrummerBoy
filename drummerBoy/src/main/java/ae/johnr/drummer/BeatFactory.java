package ae.johnr.drummer;

import javax.sound.midi.ShortMessage;


public class BeatFactory {

    public DrumBeat createBeat(ShortMessage message, MidiMessageType type) {
        if (type== MidiMessageType.controlChange)
        {
            return new DrumBeat(PadId.HH_pedal,message.getData2());
        }
        return new DrumBeat(PadId.from(message.getData1()),message.getData2());
    }
}
