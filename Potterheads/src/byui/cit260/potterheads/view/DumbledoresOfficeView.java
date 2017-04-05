/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.Player;
import byui.cit260.potterheads.model.Spell;
import byui.cit260.potterheads.model.Spell.SpellType;
import java.util.ArrayList;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
class DumbledoresOfficeView extends View {

    public DumbledoresOfficeView() {
        super("\nDumbledore hears you enter his office and looks up from his desk.\n"
                + "'Ah,' he says in his kind voice. 'You must be " + potterheads.Potterheads.getPlayer().getName() + "\n"
                + ". It's very nice to finally meet you. I understand you're\n"
                + "still fairly new to the wizarding world. Perhaps I can help\n"
                + "you. There are a few simple spells that I think I could\n"
                + "teach you, if you're interested. What do you say? Lumos, nox,\n"
                + "and expelliarmus are all simple spells and shouldn't take\n"
                + "more than a minute to teach you.'\n\n"
                + "What spell would you like to learn?\n"
                + "E - Expelliarmus\n"
                + "N - Nox\n"
                + "L - Lumos\n"
                + "Q - Quit");
    }

    @Override
    public boolean doAction(String value) {
        Player player = potterheads.Potterheads.getPlayer();
        value = value.toUpperCase();

        switch (value) {
            case "E":
                boolean hasExpelliarmus = false;

                for (Spell spell : player.getSpells()) {
                    if (spell.getType() == SpellType.expelliarmus) {
                        hasExpelliarmus = true;
                    }
                }

                if (hasExpelliarmus == true) {
                    this.console.println("\n'Oh, it seems you've already learned this one.'\n");
                } else {
                    this.console.println("\nDumbledore works with you for a few minutes.\n"
                            + "He teaches you the incantation and the movements of the wand.\n"
                            + "Before you know it, you've mastered the spell " + Spell.SpellType.expelliarmus.name() + "!\n"
                            + "'Congratulations!");
                    player.getSpells().add(new Spell(SpellType.expelliarmus));

                    StringBuilder line;

                    Game game = Potterheads.getCurrentGame();
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
                        this.console.println(line.toString());
                    }
                }
                return true;
            case "N":
                boolean iHaveNox = false;

                for (Spell spell : player.getSpells()) {
                    if (spell.getType() == SpellType.nox) {
                        iHaveNox = true;
                    }
                }

                if (iHaveNox == true) {
                    this.console.println("\n'Oh, it seems you've already learned this one.'\n");
                    return true;
                } else {
                    this.console.println("\nDumbledore works with you for a few minutes.\n"
                            + "He teaches you the incantation and the movements of the wand.\n"
                            + "Before you know it, you've mastered the spell " + Spell.SpellType.nox.name() + "!\n"
                            + "'Congratulations!");
                    player.getSpells().add(new Spell(SpellType.nox));

                    StringBuilder line;

                    Game game = Potterheads.getCurrentGame();
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
                        this.console.println(line.toString());
                    }
                }
                return true;
            case "L":
                boolean hasLumos = false;

                for (Spell spell : player.getSpells()) {
                    if (spell.getType() == Spell.SpellType.lumos) {
                        hasLumos = true;
                    }
                }

                if (hasLumos == true) {
                    this.console.println("\n'Oh, it seems you've already learned this one.'\n");
                    return true;
                } else {
                    this.console.println("\nDumbledore works with you for a few minutes.\n"
                            + "He teaches you the incantation and the movements of the wand.\n"
                            + "Before you know it, you've mastered the spell " + Spell.SpellType.lumos.name() + "!\n"
                            + "'Congratulations!");
                    player.getSpells().add(new Spell(SpellType.lumos));

                    StringBuilder line;

                    Game game = Potterheads.getCurrentGame();
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
                        this.console.println(line.toString());
                    }
                }
                return true;
            case "Q":
                return true;
        }
        return false;
    }
}
