/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Alexandra
 */
public class Game implements Serializable {

    //class instance variables
    private int numberOfPlayers;

    //Create cardinalities of One
    private Map map;
    private Player player;

    //Create cardinalities of many
    private ArrayList<InventoryItem> tradeableInventory = new ArrayList<>();
    private ArrayList<Spell> spellInventory = new ArrayList<>();
    private ArrayList<Scene> sceneType = new ArrayList<>();

    public Game() {
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
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

    public ArrayList<InventoryItem> getTradeableInventory() {
        return tradeableInventory;
    }

    public void setTradeableInventory(ArrayList<InventoryItem> tradeableInventory) {
        this.tradeableInventory = tradeableInventory;
    }

    public ArrayList<Spell> getSpellInventory() {
        return spellInventory;
    }

    public void setSpellInventory(ArrayList<Spell> spellInventory) {
        this.spellInventory = spellInventory;
    }

    public ArrayList<Scene> getSceneType() {
        return sceneType;
    }

    public void setSceneType(ArrayList<Scene> sceneType) {
        this.sceneType = sceneType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.numberOfPlayers;
        hash = 37 * hash + Objects.hashCode(this.map);
        hash = 37 * hash + Objects.hashCode(this.player);
        hash = 37 * hash + Objects.hashCode(this.tradeableInventory);
        hash = 37 * hash + Objects.hashCode(this.spellInventory);
        hash = 37 * hash + Objects.hashCode(this.sceneType);
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
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.tradeableInventory, other.tradeableInventory)) {
            return false;
        }
        if (!Objects.equals(this.spellInventory, other.spellInventory)) {
            return false;
        }
        if (!Objects.equals(this.sceneType, other.sceneType)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "numberOfPlayers=" + numberOfPlayers + ", map=" + map + ", player=" + player + ", tradeableInventory=" + tradeableInventory + ", spellInventory=" + spellInventory + ", sceneType=" + sceneType + '}';
    }

}
