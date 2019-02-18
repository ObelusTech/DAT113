import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIforTE extends JFrame{

    public JPanel panel = new JPanel(new BorderLayout());

    public JMenuBar menuBar = new JMenuBar();

    public JMenu menu = new JMenu("File");
    public JMenu menu2 = new JMenu("other");

    public JMenuItem menuItem2 = new JMenuItem("Save");
    public JMenuItem menuItem3 = new JMenuItem("Save as..");
    public JMenuItem menuItem4 = new JMenuItem("Open");
    public JMenuItem menuItem6 = new JMenuItem("Spell Check?");
    public JMenuItem menuitem7 = new JMenuItem("Change text color");
    public JMenuItem menuItem8 = new JMenuItem("Add a word to dictionary");

    public JScrollPane sb = new JScrollPane(Model.textPane);

    public Font mainFont = new Font("Times New Roman", Font.PLAIN , 14);

    public Border border = BorderFactory.createLineBorder(Color.WHITE, 15);

    public GUIforTE(Controller c){

        Model.textPane.setFont(mainFont);
        Model.textPane.setBorder(border);
        this.setSize(750, 750);
        this.setTitle("Textoz");
        this.setLocation(Model.xLocation, Model.yLocation);
        this.setJMenuBar(menuBar);

        menuBar.add(menu);
        menuBar.add(menu2);
        menu.add(menuItem4);    // Open
        menu.add(menuItem2);    // Save
        menu.add(menuItem3);    // Save as..
        menu.add(menuItem6);    // Spell Check
        menu2.add(menuitem7);   // change font color
        menu2.add(menuItem8);   // Add word to dictionary

        menuItem2.addActionListener(c);
        menuItem3.addActionListener(c);
        menuItem4.addActionListener(c);
        menuItem6.addActionListener(c);
        menuitem7.addActionListener(c);
        menuItem8.addActionListener(c);

        panel.add(getContentPane().add(sb)); // Legger til JTextArea med en scrollbar for lange dokumenter
        this.add(panel);

        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {

                String textPaneText = Model.textPane.getText();
                String comTextPaneText = Model.comTextPane.getText();


                if (!textPaneText.equals(comTextPaneText)) {
                    JOptionPane.showMessageDialog(null, "You have not saved you work, remember to save!");
                }

                else if (textPaneText.equals(comTextPaneText)) {
                    System.exit(0);
                }


            }
        });

        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);

    }
}
