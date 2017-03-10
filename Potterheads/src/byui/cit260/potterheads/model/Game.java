/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Alexandra
 */
public class Game implements Serializable {

    //class instance variables
    private int numberOfPlayers;
    private Item[] item;
    
    //Create cardinalities of One
    private DiagonAlley diagonAlley;
    private Polyjuice polyjuice;
    private Quidditch quidditch;
    private Map map;
    private Player player;

    
    
    //Create cardinalities of many
    //    private InventoryItems inventoryItems;
    private Character[] character;

    
    
    
    public Game() {
    }

    public double getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Item[] getItem() {
        return item;
    }

    public void setItem(Item[] item) {
        this.item = item;
    }

    public DiagonAlley getDiagonAlley() {
        return diagonAlley;
    }

    public void setDiagonAlley(DiagonAlley diagonAlley) {
        this.diagonAlley = diagonAlley;
    }

    public Polyjuice getPolyjuice() {
        return polyjuice;
    }

    public void setPolyjuice(Polyjuice polyjuice) {
        this.polyjuice = polyjuice;
    }

    public Quidditch getQuidditch() {
        return quidditch;
    }

    public void setQuidditch(Quidditch quidditch) {
        this.quidditch = quidditch;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Character[] getCharacter() {
        return character;
    }

    public void setCharacter(Character[] character) {
        this.character = character;
    }

    
    
    //hashcode() and equals()
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.numberOfPlayers;
        hash = 13 * hash + Arrays.deepHashCode(this.item);
        hash = 13 * hash + Objects.hashCode(this.diagonAlley);
        hash = 13 * hash + Objects.hashCode(this.polyjuice);
        hash = 13 * hash + Objects.hashCode(this.quidditch);
        hash = 13 * hash + Objects.hashCode(this.map);
        hash = 13 * hash + Objects.hashCode(this.player);
        hash = 13 * hash + Arrays.deepHashCode(this.character);
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
        final Game other = (Game) obj;
        if (this.numberOfPlayers != other.numberOfPlayers) {
            return false;
        }
        if (!Arrays.deepEquals(this.item, other.item)) {
            return false;
        }
        if (!Objects.equals(this.diagonAlley, other.diagonAlley)) {
            return false;
        }
        if (!Objects.equals(this.polyjuice, other.polyjuice)) {
            return false;
        }
        if (!Objects.equals(this.quidditch, other.quidditch)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Arrays.deepEquals(this.character, other.character)) {
            return false;
        }
        return true;
    }

    
    
    
    @Override
    public String toString() {
        return "Game{" + "numberOfPlayers=" + numberOfPlayers + ", item=" + item + ", diagonAlley=" + diagonAlley + ", polyjuice=" + polyjuice + ", quidditch=" + quidditch + ", map=" + map + ", player=" + player + ", character=" + character + '}';
    }
}
