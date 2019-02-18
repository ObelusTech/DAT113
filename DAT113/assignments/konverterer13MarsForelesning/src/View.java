import javax.swing.*;
import java.awt.*;

public class View extends JFrame {


    JButton knapp = new JButton("Hent data fra fil");
    JTextArea felt = new JTextArea();

    public View(Controller c){
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.add(knapp);
        this.add(felt);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        knapp.addActionListener(c);
    }

}
