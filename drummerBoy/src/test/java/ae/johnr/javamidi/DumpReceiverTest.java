package ae.johnr.javamidi;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.ShortMessage;
import java.io.PrintStream;

import static org.mockito.Mockito.verify;

public class DumpReceiverTest {

    private DumpReceiver dumpReceiver;
    private PrintStream printStream;
    private ShortMessage msg;

    @Before
    public void setup()
    {
        printStream = Mockito.mock(PrintStream.class);
        dumpReceiver = new DumpReceiver(printStream);
        msg = new ShortMessage();

    }
    
    @Test
    public void shouldRegisterHardSnareHit() throws InvalidMidiDataException {
        msg.setMessage(ShortMessage.NOTE_ON,9,40,127);
        dumpReceiver.send(msg,10);
        verify(printStream).println("timestamp 10 us: [99 28 7F][40] channel 10: note On E2 velocity: 127");
    }

}
/*
MidiInDump.main(): device index: 0
now running; interupt the program with [ENTER] when finished
timestamp 27000 us: [B9 04 30] channel 10: control change 4 value: 48
timestamp 1423000 us: [B9 04 3F] channel 10: control change 4 value: 63
timestamp 1450000 us: [99 2E 7F] channel 10: note On A#2 velocity: 127
timestamp 1545000 us: [B9 04 30] channel 10: control change 4 value: 48
timestamp 1709000 us: [99 2E 00] channel 10: note On A#2 velocity: 0
timestamp 1882000 us: [99 28 7B] channel 10: note On E2 velocity: 123
timestamp 2109000 us: [99 28 00] channel 10: note On E2 velocity: 0
timestamp 2244000 us: [B9 04 3F] channel 10: control change 4 value: 63
timestamp 2347000 us: [99 30 70] channel 10: note On C3 velocity: 112
timestamp 2467000 us: [B9 04 30] channel 10: control change 4 value: 48
timestamp 2579000 us: [B9 04 3F] channel 10: control change 4 value: 63
timestamp 2609000 us: [99 30 00] channel 10: note On C3 velocity: 0
timestamp 2823000 us: [99 31 75] channel 10: note On C#3 velocity: 117
timestamp 3109000 us: [99 31 00] channel 10: note On C#3 velocity: 0
timestamp 3311000 us: [99 2F 78] channel 10: note On B2 velocity: 120
timestamp 3608000 us: [99 2F 00] channel 10: note On B2 velocity: 0
timestamp 3790000 us: [99 2D 61] channel 10: note On A2 velocity: 97
timestamp 3908000 us: [B9 04 31] channel 10: control change 4 value: 49
timestamp 4008000 us: [99 2D 00] channel 10: note On A2 velocity: 0
timestamp 4270000 us: [B9 04 3F] channel 10: control change 4 value: 63
timestamp 4273000 us: [99 2B 78] channel 10: note On G2 velocity: 120
timestamp 4329000 us: [B9 04 30] channel 10: control change 4 value: 48
timestamp 4508000 us: [99 2B 00] channel 10: note On G2 velocity: 0
timestamp 4549000 us: [B9 04 3F] channel 10: control change 4 value: 63
timestamp 4753000 us: [99 3B 7F] channel 10: note On B3 velocity: 127
timestamp 4763000 us: [99 33 7F] channel 10: note On D#3 velocity: 127
timestamp 5008000 us: [99 3B 00] channel 10: note On B3 velocity: 0
timestamp 5009000 us: [99 33 00] channel 10: note On D#3 velocity: 0
timestamp 5260000 us: [B9 04 30] channel 10: control change 4 value: 48
timestamp 5297000 us: [99 24 7C] channel 10: note On C2 velocity: 124
timestamp 5297000 us: [99 21 7C] channel 10: note On A1 velocity: 124
timestamp 5508000 us: [99 24 00] channel 10: note On C2 velocity: 0
timestamp 5508000 us: [99 21 00] channel 10: note On A1 velocity: 0
timestamp 5591000 us: [B9 04 1C] channel 10: control change 4 value: 28
timestamp 5645000 us: [B9 04 01] channel 10: control change 4 value: 1
timestamp 5710000 us: [B9 04 00] channel 10: control change 4 value: 0
timestamp 5817000 us: [99 2C 7F] channel 10: note On G#2 velocity: 127
timestamp 5818000 us: [B9 04 40] channel 10: control change 4 value: 64
timestamp 5939000 us: [B9 04 3F] channel 10: control change 4 value: 63
timestamp 6006000 us: [99 2C 00] channel 10: note On G#2 velocity: 0
timestamp 6007000 us: [99 2C 01] channel 10: note On G#2 velocity: 1
timestamp 6007000 us: [B9 04 40] channel 10: control change 4 value: 64
timestamp 6207000 us: [99 2C 00] channel 10: note On G#2 velocity: 0

*/