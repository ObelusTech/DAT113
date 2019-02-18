import javax.swing.*;

public class runnerClass {

    public static void nokToEuro(double conversion) {

        double krToEuro = conversion*0.12;

        JOptionPane.showMessageDialog(null, "From Kr to Euro it will be: " + krToEuro);

    }

    public static void nokToYen(double conversion2) {

        double krToYen = conversion2*17;

        JOptionPane.showMessageDialog(null, "From Kr to Yen it will be: " + krToYen);

    }

    public static void nokToDollar (double conversion3) {

        double krToDollar = conversion3*0.13;

        JOptionPane.showMessageDialog(null, "From Kr to Dollar it will be: " + krToDollar);

    }

    public static void yenToNok(double conversion4) {

        double yenToNok = conversion4*0.0712;

        JOptionPane.showMessageDialog(null, "From Yen to Nok it will be:  " + yenToNok);

    }

    public static void yenToEuro(double conversion5) {
        double yenToEuro = conversion5*0.0073;
        JOptionPane.showMessageDialog(null, "From Yen to Euro it will be: " + yenToEuro);

    }

    public static void yenToDollar(double conversion6) {
        double yenToDollar = conversion6 * 0.00904;
        JOptionPane.showMessageDialog(null, "From Yen to Dollar it will be: " + yenToDollar);
    }

    public static void dollarToNok (double conversion7) {

        double dollarToKr = conversion7*7.8795;

        JOptionPane.showMessageDialog(null, "From dollar to Nok it will be: " + dollarToKr);

    }

    public static void dollarToEuro (double conversion8) {

        double dollarToEuro = conversion8*0.81421;

        JOptionPane.showMessageDialog(null, "From dollar to Euro it will be: " + dollarToEuro);

    }

    public static void dollarToYen (double conversion9) {

        double dollarToYen = conversion9*110.619;

        JOptionPane.showMessageDialog(null, "From dollar to Yen it will be: " + dollarToYen);

    }

    public static void euroToNok (double conversion10) {

        double euroToNok = conversion10*9.677;

        JOptionPane.showMessageDialog(null, "From Euro to Nok it will be: " + euroToNok);

    }

    public static void euroToDollar (double conversion11) {

        double euroToDollar = conversion11*1.228;

        JOptionPane.showMessageDialog(null, "From Euro to Dollar it will be: " + euroToDollar);

    }

    public static void euroToYen (double conversion12) {

        double euroToYen = conversion12*135.8606;

        JOptionPane.showMessageDialog(null, "From Euro to Yen it will be: " + euroToYen);
    }
}
