package byui.cit260.potterheads.model;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aleecrook
 */
public class CharacterScene implements Serializable{
    private int numberOfCharacters;

    public CharacterScene() {
    }

    public int getNumberOfCharacters() {
        return numberOfCharacters;
    }

    public void setNumberOfCharacters(int numberOfCharacters) {
        this.numberOfCharacters = numberOfCharacters;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.numberOfCharacters;
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
        final CharacterScene other = (CharacterScene) obj;
        if (this.numberOfCharacters != other.numberOfCharacters) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CharacterScene{" + "numberOfCharacters=" + numberOfCharacters + '}';
    }
}
