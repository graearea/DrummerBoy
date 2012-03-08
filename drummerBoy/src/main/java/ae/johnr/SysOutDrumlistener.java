package ae.johnr;

/**
 * Created by IntelliJ IDEA.
 * User: John
 * Date: 08/03/12
 * Time: 21:16
 * To change this template use File | Settings | File Templates.
 */
public class SysOutDrumListener implements BeatListener {
    public void strike(DrumBeat beat) {

        System.out.println(beat);
    }
}
