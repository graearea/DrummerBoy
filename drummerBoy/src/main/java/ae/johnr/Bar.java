package ae.johnr;

public class Bar {

    private final int beats;

    private final String pattern;

    private int position = 0;

    public Bar(String pattern) {
        this.pattern = pattern;
        beats = countBeats(pattern);
    }

    private int countBeats(String pattern) {
        int length = pattern.length();
        if (length == 4 || length == 8 || length == 16)
            return length;
        throw new RuntimeException("Invalid length of bar, need 4/8/16 not " + length);
    }

    public int getBeats() {
        return beats;
    }

    public Tick tick() {
        if(position==beats)
            position=0;
        return Tick.from(pattern.substring(position,++position));
    }


    public enum Tick {
        beat, empty, unidentified;

        public static Tick from(String notation) {
            if ("x".equals(notation))
                return beat;
            if ("o".equals(notation))
                return empty;
            return unidentified;
        }

    }

}
