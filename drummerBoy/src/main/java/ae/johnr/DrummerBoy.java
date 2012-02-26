package ae.johnr;

import ae.johnr.javamidi.DumpReceiver;

import javax.sound.midi.*;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class DrummerBoy 
{
    public void main(String[] args){new DrummerBoy();}
    public DrummerBoy() {
        MidiDeviceHandler  midiDeviceHandler = new MidiDeviceHandler();
        MidiDevice inputDevice = midiDeviceHandler.getDevice();
        DrumReceiver r = new DrumReceiver(new BeatFactory());
        r.addListener(new BeatListener(){
            public void strike(DrumBeat beat) {

                System.out.println(beat);
            }
        });

        try {
            Transmitter t = inputDevice.getTransmitter();
            t.setReceiver(r);
        } catch (MidiUnavailableException e) {
            out("wasn't able to connect the device's Transmitter to the Receiver:");
            out(e);
            inputDevice.close();
            System.exit(1);
        }

        try {
            System.in.read();
        } catch (IOException ioe) {
        }
        inputDevice.close();
//        out("Received " + ((DumpReceiver) r).seCount + " sysex messages with a total of " + ((DumpReceiver) r).seByteCount + " bytes");
//        out("Received " + ((DumpReceiver) r).smCount + " short messages with a total of " + ((DumpReceiver) r).smByteCount + " bytes");
//        out("Received a total of " + (((DumpReceiver) r).smByteCount + ((DumpReceiver) r).seByteCount) + " bytes");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//                out(e);
//        }
    }
    private static void out(Throwable t) {
            t.printStackTrace();
    }

    private static void out(String strMessage) {
        System.out.println(strMessage);
    }
}
