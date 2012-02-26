package ae.johnr;

import javax.sound.midi.ShortMessage;

import static ae.johnr.MidiMessageType.controlChange;

/**
 * Created by IntelliJ IDEA.
 * User: John
 * Date: 26/02/12
 * Time: 10:24
 * To change this template use File | Settings | File Templates.
 */
public class BeatFactory {

    public DrumBeat createBeat(ShortMessage message, MidiMessageType type) {
        if (type== controlChange)
        {
            return new DrumBeat(PadId.HH_pedal,message.getData2());
        }
        return new DrumBeat(PadId.from(message.getData1()),message.getData2());
    }
//        switch (message.getCommand()) {
////            case 0x80:
////                strMessage = "note Off " + PadId.from(message.getData1()) + " velocity: " + message.getData2();
////                break;
//
//            case 0x90:
//                strMessage = "note On " + PadId.from(message.getData1()) + " velocity: " + message.getData2();
//                break;
//
//            case 0xa0:
//                strMessage = "polyphonic key pressure " + PadId.from(message.getData1()) + " pressure: " + message.getData2();
//                break;
//
//            case 0xb0:
//                strMessage = "control change " + message.getData1() + " value: " + message.getData2();
//                break;
//
//            default:
//                return null;
//        }
//        if (message.getCommand() != 0xF0) {
//            int nChannel = message.getChannel() + 1;
//            String strChannel = "channel " + nChannel + ": ";
//            strMessage = strChannel + strMessage;
//        }
//        return "[" + (message) + "] " + strMessage;

}
