import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{

    GUIforTE GUI;
    Model myModel;

    Controller(){

        GUI = new GUIforTE(this);
        myModel = new Model();

    }

    public void actionPerformed(ActionEvent e) {

            if (e.getSource() == GUI.menuItem4) { // open a document

                if (myModel.fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    myModel.openFile(myModel.fileChooser.getSelectedFile().getAbsolutePath());
                    GUI.setTitle(myModel.fileChooser.getSelectedFile().getName());

                }
            }

            if (e.getSource() == GUI.menuItem3) { // Save a new made document

                if (myModel.fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    myModel.saveFile(myModel.fileChooser.getSelectedFile().getAbsolutePath());

                }
            }

            if (e.getSource() == GUI.menuItem2) { // lagre endringer

                myModel.saveFile(myModel.fileChooser.getSelectedFile().getAbsolutePath());
            }

            if (e.getSource() == GUI.menuItem6) { // spell check

                myModel.textTilArrayList();

            }

            if (e.getSource() == GUI.menuitem7) { // change the color of your text

                myModel.color();

            }

            if (e.getSource() == GUI.menuItem8) { // Add words to the dictionary

                myModel.writeToOL();

            }
        }
}
