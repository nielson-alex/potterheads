package byui.cit260.potterheads.model;

import java.io.Serializable;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aleecrook
 */
public class CharacterScene implements Serializable {

    private Character[] characters;

    //constructor function
    public CharacterScene() {
    }

    //getter and setter
    public Character[] getCharacters() {
        return characters;
    }

    public void setCharacters(Character[] characters) {
        this.characters = characters;
    }

    //hashcode and equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Arrays.deepHashCode(this.characters);
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
        if (!Arrays.deepEquals(this.characters, other.characters)) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "CharacterScene{" + "characters=" + characters + '}';
    }
}
