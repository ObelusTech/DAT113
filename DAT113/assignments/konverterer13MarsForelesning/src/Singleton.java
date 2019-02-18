


public final class Singleton {
    private static final Singleton s = new Singleton();
    public String entekst = "";
    public static Singleton getInstance() {
        return s;
    }

}
