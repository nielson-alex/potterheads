package byui.cit260.potterheads.model;

import java.io.Serializable;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aleecrook
 */
public class Scene implements Serializable {

    private boolean blocked;
    private String description;
    private String mapSymbol;

    public enum SceneType {
    /*01*/  start, //Hogwarts Great Hall
            unknown,
            puzzle,
            character,
            item,
    /*02*/  dumbledoresOffice,
    /*03*/  knockTurnAlley,
    /*04*/  hagridsHouse,
    /*05*/  libraryScene,
    /*06*/  quidditchPitch,  
    /*07*/  leakyCauldron,
    /*08*/  ollivanders,  
    /*09*/  darkArtsClassroom,
    /*10*/  forestScene,
    /*11*/  flourishAndBlotts,
    /*12*/  polyjuice,
    /*13*/  diagonAlley,
    /*14*/  gringottsBank,
    /*15*/  darkDungeon,
    /*16*/  finish;
    /*17*/
    /*18*/  
    /*19*/  
    /*20*/
    /*21*/  
    /*22*/
    /*23*/  
    /*24*/
    /*25*/  
    }

    //constructor function
    public Scene() {
    }

    //getters and setters
    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

    //equals and hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.blocked ? 1 : 0);
        hash = 19 * hash + Objects.hashCode(this.description);
        hash = 19 * hash + Objects.hashCode(this.mapSymbol);
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
        final Scene other = (Scene) obj;
        if (this.blocked != other.blocked) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.mapSymbol, other.mapSymbol)) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "Scene{" + "blocked=" + blocked + ", description=" + description + ", mapSymbol=" + mapSymbol + '}';
    }

}
