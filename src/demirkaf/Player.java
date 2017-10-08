package demirkaf;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/*
Name: F. Fulya Demirkan
File: Player.java
Other Files in this Project: 
- Rps.java
- FXMLRpsController.java
- FXMLRps.fxml
- main.css

Main class: A4_demirkaf
 */
/**
 * Player class represents a single Rock-Paper-Scissors game player. Each player
 * has Rps enum (player token) and score parameters.
 *
 * @author Fulya Demirkan
 */
public class Player
{

    /**
     * Player token enum for this player.
     */
    public Rps move;

    /**
     * Score property for this player.
     */
    private IntegerProperty score = new SimpleIntegerProperty();

    /**
     * Constructs a default player.
     *
     */
    public Player()
    {

    }

    /**
     * Places a valid value for score property. The score property value must be
     * equal or greater than zero, otherwise an exception is thrown.
     *
     * @param score score property of this player.
     * @throws IllegalArgumentException if score value is less than zero.
     */
    public void setScore(int score)
    {
        if (score >= 0)
        {
            this.score.set(score);
        } else
        {
            throw new IllegalArgumentException("Score must be equal or greater"
                    + " than 0.");
        }
    }

    /**
     * Returns int value of score property of this player.
     *
     * @return int value of score property of this player.
     */
    public int getScore()
    {
        return score.getValue();
    }

    /**
     * Increments and sets score property by one after each win of this player.
     */
    public void incrementScore()
    {
        score.set(score.getValue() + 1);
    }

    /**
     * Returns score property of this player.
     *
     * @return score property of this player.
     */
    public IntegerProperty scoreProperty()
    {
        return score;
    }

    /**
     * Sets the move member to the Rps enum corresponding to the String
     * parameter.
     *
     * @param move Player token enum for this player.
     */
    public void makeMove(String move)
    {
        this.move = Rps.valueOf(move.toUpperCase());
    }

    /**
     * Generates a random token (Rps enum) for computer.
     *
     * @return a randomly generated token (Rps enum) for computer.
     */
    public Rps makeRandomMove()
    {
        String token[] =
        {
            "ROCK", "PAPER", "SCISSORS"
        };

        String randToken = token[(int) (Math.random() * 3)];
        Rps compPlay = Rps.valueOf(randToken);

        return compPlay;
    }

    /**
     * Returns the String name of player's current move.
     *
     * @return the String name of player's current move.
     */
    public String toString()
    {
        return "Player Chooses: " + move;
    }
}
