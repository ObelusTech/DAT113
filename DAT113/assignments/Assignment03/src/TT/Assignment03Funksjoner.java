package TT;

import javax.swing.*;
import java.lang.reflect.Array;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Assignment03Funksjoner {

    public static void ValidNumbers(String[][] mainSolution){

        ArrayList<String> oneTonigh = new ArrayList<>();
        oneTonigh.add("1"); oneTonigh.add("2"); oneTonigh.add("3"); oneTonigh.add("4");
        oneTonigh.add("5"); oneTonigh.add("6"); oneTonigh.add("7"); oneTonigh.add("8");
        oneTonigh.add("9");

        Collections.shuffle(oneTonigh);
        String[][] Groups = new String[3][9];

        for (int i = 0; i < 9; i++){
            Groups[0][i]= oneTonigh.get(i);
            System.out.println(Groups[0][i]);
        }

        //Copy the first group to the second group
        Groups[1][0]=Groups[0][2]; Groups[1][1]=Groups[0][0]; Groups[1][2]=Groups[0][1]; Groups[1][3]=Groups[0][5];
        Groups[1][4]=Groups[0][3]; Groups[1][5]=Groups[0][4]; Groups[1][6]=Groups[0][7]; Groups[1][7]=Groups[0][8];
        Groups[1][8]=Groups[0][6];

        //Copy the second group to the third group
        Groups[2][0]=Groups[0][1]; Groups[2][1]=Groups[0][2]; Groups[2][2]=Groups[0][0]; Groups[2][3]=Groups[0][4];
        Groups[2][4]=Groups[0][5]; Groups[2][5]=Groups[0][3]; Groups[2][6]=Groups[0][8]; Groups[2][7]=Groups[0][6];
        Groups[2][8]=Groups[0][7];

        for (int i = 0; i < 9; i++) {

            mainSolution[0][i] = Groups[0][i];
            mainSolution[3][i] = Groups[1][i];
            mainSolution[6][i] = Groups[2][i];

        }

        for (int i = 0; i < 3 ; i++) {
            mainSolution[1][i]=Groups[0][i+3];
            mainSolution[1][i+3]=Groups[0][i+6];
            mainSolution[1][i+6]=Groups[0][i];

            mainSolution[2][i]=Groups[0][i+6];
            mainSolution[2][i+3]=Groups[0][i];
            mainSolution[2][i+6]=Groups[0][i+3];

            mainSolution[4][i]=Groups[1][i+3];
            mainSolution[4][i+3]=Groups[1][i+6];
            mainSolution[4][i+6]=Groups[1][i];

            mainSolution[5][i]=Groups[1][i+6];
            mainSolution[5][i+3]=Groups[1][i];
            mainSolution[5][i+6]=Groups[1][i+3];


            mainSolution[7][i]=Groups[2][i+3];
            mainSolution[7][i+3]=Groups[2][i+6];
            mainSolution[7][i+6]=Groups[2][i];

            mainSolution[8][i]=Groups[2][i+6];
            mainSolution[8][i+3]=Groups[2][i];
            mainSolution[8][i+6]=Groups[2][i+3];

        }

    }



    public static void giveSomeNull(int[][] nullArray){
        for (int i = 0; i <= 81; i++) {
            int give =  (int) (Math.random()*2);
            nullArray[i][i] = give;
        }
    }

    public static void easyGame(String[][] mainSolution, int[][] nullArray){



        for (int i = 0; i <9; i++) {
            for (int j = 0; j < 9; j++) {

                if(nullArray[i][j]==0)
                    mainSolution[i][j]="";

            }
        }
    }

    public static void hardGame(String[][] mainSolution, int[][] nullsArray) {

        Random randomNumber = new Random();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                int theNumber = randomNumber.nextInt(2)+1;

                nullsArray[i][j] = theNumber;

            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if ( nullsArray[i][j] == 1)
                    mainSolution[i][j] = "";

            }
        }
    }

}
