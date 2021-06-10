/**
 * This is my JavaFX class and is responsible for the user interface
*
*
* @author Jan Nussberger
* @version 1.0
* @since 2021-06-10
*/

package ch.jannussberger.JavaFX;

import ch.jannussberger.Board.SudokuBoard;
import ch.jannussberger.Importer.SudokuTextFileImporter;
import ch.jannussberger.Solver.SudokuSolver;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class SudokuFxApp extends Application {

    TextField[][] textFields = new TextField[9][9];

    @Override
    public void start(Stage primaryStage) throws Exception {


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //Insert the the text fields into the grid
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                TextField t = new TextField();
                t.setAlignment((Pos.CENTER));
                textFields[c][r] = t;
                grid.add(t, c, r);
            }
        }

        /**
         * Clear button
         */
        Button btn = new Button("Clear");
        HBox hBox = new HBox(10);
        hBox.getChildren().add(btn);
        hBox.setAlignment(Pos.BOTTOM_LEFT);
        grid.add(hBox, 0, 9, 3, 1);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                        TextField t = new TextField();
                        t.setAlignment((Pos.CENTER));
                        textFields[c][r].setText("");
                        textFields[c][r].setStyle("-fx-background-color:rgb(255,255,255)");
                    }
                }
            }
        });

        /**
         * Load Text File button
         */
        btn = new Button(" Load Text File");
        hBox = new HBox(10);
        hBox.getChildren().add(btn);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        grid.add(hBox, 3, 9, 3, 1);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SudokuTextFileImporter importerTxt = new SudokuTextFileImporter();
                try {
                    int[][] newTextFileArray = importerTxt.text();
                    for (int r = 0; r < newTextFileArray.length; r++) {

                        for (int c = 0; c < newTextFileArray.length; c++) {
                            int number = (newTextFileArray[c][r]);
                            if (number != 0)
                                textFields[c][r].setText(String.valueOf(number));
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });

        /**
        *Solver button
        */
        btn = new Button("Solve");
        hBox = new HBox(10);
        hBox.getChildren().add(btn);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(hBox, 6, 9, 3, 1);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                SudokuSolver s = new SudokuSolver();
                SudokuBoard partial = new SudokuBoard();

                for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                        try {
                            Integer i = Integer.valueOf(textFields[c][r].getText().trim());
                            partial.set(c, r, i);
                        } catch (NumberFormatException e) {
                        }
                    }
                }

                SudokuBoard solution = s.solve(partial);

                for (int r = 0; r < 9; r++) {
                    for (int c = 0; c < 9; c++) {
                        if (textFields[c][r].getText().trim().equals("")) {
                            if (solution == null) {
                                textFields[c][r].setStyle("-fx-background-color:rgb(255,204,204)");
                            } else {
                                textFields[c][r].setStyle("-fx-background-color:rgb(204,255,204)");
                                textFields[c][r].setText("" + solution.get(c, r));
                            }
                        } else {
                            textFields[c][r].setStyle("-fx-background-color:rgb(255,255,255)");
                        }
                    }
                }
            }
        });

        primaryStage.setTitle("SudokuSolver3000");
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
