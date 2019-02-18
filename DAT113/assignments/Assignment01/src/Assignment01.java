import jdk.nashorn.internal.scripts.JO;
import javax.swing.JOptionPane;

public class Assignment01 {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to the numbers game!");

        String a
                = JOptionPane.showInputDialog(null, "Guess the number!");

        double x = System.currentTimeMillis();

        JOptionPane.showMessageDialog(null, "You wrote " + a);

        int nyTall = Integer.parseInt(a);

        int tall = (int) (Math.random() * 100);

        int count = 1;

        while (nyTall != tall){

            if ( nyTall < tall)
                JOptionPane.showMessageDialog(null, "The number is higher.");
            else if (nyTall > tall)
                JOptionPane.showMessageDialog(null, "The number is lower.");

            count++;

            a = JOptionPane.showInputDialog(null, "Guess again");
            nyTall = Integer.parseInt(a);
        }
        String[] buttons = {"Yes", "No"};

        double y = System.currentTimeMillis();
        int tid = (int)(y-x)/1000;

        int gameBox =
                JOptionPane.showOptionDialog(null, "You have guessed right!\nThe right answer is " + tall +
                                ".\nYou tried " + count + " times." + "\nYou used " + tid + " seconds.\n" + "Would you like to try again?", "Number Guessing Game",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, buttons, buttons[0]);

        System.out.println(gameBox);

        if (gameBox == JOptionPane.YES_OPTION){
            reStart();
        }
        else if (gameBox == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }
    private static void reStart() { // Her har jeg restartet hele mainen.
        String reRun[] = {};
        main(reRun);
    }
}