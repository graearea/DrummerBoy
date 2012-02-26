package ae.johnr;

public class DrumBeat{
    public final PadId padId;
    public final int velocity;

    public DrumBeat(PadId padId, int velocity){
        this.padId = padId;
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return padId.name()+" v:"+velocity;
    }
}
