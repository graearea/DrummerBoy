package ae.johnr;

import javax.sound.midi.ShortMessage;

public enum MidiMessageType{
    noteOn(0x90),
    noteOff(0x80),
    polyphonicKeyPressure (0xa0),
    controlChange(0xb0),
    unknownMessageType(0x00),
    ;
    public final int msgId;

    public static MidiMessageType from(ShortMessage shortMessage)
    {
        for (MidiMessageType mmt : MidiMessageType.values()) {
            if (mmt.msgId == shortMessage.getCommand())
                return mmt;
        }
        return unknownMessageType;
    }
    MidiMessageType(int msgId) {

        this.msgId = msgId;
    }


}
