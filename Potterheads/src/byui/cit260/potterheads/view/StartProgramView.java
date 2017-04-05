package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.GameControl;
import byui.cit260.potterheads.model.Player;
import java.io.PrintWriter;
import potterheads.Potterheads;

/**
 *
 * @author Alexandra
 */
public class StartProgramView extends View {

    protected final PrintWriter console = Potterheads.getOutFile();

    public StartProgramView() {
        super("\n_____________________________________________________________________________________________________________________________ \n"
                + "   ,-.----.                                                                                                                  \n"
                + "  \\    /  \\                ___      ___                         ,---,                                                      \n"
                + "  |   :    \\             ,--.'|_  ,--.'|_                     ,--.' |                                ,---,                  \n"
                + "  |   |  .\\ :   ,---.    |  | :,' |  | :,'             __  ,-.|  |  :                              ,---.'|                  \n"
                + "  .   :  |: |  '   ,'\\   :  : ' : :  : ' :           ,' ,'/ /|:  :  :                              |   | :  .--.--.         \n"
                + "  |   |   \\ : /   /   |.;__,'  /.;__,'  /     ,---.  '  | |' |:  |  |,--.   ,---.     ,--.--.      |   | | /  /    '        \n"
                + "  |   : .   /.   ; ,. :|  |   | |  |   |     /     \\ |  |   ,'|  :  '   |  /     \\   /       \\   ,--.__| ||  :  /`./      \n"
                + "  ;   | |`-' '   | |: ::__,'| : :__,'| :    /    /  |'  :  /  |  |   /' : /    /  | .--.  .-. | /   ,'   ||  :  ;_           \n"
                + "  |   | ;    '   | .; :  '  : |__ '  : |__ .    ' / ||  | '   '  :  | | |.    ' / |  \\__\\/: . ..   '  /  | \\  \\    `.    \n"
                + "  :   ' |    |   :    |  |  | '.'||  | '.'|'   ;   /|;  : |   |  |  ' | :'   ;   /|  ,\" .--.; |'   ; |:  |  `----.   \\     \n"
                + "  :   : :     \\   \\  /   ;  :    ;;  :    ;'   |  / ||  , ;   |  :  :_:,''   |  / | /  /  ,.  ||   | '/  ' /  /`--'  /     \n"
                + "  |   | :      `----'    |  ,   / |  ,   / |   :    | ---'    |  | ,'    |   :    |;  :   .'   \\   :    :|'--'.     /       \n"
                + "  `---'.|                 ---`-'   ---`-'   \\   \\  /          `--''       \\   \\  / |  ,     .-./\\   \\  /    `--'---'   \n"
                + "    `---`                                    `----'                        `----'   `--`---'     `----'                      \n"
                + "_____________________________________________________________________________________________________________________________\n"
                + "                                                                                                                              \n"
                + "                                                                                                                             \n"
                + "                                               ***Welcome, Potterheads!***                                                   \n"
                + "                                       This text-based game takes players throughout                                         \n"
                + "                                       the world of Harry Potter. Users will discover                                        \n"
                + "                                       they’re a wizard/witch, obtain school supplies of                                     \n"
                + "                                       their choice, attend school and learn spells, and                                     \n"
                + "                                       use these spells to defend and assist themselves as                                   \n"
                + "                                       they explore the world. As players learn and explore,                                 \n"
                + "                                       they are awarded “House Points” which are spent on                                     \n"
                + "                                       mulligans and various items.                                                          \n"
                + "*****************************************************************************************************************************\n\n"
                + "Please enter your name:"
        );
    }

    @Override
    public boolean doAction(String value) {
        if (value.length() < 3) {
            ErrorView.display(this.getClass().getName(), "Your name has to be at least 3 character long.");
            return false;
        }

        Player player = GameControl.createPlayer(value);

        if (player == null) { // if unsuccessful
            this.console.println("\nError creating player.");
            return false;
        }

        // display next view
        this.displayNextView(player);
        return true;
    }

    private void displayNextView(Player player) {
        this.console.println("\nWelcome to the Game " + player.getName());

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
    }
}
