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
    private double money;
    private double galleons;

    // constructor Function
    public Player() {
        this.name = name;
        this.spells = new ArrayList<>();
        this.inventoryItems = new ArrayList<>();
        coordinates = new Point(0, 0);
        this.money = 0;
        this.galleons = 0;
    }

    public void movePlayer(Point point) {
        this.coordinates = point;
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

    public Point getCoordinates() {
        return coordinates;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
    public double getGalleons() {
        return galleons;
    }

    public void setGalleons(double galleons) {
        this.galleons = galleons;
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
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.coordinates);
        hash = 29 * hash + Objects.hashCode(this.spells);
        hash = 29 * hash + Objects.hashCode(this.inventoryItems);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.money) ^ (Double.doubleToLongBits(this.money) >>> 32));
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
        if (Double.doubleToLongBits(this.money) != Double.doubleToLongBits(other.money)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.coordinates, other.coordinates)) {
            return false;
        }
        if (!Objects.equals(this.spells, other.spells)) {
            return false;
        }
        if (!Objects.equals(this.inventoryItems, other.inventoryItems)) {
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
