/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.util.Objects;

/**
 *
 * @author Alex
 */
public class TradeableItem {

    public String appealToCharacter;

    //constructor function
    public TradeableItem() {
    }

    //getter and setter
    public String getAppealToCharacter() {
        return appealToCharacter;
    }

    public void setAppealToCharacter(String appealToCharacter) {
        this.appealToCharacter = appealToCharacter;
    }

    //hashcode and equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.appealToCharacter);
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
        final TradeableItem other = (TradeableItem) obj;
        if (!Objects.equals(this.appealToCharacter, other.appealToCharacter)) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "TradeableItem{" + "appealToCharacter=" + appealToCharacter + '}';
    }
}
