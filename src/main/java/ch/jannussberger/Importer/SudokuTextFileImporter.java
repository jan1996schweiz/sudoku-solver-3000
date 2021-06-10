/**
 * This is my JavaFX class and is responsible to read in text files
 *
 *
 * @author Jan Nussberger
 * @version 1.0
 * @since 2021-06-10
 */

package ch.jannussberger.Importer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;

public class SudokuTextFileImporter {

    public static int[][] text() throws FileNotFoundException {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("ohh noo! something does not work as expected");
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Sudoku Text file");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));

        int result = fileChooser.showOpenDialog(null); //Opens File Chooser

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            Scanner scFile = null;
            try {
                scFile = new Scanner(new File(selectedFile.getAbsolutePath()));
                int[][] textFileArray = new int[9][9];
                for (int c = 0; c < 9; c++) {
                    for (int r = 0; r < 9; r++) {
                        textFileArray[c][r] = scFile.nextInt();
                    }
                }
                return textFileArray;
            } catch (IOException e) {
                System.out.println("Invalid File Selected");
            }
            scFile.close();
        } else {
            System.out.println("Invalid File Selected");
        }
        return new int[0][];
    }
}


































/*
    public ImportText() {
    }

    public static int[][] text() throws FileNotFoundException {

        Scanner sc = new Scanner(new BufferedReader(new FileReader("src/main/resources/sudoku.txt")));
        int[][] myArray = new int[9][9];
            for (int c = 0; c < myArray.length; c++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int r = 0; r < line.length; r++) {
                    myArray[c][r] = Integer.parseInt(line[r]);
                }

        }
        //System.out.println(Arrays.deepToString(myArray));
        return myArray;
    }
}
*/


    /*

    public int[][] text() throws FileNotFoundException {

        Scanner sc = new Scanner(new BufferedReader(new FileReader("src/main/resources/sudoku.txt")));
        int rows = 9;
        int columns = 9;
        int[][] myArray = new int[rows][columns];
        while (sc.hasNextLine()) {
            for (int c = 0; c < myArray.length; c++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int r = 0; r < line.length; r++) {
                    myArray[c][r] = Integer.parseInt(line[r]);
                }
            }
        }
        System.out.println(Arrays.deepToString(myArray));
        return myArray;
    }
    }
*/
/*
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src//main//resources//sudoku.txt");
        Scanner sc = new Scanner(file);
        int[][] sudo = new int[9][9];

        while (sc.hasNext()) {
            //read sudoku from text file into 9x9 array
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    sudo[i][j] = sc.nextInt();
                    //output the array
                    System.out.print(sudo[i][j] + " ");
                }
                //add new line at the end of each row
                System.out.println();
            }
        }
    }
*/