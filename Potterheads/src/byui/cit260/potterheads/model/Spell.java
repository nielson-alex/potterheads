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
public class Spell {
    public String hint;

    //constructor function
    public Spell() {
    }

    
    
    //getter and setter
    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    
    
    //hashcode() and equals()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.hint);
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
        final Spell other = (Spell) obj;
        if (!Objects.equals(this.hint, other.hint)) {
            return false;
        }
        return true;
    }

    
    
    //toString()
    @Override
    public String toString() {
        return "Spell{" + "hint=" + hint + '}';
    }
}
