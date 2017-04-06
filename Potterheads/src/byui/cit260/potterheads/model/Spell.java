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

    private String name;
    private String effect;
    private SpellType type;

    /*
    You use an enum when you want to specify a type of object. Here, the spells
    listed below are all objects of the Spell class with different types assigned
    to them
    */
    public enum SpellType {
        expelliarmus,
        stupify,
        sectumsempra,
        petrificusTotalus,
        wingardiumLeviosa,
        lumos,
        nox,
        avadaKedavra;
    }

    //constructor function
    public Spell() {
    }

    public Spell(SpellType spellType) {
        this.type = spellType;

        switch (spellType) {
            case expelliarmus:
                this.name = "Expelliarmus";
                this.effect = "Disarms the enemy";
                break;
            case stupify:
                this.name = "Stupify";
                this.effect = "Stuns the enemy";
                break;
            case petrificusTotalus:
                this.name = "petrificusTotalus";
                this.effect = "Slashes the enemy";
                break;
            case sectumsempra:
                this.name = "Sectumsempra";
                this.effect = "Does something";
                break;
            case wingardiumLeviosa:
                this.name = "Wingardium Leviosa";
                this.effect = "Makes objects float";
                break;
            case lumos:
                this.name = "Lumos";
                this.effect = "Turns on the lights";
                break;
            case nox:
                this.name = "Nox";
                this.effect = "Turns out the lights";
                break;
            case avadaKedavra:
                
                this.effect = "Kills a body";
                break;
        }
    }

    public Spell(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }
    
    public SpellType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.effect);
        hash = 67 * hash + Objects.hashCode(this.type);
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.effect, other.effect)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Spell{" + "name=" + name + ", effect=" + effect + '}';
    }
}
