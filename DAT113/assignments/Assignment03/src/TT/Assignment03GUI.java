package TT;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;

class Assignment03GUI extends JFrame implements ActionListener {

    public static String[][] mainSolution = new String[9][9];

    public static JTextField field22[][] = new JTextField[9][9];

    int[][] nullArray = new int[9][9];
    int[][] nullsArray = new int[9][9];

    public static String[][] cloneOfMainSolution = new String[9][9];

    // Here is an example i am trying to use for copying the values in the elements of an array to another array.

    public void copyingArrays() {

        mainSolution = Arrays.copyOf(cloneOfMainSolution, cloneOfMainSolution.length);

    }

    int[][] easyGameArray = new int[9][9];

    public Font mainFont = new Font("Times New Roman", Font.BOLD, 28);
    public static final int GRID_SIZE = 9;
    public static final int BOX_SIZE = 2;

    public static JTextField[][] inputs = new JTextField[9][9];

    JFrame wholeBox = new JFrame("Sudoku");
    JFrame sideBox = new JFrame();

    Border lineBorder = new LineBorder(Color.GRAY, 4);

    JPanel hovedPanel = new JPanel(new GridLayout(3, 3));
    JPanel panel2 = new JPanel(new GridLayout(3, 3));

    JMenuBar menuBar = new JMenuBar();
    JMenu underMenuBar = new JMenu("Game");
    JMenu underMenuBar2 = new JMenu("Settings");
    JMenuItem easyGame = new JMenuItem("Easy Game");
    JMenuItem medium_game = new JMenuItem("Medium Game");
    JMenuItem hardGame = new JMenuItem("Hard Game");
    JMenuItem checkForValid = new JMenuItem("Check Validation");
    JMenuItem getZeroes = new JMenuItem("Start the game");
    JMenuItem ExitGame = new JMenuItem("Exit");

    public Assignment03GUI() {

        wholeBox.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        wholeBox.setLocation(300, 100);
        wholeBox.setSize(640, 640);

        for (int x = 0; x < GRID_SIZE; x++) {

            hovedPanel = new JPanel(new GridLayout(3, 3));
            hovedPanel.setBorder(lineBorder);
            hovedPanel.setBackground(Color.BLACK);

            for (int y = 0; y < GRID_SIZE; y++) {

                JTextField f = new JTextField(1);
                PlainDocument doc = (PlainDocument) f.getDocument();
                doc.setDocumentFilter(new InputFilter(f));
                inputs[x][y] = f;
                hovedPanel.add(f);
                f.setHorizontalAlignment(JTextField.CENTER);
            }
            for (int z = 0; z < GRID_SIZE; z++) {
                panel2.add(hovedPanel);
            }
        }

        for (int j = 0; j < GRID_SIZE; j++) {
            panel2.add(hovedPanel);
        }

        wholeBox.add(panel2);

        wholeBox.setJMenuBar(menuBar);

        menuBar.add(underMenuBar);
        menuBar.add(underMenuBar2);

        underMenuBar.add(easyGame);
        underMenuBar.add(medium_game);
        underMenuBar.add(hardGame);

        underMenuBar2.add(checkForValid);
        underMenuBar2.add(ExitGame);



        easyGame.addActionListener(this::menuBarActions);
        medium_game.addActionListener(this::menuBarActions);
        hardGame.addActionListener(this::menuBarActions);

        checkForValid.addActionListener(this::menuBarActions);

        ExitGame.addActionListener(e -> System.exit(0));
        wholeBox.setVisible(true);

        // Get Random number from function "Random"
        // Random number = new Random();
        // int tall = number.nextInt(2);
    }

    public void fillingBoard() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                cloneOfMainSolution[i][j] = mainSolution[i][j];
                System.out.println(cloneOfMainSolution[i][j]);


            }
        }

    }

    public void getZeroesInBoxes() {



        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field22[i][j] = inputs[i][j];
                field22[i][j].setFont(mainFont);
                inputs[i][j].setFont(mainFont);


                if (easyGameArray[i][j] == 1) {
                    mainSolution[i][j] = String.valueOf(mainSolution[i][j]);
                    inputs[i][j].setText(mainSolution[i][j]);
                    inputs[i][j].setEditable(false);
                }
                else {
                    mainSolution[i][j] = null;
                    inputs[i][j].setText(null);

                }


            }
        }
    }


    public void checkingForValidation () {

        for (int bigBox = 0; bigBox < 9; bigBox++) {
            for (int littleBox = 0; littleBox < 9; littleBox++) {
                String valuesFromField22 = inputs[bigBox][littleBox].getText();

                System.out.println("Val:" + valuesFromField22+ " : Cor: " + cloneOfMainSolution[bigBox][littleBox]);
                if (valuesFromField22.length() == 1 && !valuesFromField22.equals(cloneOfMainSolution[bigBox][littleBox])) {
                    JOptionPane.showMessageDialog(null, "The Value you typed is wrong. Big Box " + bigBox + " and Little box " + littleBox);
                }
            }
        }
    }

    public void EasyGameSTART() {

        Assignment03Funksjoner.ValidNumbers(mainSolution);
        fillingBoard();

        //Assignment03Funksjoner.giveSomeNull(nullArray);
        //Assignment03Funksjoner.easyGame(mainSolution,nullArray);

        Random RandomNumber = new Random();


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                int theNumber = RandomNumber.nextInt(2) + 1;

                easyGameArray[i][j] = theNumber;


            }
        }

        getZeroesInBoxes();
    }

    public void mediumGameSTART() {

        Assignment03Funksjoner.ValidNumbers(mainSolution);
        fillingBoard();

        //Assignment03Funksjoner.giveSomeNull(nullArray);
        //Assignment03Funksjoner.easyGame(mainSolution,nullArray);

        Random RandomNumber = new Random();


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                int theNumber = RandomNumber.nextInt(3) + 1;

                easyGameArray[i][j] = theNumber;


            }
        }

        getZeroesInBoxes();
    }

    public void hardGamesSTART() {

        Assignment03Funksjoner.ValidNumbers(mainSolution);
        fillingBoard();

        //Assignment03Funksjoner.giveSomeNull(nullArray);
        //Assignment03Funksjoner.easyGame(mainSolution,nullArray);

        Random RandomNumber = new Random();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                int theNumber = RandomNumber.nextInt(5) + 1;

                easyGameArray[i][j] = theNumber;

            }
        }
        getZeroesInBoxes();
    }



    public void menuBarActions(ActionEvent e) {
        if (e.getSource() instanceof JMenuItem) {
            JMenuItem menuBarPressed = (JMenuItem) e.getSource();
            switch (menuBarPressed.getText()) {
                case "Easy Game":

                    fillingBoard();
                    EasyGameSTART();

                    break;

                case "Medium Game":

                    fillingBoard();
                    mediumGameSTART();

                    break;

                case "Hard Game":

                    fillingBoard();
                    hardGamesSTART();

                    break;

                case "Start the game":

                    break;

                case "Check Validation":

                    checkingForValidation();

                    break;

                case "Exit":

                    System.exit(0);


                    break;

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
