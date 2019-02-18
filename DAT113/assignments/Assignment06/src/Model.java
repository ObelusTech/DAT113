import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {
    JFileChooser fileChooser = new JFileChooser();
    static int xLocation = 300, yLocation = 50;

    ArrayList<String> ordliste = new ArrayList<String>();

    Color color = Color.red;

    static DefaultStyledDocument document = new DefaultStyledDocument();
    static JTextPane textPane = new JTextPane(document);
    static JTextPane comTextPane = new JTextPane(document);


    String stringText;
    String[] wordsFromJP;
    String[] symbolsFromJP;



    Model() {
        OLtilArrayList();
    }

    public void openFile(String filename) {
        FileReader f;
        FileReader f2;
        try {
            f = new FileReader(filename);
            f2 = new FileReader(filename);
            textPane.read(f, null);
            comTextPane.read(f2, null);
            f.close();
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void saveFile(String filename) {

        String textFromTextpane = textPane.getText();
        comTextPane.setText(textFromTextpane);

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filename, false));
            textPane.write(bufferedWriter);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void OLtilArrayList() {

        try {
            Scanner s = new Scanner(new FileReader("ordliste.txt"));
            while (s.hasNext()) {
                ordliste.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void textTilArrayList() {


        StyleContext styleContext = new StyleContext();
        Style style = styleContext.addStyle("test", null);
        StyleConstants.setForeground(style, Color.RED);

        stringText = textPane.getText();
        wordsFromJP = stringText.split("[\\s\\W]+");
        symbolsFromJP = stringText.split("\\w");
        textPane.setText("");

        for (String aWordsFromJP : wordsFromJP) {

            if (ordliste.contains(aWordsFromJP.toLowerCase())) {

                appendToPane(textPane, aWordsFromJP + " ", Color.BLACK);

            } else if (!ordliste.contains(aWordsFromJP.toLowerCase())) {

                appendToPane(textPane, aWordsFromJP + " ", color);

            }
        }
    }

    private void appendToPane(JTextPane textPane, String stringText, Color color) { //inspirasjon fra Morten Goodwin
        StyleContext styleContext = StyleContext.getDefaultStyleContext();
        AttributeSet attr = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);

        int len = textPane.getDocument().getLength();
        textPane.setCaretPosition(len);
        textPane.setCharacterAttributes(attr, false);
        textPane.replaceSelection(stringText + "");
    }

    void color() {

        Color color = JColorChooser.showDialog(null, "Choose color", textPane.getForeground());
        if (color != null) {

            textPane.setForeground(color);

        }
    }

    void writeToOL() {

        try(FileWriter fw = new FileWriter("ordliste.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            String tekstTilOrdliste = JOptionPane.showInputDialog(null, "Add a word to the dictionary");
            out.println("\n"+tekstTilOrdliste);
        } catch (IOException e) {
        }
    }

}
