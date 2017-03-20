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

    public enum SpellType {
        expelliarmus,
        stupify,
        sectumsempra,
        petrificusTotalus,
        wingardiumLeviosa;
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
        }
    }

//    public Spell(String name, String effect) {
//        this.name = name;
//        this.effect = effect;
//    }
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
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + Objects.hashCode(this.effect);
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
        return true;
    }

    @Override
    public String toString() {
        return "Spell{" + "name=" + name + ", effect=" + effect + '}';
    }
}
