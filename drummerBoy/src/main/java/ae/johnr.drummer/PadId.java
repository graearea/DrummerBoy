package ae.johnr.drummer;

public enum PadId {
    snare(40, 34),
    ht(48, 13),
    mt(47, 14),
    lt(45, 15),
    kick(33, 36),
    crash(49, 55),
    ride(59, 51),
    HH(46, 16),
    HH_pedal(46, 16),
    spare(43, 17);

    public final int head;
    public final int rimshot;


    private PadId(int beat, int rimshot) {
        this.head = beat;
        this.rimshot = rimshot;
    }


    public static PadId from(int id) {
        for (PadId beat : PadId.values()) {
            if (beat.head ==(id)||beat.rimshot==id)
                return beat;
        }
        return null;
    }

    @Override
    public String toString() {
        return super.name().toUpperCase();
    }
}
