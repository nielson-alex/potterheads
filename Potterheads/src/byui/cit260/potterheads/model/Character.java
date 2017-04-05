/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author alex
 */
public enum Character implements Serializable {

    Dumbledore("He is the headmaster of Hogwarts."),
    Snape("He is the potions professor."),
    Hermione("She is the smartest student at Hogwarts"),
    Malfoy("Everyone says he's going to hell"),
    FredAndGeorge("Ron's older brothers. They're always getting into trouble."),
    Harry("'The Boy Who Lived'. You've heard about the wizard but don't know much about him."),
    Ron("Harry's best friend. No one really knows what he does."),
    Neville("Everyone says he grew up to be hot."),
    McGonagall("Is she a teacher?"),
    Lupin("Defense Against the Dark Arts teacher. Also a werewolf.");

    private final String description;
    private final Point coordinates;

    Character(String description) {
        this.description = description;
        coordinates = new Point(1, 1);
    }

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }
}
