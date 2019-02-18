import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    View mittview;
    Model minModel;
    public Controller() {

        SingletonPassord s = SingletonPassord.getInstance();
        String passord = JOptionPane.showInputDialog(null, "Skriv Passord");

        if (passord.equals(s.getPassord())) {


            this.mittview = new View(this);
            this.minModel = new Model();


        }
        else
            JOptionPane.showMessageDialog(null, "Feil Pas");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(mittview.knapp)) {
            String data = this.minModel.hentFilData();
            this.mittview.felt.setText(data);
        }

    }

    public static void main(String[] args) {
        new Controller();
    }
}

