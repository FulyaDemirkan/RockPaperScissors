package demirkaf;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

/*
Name: F. Fulya Demirkan
File: FXMLRpsController.java
Other Files in this Project: 
- Rps.java
- Player.java
- FXMLRps.fxml
- main.css

Main class: A4_demirkaf
 */
/**
 * FXMLRpsController manages the game play of Rock Paper Scissors game.
 *
 * @author Fulya Demirkan
 */
public class FXMLRpsController implements Initializable
{

    @FXML
    private Label lblwinner, lblPlayerScore, lblCompScore;

    @FXML
    private ImageView imgRock, imgPaper, imgScissors, imgComp;

    @FXML
    private FlowPane rockToken, paperToken, scissorsToken;

    @FXML
    private Player player = new Player();

    @FXML
    private Player computer = new Player();

    /**
     * When an image is clicked, sets move for player, changes the background
     * color of chosen token and initiates gamePlay method with passing move
     * parameter of player. Also changes the background color of each image to
     * the default color with each new click.
     *
     * @param event Mouse click event for images.
     */
    @FXML
    private void imgClicked(MouseEvent event)
    {
        //change bg-color to default with each click.
        rockToken.setStyle("-fx-background-color: #87ceeb;");
        paperToken.setStyle("-fx-background-color: #87ceeb;");
        scissorsToken.setStyle("-fx-background-color: #87ceeb;");

        //send token name to move parameter of player and change bg-color of 
        //image
        if (event.getSource() == imgRock)
        {
            rockToken.setStyle("-fx-background-color: orange;");
            player.makeMove("ROCK");
        } else if (event.getSource() == imgPaper)
        {
            paperToken.setStyle("-fx-background-color: orange;");
            player.makeMove("PAPER");
        } else if (event.getSource() == imgScissors)
        {
            scissorsToken.setStyle("-fx-background-color: orange;");
            player.makeMove("SCISSORS");
        }

        //generate a random computer move
        Rps compPlay = computer.makeRandomMove();

        //change computer token image with the randomly generated token's image
        Image img = new Image(getClass().getResource("res/" + 
                compPlay.getName() + ".png").toExternalForm());
        imgComp.setImage(img);

        //check if there is a tie or win. Increment player or computer score 
        //after every win
        if ((player.move).tie(compPlay))
        {
            lblwinner.setText("It's a tie!");

        } else if ((player.move).win(compPlay))
        {
            lblwinner.setText("Player Wins!");
            player.incrementScore();
        } else
        {
            lblwinner.setText("Computer Wins!");
            computer.incrementScore();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //Binds player and computer scores to appropriate labels.
        lblPlayerScore.textProperty().bind(player.scoreProperty().asString());
        lblCompScore.textProperty().bind(computer.scoreProperty().asString());
    }

    /**
     * Resets the game to default values and styles. Sets scores to zero, styles
     * to default bg-color, winner label to empty and computer token image to
     * question.
     */
    @FXML
    public void resetGame()
    {
        player.setScore(0);
        computer.setScore(0);
        rockToken.setStyle("-fx-background-color: #87ceeb;");
        paperToken.setStyle("-fx-background-color: #87ceeb;");
        scissorsToken.setStyle("-fx-background-color: #87ceeb;");
        lblwinner.setText("");
        Image img = new 
            Image(getClass().getResource("res/question.png").toExternalForm());
        imgComp.setImage(img);
    }

    /**
     * Exits the game.
     */
    public void exitGame()
    {
        System.exit(0);
    }
}
