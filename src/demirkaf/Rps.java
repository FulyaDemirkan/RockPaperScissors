package demirkaf;

import java.util.HashMap;

/*
Name: F. Fulya Demirkan
File: Rps.java
Other Files in this Project: 
- Player.java
- FXMLRpsController.java
- FXMLRps.fxml
- main.css

Main class: A4_demirkaf
 */
/**
 * The Rps enum represents 3 game token and also contains String names of each
 * token and name of the tokens that wins over each main token.
 *
 * @author Fulya Demirkan
 */
public enum Rps
{
    ROCK("rock", "scissors"),
    PAPER("paper", "rock"),
    SCISSORS("scissors", "paper");

    private String name;
    private String winOver;
    private static HashMap<String, Rps> lookUpByName;

    /**
     * Private default constructor of Rps enum.
     *
     * @param name Game token's predefined name.
     * @param winOver Game token's predefined winning over token name.
     */
    private Rps(String name, String winOver)
    {
        this.name = name;
        this.winOver = winOver;
    }

    /**
     * Reverse Rps enum lookup according to the String name of enum.
     */
    private static void initNameLookUp()
    {
        lookUpByName = new HashMap<String, Rps>();

        for (Rps r : values())
        {
            lookUpByName.put(r.name, r);
        }
    }

    /**
     * Returns game token's predefined name.
     *
     * @return Game token's predefined name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns game token's predefined winning over token name.
     *
     * @return Game token's predefined winning over token name.
     */
    public String getWinOver()
    {
        return winOver;
    }

    /**
     * Returns any Rps enum with reverse lookup according to String name
     * parameter.
     *
     * @param name Game token's predefined name.
     * @return any Rps enum according to name parameter.
     * @throws IllegalArgumentException if Rps enum (game token) name is not
     * valid.
     */
    public Rps getRps(String name)
    {
        if (lookUpByName == null)
        {
            initNameLookUp();
        }
        Rps r = lookUpByName.get(name);

        if (r == null)
        {
            throw new IllegalArgumentException("Invalid token name");
        }
        return r;
    }

    /**
     * Checks if game is tie with comparing two Rps enums (token chosen by
     * player and randomly generated token for computer)
     *
     * @param other Computer's randomly generated Rps enum.
     * @return true if enum are equal, otherwise returns false.
     */
    public boolean tie(Rps other)
    {
        return (this.getRps(name) == other) ? true : false;
    }

    /**
     * Checks if game is win with comparing two Rps enums (winning over token of
     * the token chosen by player and randomly generated token for computer)
     *
     * @param other Computer's randomly generated Rps enum.
     * @return true if winning over Rps enum for player and computer Rps enum
     * are equal, otherwise returns false..
     */
    public boolean win(Rps other)
    {
        return (this.getRps(getWinOver()) == other) ? true : false;
    }
}
