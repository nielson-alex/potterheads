/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Alexandra
 */
public class Game implements Serializable {

    //class instance variables
    private int numberOfPlayers;

    public Game() {
    }

    public double getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.numberOfPlayers) ^ (Double.doubleToLongBits(this.numberOfPlayers) >>> 32));
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
        if (Double.doubleToLongBits(this.numberOfPlayers) != Double.doubleToLongBits(other.numberOfPlayers)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "numberOfPlayers=" + numberOfPlayers + '}';
    }

}
