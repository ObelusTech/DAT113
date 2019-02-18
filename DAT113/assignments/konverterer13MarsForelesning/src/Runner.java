public class Runner {
    public static void main(String[] args) {

       /* vanligKlasse forste = new vanligKlasse();
        vanligKlasse andre = new vanligKlasse();
        forste.entekst = "hei";
        System.out.println(andre.entekst);
        */

       Singleton forste = Singleton.getInstance();
       Singleton andre = Singleton.getInstance();
       forste.entekst = "Bavel";
       System.out.println(andre.entekst);
    }
}
