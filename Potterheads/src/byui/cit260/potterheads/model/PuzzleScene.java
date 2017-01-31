/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.io.Serializable;

/**
 *
 * @author alex
 */
public class PuzzleScene implements Serializable {
    private int numberOfObstancles;
    
    // constructor function
    public PuzzleScene() {
    }
    
    
    // getter and setter
    public int getNumberOfObstancles() {
        return numberOfObstancles;
    }

    public void setNumberOfObstancles(int numberOfObstancles) {
        this.numberOfObstancles = numberOfObstancles;
    }
    
    
    // equals and hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.numberOfObstancles;
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
        final PuzzleScene other = (PuzzleScene) obj;
        if (this.numberOfObstancles != other.numberOfObstancles) {
            return false;
        }
        return true;
    }
    
    
    // toString
    @Override
    public String toString() {
        return "PuzzleScene{" + "numberOfObstancles=" + numberOfObstancles + '}';
    }
}
