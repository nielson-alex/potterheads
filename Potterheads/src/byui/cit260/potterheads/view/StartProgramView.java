/*
/* Welcome screen:
/*The end user enters the command to start the program/game. The computer displays the
/*banner screen including the title of the game. The computer also requests for the user to input
/*their desired name. The user enters their name and the computer displays a welcome message,
/*along with a brief description of the game and the Main Menu. An error message is displayed if
/*the user enters an invalid name or command.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.GameControl;
import byui.cit260.potterheads.model.Player;
import java.util.Scanner;

/**
 *
 * @author Alexandra
 */
public class StartProgramView {

    private String promptMessage;

    public StartProgramView() {
        this.promptMessage = "\nPlease enter your name:\n";
        // display the banner when view is created
        this.displayBanner();

    }

    private void displayBanner() {
        System.out.println(
                "\n_____________________________________________________________________________________________________________________________"
                + "\n   ,-.----.                                                                                                                 "
                + "\n  \\    /  \\                ___      ___                         ,---,                                                     "
                + "\n  |   :    \\             ,--.'|_  ,--.'|_                     ,--.' |                                ,---,                 "
                + "\n  |   |  .\\ :   ,---.    |  | :,' |  | :,'             __  ,-.|  |  :                              ,---.'|                 "
                + "\n  .   :  |: |  '   ,'\\   :  : ' : :  : ' :           ,' ,'/ /|:  :  :                              |   | :  .--.--.        "
                + "\n  |   |   \\ : /   /   |.;__,'  /.;__,'  /     ,---.  '  | |' |:  |  |,--.   ,---.     ,--.--.      |   | | /  /    '       "
                + "\n  |   : .   /.   ; ,. :|  |   | |  |   |     /     \\ |  |   ,'|  :  '   |  /     \\   /       \\   ,--.__| ||  :  /`./     "
                + "\n  ;   | |`-' '   | |: ::__,'| : :__,'| :    /    /  |'  :  /  |  |   /' : /    /  | .--.  .-. | /   ,'   ||  :  ;_          "
                + "\n  |   | ;    '   | .; :  '  : |__ '  : |__ .    ' / ||  | '   '  :  | | |.    ' / |  \\__\\/: . ..   '  /  | \\  \\    `.   "
                + "\n  :   ' |    |   :    |  |  | '.'||  | '.'|'   ;   /|;  : |   |  |  ' | :'   ;   /|  ,\" .--.; |'   ; |:  |  `----.   \\    "
                + "\n  :   : :     \\   \\  /   ;  :    ;;  :    ;'   |  / ||  , ;   |  :  :_:,''   |  / | /  /  ,.  ||   | '/  ' /  /`--'  /    "
                + "\n  |   | :      `----'    |  ,   / |  ,   / |   :    | ---'    |  | ,'    |   :    |;  :   .'   \\   :    :|'--'.     /      "
                + "\n  `---'.|                 ---`-'   ---`-'   \\   \\  /          `--''       \\   \\  / |  ,     .-./\\   \\  /    `--'---'  "
                + "\n    `---`                                    `----'                        `----'   `--`---'     `----'                     "
                + "\n_____________________________________________________________________________________________________________________________"
                + "\n"
                + "\n"
                + "\n                                               ***Welcome, Potterheads!***                                                  "
                + "\n                                       This text-based game takes players throughout"
                + "\n                                       the world of Harry Potter. Users will discover"
                + "\n                                       they’re a wizard/witch, obtain school supplies of"
                + "\n                                       their choice, attend school and learn spells, and"
                + "\n                                       use these spells to defend and assist themselves as"
                + "\n                                       they explore the world. As players learn and explore,"
                + "\n                                       they are awarded “House Points” which are spent on"
                + "\n                                       mulligans and various items."
                + "\n*****************************************************************************************************************************"
        );

    }

    public void displayStartProgramView() {

        boolean done = false; // set flag to not done
        do {
            //prompt for and get playersName
            String playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("Q")) // user wants to quit
            {
                return;
            }

            //do requested action and display next view
            done = this.doAction(playersName);

            //while the view is not done
        } while (!done);
    }

    private String getPlayersName() {
        Scanner keyboard = new Scanner(System.in); // get infile for keyboard 
        String value = ""; //value to be returned
        boolean valid = false; // initialize to not valid

        while (!valid) { // loop while an invalid value is entered
            System.out.println("\n" + this.promptMessage);

            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks

            if (value.length() < 1) { //value is blank
                System.out.println("\nInvalid value: value cannot be blank");
                continue;
            }

            break; // end the loop
        }

        return value;
        // return the value entered
    }

    private boolean doAction(String playersName) {
        if (playersName.length() < 2) {
            System.out.println("\nInvalid player name: "
                    + "The name must be greater than one character in length.");
            return false;
        }

        // call createPlayer() control function
//        player is a class instance of the Player class. player is then passed
//        through the "displayNextView" function as a parameter that was 
//        referenced.
        Player player = GameControl.createPlayer(playersName);

        if (player == null) { // if unsuccessful
            System.out.println("\nError creating player.");
            return false;
        }

        // display next view
        this.displayNextView(player);
        return true;
    }

    private void displayNextView(Player player) {
        System.out.println("\nWelcome to the Game " + player.getName());

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();

    }
}
