package ae.johnr.drummer;

import javax.sound.midi.ShortMessage;

import static ae.johnr.drummer.MidiMessageType.controlChange;


public class BeatFactory {

    public DrumBeat createBeat(ShortMessage message, MidiMessageType type) {
        if (type== controlChange)
        {
            return new DrumBeat(PadId.HH_pedal,message.getData2());
        }
        return new DrumBeat(PadId.from(message.getData1()),message.getData2());
    }
}
