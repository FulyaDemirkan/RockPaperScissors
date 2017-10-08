package demirkaf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Name: F. Fulya Demirkan
Assignment: Assignment 4
Program: Computer Programmer

This program is a Rock-Paper-Scissors game which can be played against computer.
Player can see or reset current play session's scores.
 */
/**
 * This program is a Rock-Paper-Scissors game which can be played against
 * computer. Player can see or reset current play session's scores.
 *
 * @author Fulya Demirkan
 */
public class A4_demirkaf extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRps.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Play Rock-Paper-Scissors");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);

    }

}
