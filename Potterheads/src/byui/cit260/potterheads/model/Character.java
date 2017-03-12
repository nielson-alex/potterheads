/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author alex
 */
public enum Character implements Serializable {
    
        Dumbledore("He is the headmaster of Hogwarts.", null),
        Snape("He is the potions professor.", null),
        Hermione("She is the smartest student at Hogwarts", null),
        Malfoy("Everyone says he's going to hell", null),
        FredAndGeorge("Ron's older brothers. They're always getting into trouble.", null),
        Harry("'The Boy Who Lived'. You've heard about the wizard but don't know much about him.", null),
        Ron("Harry's best friend. No one really knows what he does.", null),
        Neville("Everyone says he grew up to be hot.", null),
        McGonagall("Is she a teacher?", null),
        Lupin("Defense Against the Dark Arts teacher. Also a werewolf.", null);

    private final String description;
    private final Item item;
    private final Point coordinates;
    
    //Create cardinality of many
    ArrayList<Item> inventoryItems = new ArrayList<>();
    

    // constructor function
    Character(String description, Item item) {
        
        this.description = description;
        this.item = item;
        coordinates = new Point(1,1);
    }

    public String getDescription() {
        return description;
    }

    public Item getItem() {
        return item;
    }

    public Point getCoordinates() {
        return coordinates;
    }


    // toString()
    @Override
    public String toString() {
        return "Character{" + "name=" + //+ name +
                 ", description=" + description + ", numberOfItems=" + item + ", coordinates=" + coordinates + '}';
    }
    
    

}
