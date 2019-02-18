import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Assignment02 {

    public static void main(String[] args) {

        String[] buttonNames = {"Norwegian Kroner", "Dollar", "Euro", "Yen"};

        JFrame slideFrame = new JFrame("First Valuta");

        double nyTall = 0;
        String valutaCon =
                (String) JOptionPane.showInputDialog(slideFrame, "Choose first valuta", "Valuta", JOptionPane.QUESTION_MESSAGE, null, buttonNames, buttonNames[0]);

        while(nyTall==0) {
            try {
            nyTall = Double.parseDouble(JOptionPane.showInputDialog("Amount: "));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "That character is invalid, type in a number!");
        }
        }
        System.out.println(nyTall);

        JOptionPane.showMessageDialog(null, "You typed in " + nyTall);

        if (valutaCon == buttonNames[0]) {
            String valutaConv =
                    (String)JOptionPane.showInputDialog(slideFrame, "What would you like to convert to?", "Valuta", JOptionPane.QUESTION_MESSAGE, null, buttonNames, buttonNames[0]);
            if (valutaConv == buttonNames[1]) {
                runnerClass.nokToDollar(nyTall);
            }
            else if (valutaConv == buttonNames[2]) {
                runnerClass.nokToEuro(nyTall);
            }
            else if (valutaConv == buttonNames[3]) {
                runnerClass.nokToYen(nyTall);
            }
            else {
                JOptionPane.showMessageDialog(null, "You can't convert to the same valuta, try again.");
                reStart();
            }
        }
        if (valutaCon == buttonNames[1]){
            String valutaConv2 =
                    (String)JOptionPane.showInputDialog(slideFrame, "What would you like to convert to?", "Valuta", JOptionPane.QUESTION_MESSAGE, null, buttonNames, buttonNames[0]);
            if (valutaConv2 == buttonNames[0]) {
                runnerClass.dollarToNok(nyTall);
            }
            else if (valutaConv2 == buttonNames[2]) {
                runnerClass.dollarToEuro(nyTall);
            }
            else if (valutaConv2 == buttonNames[3]) {
                runnerClass.dollarToYen(nyTall);
            }
            else {
                JOptionPane.showMessageDialog(null, "You can't convert to the same valuta, try again.");
                reStart();
            }
        }

        if (valutaCon == buttonNames[2]){
            String valutaConv3 =
                    (String)JOptionPane.showInputDialog(slideFrame, "What would you like to convert to?", "Valuta", JOptionPane.QUESTION_MESSAGE, null, buttonNames, buttonNames[0]);
            if (valutaConv3 == buttonNames[0]) {
                runnerClass.euroToNok(nyTall);
            }
            else if (valutaConv3 == buttonNames[1]) {
                runnerClass.euroToDollar(nyTall);
            }
            else if (valutaConv3 == buttonNames[3]) {
                runnerClass.euroToYen(nyTall);
            }
            else {
                JOptionPane.showMessageDialog(null, "You can't convert to the same valuta, try again.");
                reStart();
            }
        }

        if (valutaCon == buttonNames[3]){
            String valutaConv4 =
                    (String)JOptionPane.showInputDialog(slideFrame, "What would you like to convert to?", "Valuta", JOptionPane.QUESTION_MESSAGE, null, buttonNames, buttonNames[0]);
            if (valutaConv4 == buttonNames[0]) {
                runnerClass.yenToNok(nyTall);
            }
            else if (valutaConv4 == buttonNames[1]) {
                runnerClass.yenToDollar(nyTall);
            }
            else if (valutaConv4 == buttonNames[2]) {
                runnerClass.yenToEuro(nyTall);
            }
            else {
                JOptionPane.showMessageDialog(null, "You can't convert to the same valuta, try again.");
                reStart();
            }
        }
        String[] finalButtons = {"Yes", "No"};

        int finalBox =
                JOptionPane.showOptionDialog(null, "Thanks for using the app, would you like to try again?", "Valuta",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, finalButtons, finalButtons[0]);
        System.out.println(finalBox);

        if (finalBox == JOptionPane.YES_OPTION){
            reStart();
        }
        else if (finalBox == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }
    private static void reStart() {
        String reRun[] = {};
        main(reRun);
    }
}