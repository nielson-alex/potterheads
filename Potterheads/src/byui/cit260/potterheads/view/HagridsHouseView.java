/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Player;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
public class HagridsHouseView extends View {

    protected final PrintWriter console = Potterheads.getOutFile();

    public HagridsHouseView() {
        super("\nDo you want to accept Hagrid's gift?\n"
                + "(press 'Y' for yes, 'N' for no");
    }

    @Override
    public boolean doAction(String value) {
        /*
        The player is a static variable. There is only player in each game and it
        wouldn't make sense to create new instances of the player because there are
        parts of the game that need to access specific attributes or variables that
        are part of the variable class. For example, in one part of the game, you 
        can receive money from Hagrid and then go to the bank to conver the money 
        into Harry Potter currency, which you can then take to the store to purchase
        items.
        
        (go to line 50)
        */

        
        Player player = potterheads.Potterheads.getPlayer();
        value = value.toUpperCase();

        boolean done = false;

        while (!done) {

            if ("Y".equals(value.toUpperCase())) {
                if (!player.isHasReceivedMoney()) {
                    /*
                    It's necessary to reference the static player class because if we were to
                    create a new instance of the player to add $500, then we would
                    have a player instance with no money and a player instance with
                    $500.
                    */
                    potterheads.Potterheads.getPlayer().setMoney(500);

                    this.console.println("\n'Five hunnerd dollars is a lot, I hear. But\n"
                            + "don't ya worry, I dun't got much need for money and it's not\n"
                            + "worth the effort of taking it down the bank. Go ahead, it's\n"
                            + "yers!");

                    DecimalFormat df = new DecimalFormat("#.00");

                    double money = player.getMoney();
                    double galleons = player.getGalleons();
                    player.setHasReceivedMoney(true);

                    this.console.println("\nYou have $" + df.format(money) + " dollars.\n"
                            + "and ʛ" + df.format(galleons) + " galleons.");

                    return true;
                } else {
                    this.console.println("\nYou dirty mooch, you've already taken\n"
                            + "Hagrid's money.");
                    return true;
                }
            } else if ("N".equals(value.toUpperCase())) {
                return true;
            }
        }
        return true;
    }
}
