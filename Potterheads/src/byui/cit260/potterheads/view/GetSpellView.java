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
public class GetSpellView extends View {
    protected final PrintWriter console = Potterheads.getOutFile();

    public GetSpellView() {
        super("\nPress 'E' to add Expelliarmus or 'S' for Stupify");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();

        if ("E".equals(value.toUpperCase())) {
            Spell spell = new Spell(SpellType.expelliarmus);
            Potterheads.getPlayer().getSpells().add(spell);
        } else if ("S".equals(value.toUpperCase())) {
            Spell spell = new Spell(SpellType.stupify);
            Potterheads.getPlayer().getSpells().add(spell);
        }
        return true;
    }
}
