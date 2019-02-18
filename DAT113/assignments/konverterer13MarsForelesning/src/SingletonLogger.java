public class SingletonLogger {

    private final static SingletonLogger s = new SingletonLogger();

    int tall = 0;

    public static SingletonLogger getInstance() {

        return s;
    }

    public void logData(String data) {

        System.out.println("("+tall+")");
        tall++;
    }

}
