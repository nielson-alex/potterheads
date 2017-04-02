/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.control.GameControl;
import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.InventoryItem;
import byui.cit260.potterheads.model.Player;
import byui.cit260.potterheads.model.Spell;
import byui.cit260.potterheads.model.Spell.SpellType;
import java.io.PrintWriter;
import java.util.ArrayList;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
public class HagridsHouseView extends View {
    protected final PrintWriter console = Potterheads.getOutFile();

    public HagridsHouseView() {
        super("\nDo you want to accept Hagrid's gift?"
                + "(press 'Y' for yes, 'N' for no");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        
        boolean done = false;
        
        while(!done) {
            if ("Y".equals(value.toUpperCase())) {
                potterheads.Potterheads.getPlayer().setMoney(500);
                
                this.console.println("\n'Five hunnerd dollars is a lot, I hear. But\n"
                        + "don't ya worry, I dun't got much need for money and it's not\n"
                        + "worth the effort of taking it down the bank. Go ahead, it's\n"
                        + "yers!");
                return true;
            } else if ("N".equals(value.toUpperCase())) {
                return true;
            }
        }
        
//        switch (value) {
//            case "E":
//                ArrayList<Spell> spellInventory = potterheads.Potterheads.getPlayer().getSpells();
//                Spell expelliarmus = new Spell(Spell.SpellType.expelliarmus);
//
//                if (!((Potterheads.getCurrentGame().getSpellInventory().contains(expelliarmus)))) {
//                    spellInventory.add(expelliarmus);
//                    this.showAcquiredSpell();
//                } else {
//                    this.console.println("\nHagrid says, 'What're ya tryin' ta\n"
//                            + "pull here? Ya've already learned this spell!");
//                }
//                break;
//            case "S":
//                Spell stupify = new Spell(SpellType.stupify);
//                if (!(Potterheads.getPlayer().getSpells()).contains(stupify)) {
//                    Potterheads.getPlayer().getSpells().add(stupify);
//                    this.showAcquiredSpell();
//                } else {
//                    this.console.println("\nHagrid says, 'What're ya tryin' ta\n"
//                            + "pull here? Ya've already learned this spell!");
//                }
//                break;
//            case "Q":
//                return true;
//            default:
//                ErrorView.display(this.getClass().getName(), "Invalid selection. Press either 'E' or 'S'.");
//                break;
//        }
        return true;
    }

    public void showAcquiredSpell() {
        this.console.println("\n'Great job!' Hagrid congratulates you. 'That spell\n"
                + "should be added to ya inventory now. Let's see.");
        
        StringBuilder line;

        Game game = Potterheads.getCurrentGame();
//        InventoryItem[] inventory = game.getInventory();

        ArrayList<Spell> inventory = game.getSpellInventory();
        
        this.console.println("\n          List of Spells Learned");
        line = new StringBuilder("                                                              ");
        line.insert(0, "NAME");
        line.insert(25, "EFFECT");
        this.console.println(line.toString());

        //for each inventory item
        for (Spell spellInventory : inventory) {
            line = new StringBuilder("                                                  ");
            line.insert(0, spellInventory.getName());
            line.insert(25, spellInventory.getEffect());

            //Display the line
            this.console.println(line.toString() + "\n\n");
        }
        return;
    }
}
