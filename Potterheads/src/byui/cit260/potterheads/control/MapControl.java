/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.exceptions.MapControlException;
import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.Map;
import byui.cit260.potterheads.model.Character;
import java.awt.Point;
import potterheads.Potterheads;

/**
 *
 * @author Alex
 */
public class MapControl {
    public static Map createMap() {
        Game game = Potterheads.getCurrentGame();
        return game.getMap();
    }

    public static void moveCharactersToStartingLocation(Map map) 
            throws MapControlException {
        Character[] characters = Character.values();
        
        for (Character character : characters) {
            Point coordinates = character.getCoordinates();
            MapControl.moveCharactersToLocation(character, coordinates);
        }
    }
    
    public static void moveCharactersToLocation(Character character, Point coordinates) 
            throws MapControlException {
        
                Map map = Potterheads.getCurrentGame().getMap();
                int newRow = coordinates.x-1;
                int newColumn = coordinates.y-1;

                if (newRow < 0 || newRow >= map.getNoOfRows() || newColumn < 0 || newColumn >= map.getNoOfColumns()) {
                    throw new MapControlException("Cannot move player to location " + coordinates.x 
                                                    + ", " + coordinates.y + " because that location is "
                                                    + " outside the bounds of the map");
                }
    }
}
