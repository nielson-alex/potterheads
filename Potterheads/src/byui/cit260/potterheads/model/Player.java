/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author alex
 */
public class Player implements Serializable {

    private String name;
    private Point coordinates;
    public ArrayList<Spell> spells;
    private ArrayList<InventoryItem> inventoryItems;

    // constructor Function
    public Player() {
        this.name = name;
        this.spells = new ArrayList<>();
        this.inventoryItems = new ArrayList<>();
        coordinates = new Point(1, 1);
    }

    // Getter and setter functions
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Spell> getSpells() {
        return this.spells;
    }

    public ArrayList<InventoryItem> getInventoryItems() {
        return this.inventoryItems;
    }

    public boolean hasLearnedSpell(Spell.SpellType spellType) {
        for (Spell spell : this.spells) {
            if (spell.getType() == spellType) {
                return true;
            }
        }
        return false;
    }

    public boolean hasLearnedSpell(String userInput) {
        if (userInput.equals("Expelliarmus")) {
            return hasLearnedSpell(Spell.SpellType.expelliarmus);
        }
        if (userInput.equals("Stupify")) {
            return hasLearnedSpell(Spell.SpellType.stupify);
        }
        if (userInput.equals("petrificusTotalus")) {
            return hasLearnedSpell(Spell.SpellType.petrificusTotalus);
        }
//        ...

        return false;
    }

    // equals() and hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    // toString();
    @Override
    public String toString() {
        return "Player{" + "name=" + name + '}';
    }
}
