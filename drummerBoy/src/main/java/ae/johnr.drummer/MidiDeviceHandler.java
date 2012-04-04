package ae.johnr.drummer;


import ae.johnr.drummer.javamidi.MidiCommon;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;

import static ae.johnr.drummer.javamidi.MidiCommon.getMidiDeviceInfo;

public class MidiDeviceHandler {
    String strDeviceName = null;
    int nDeviceIndex = 0;
    boolean bUseDefaultSynthesizer = false;

    public MidiDeviceHandler() {

    }

    public MidiDevice getDevice() {
        MidiDevice.Info info;
        if (strDeviceName != null) {
            info = MidiCommon.getMidiDeviceInfo(strDeviceName, false);
        } else {
            info = MidiCommon.getMidiDeviceInfo(nDeviceIndex);
        }
        if (info == null) {
            if (strDeviceName != null) {
                out("no device info found for name " + strDeviceName);
            } else {
                out("no device info found for index " + nDeviceIndex);
            }
            System.exit(1);
        }
        MidiDevice inputDevice = null;
        try {
            inputDevice = MidiSystem.getMidiDevice(info);
            inputDevice.open();
        } catch (MidiUnavailableException e) {
            out(e);
        }
        return inputDevice;


    }

    private static void out(Throwable t) {
            t.printStackTrace();
    }

    private static void out(String strMessage) {
        System.out.println(strMessage);
    }
}
