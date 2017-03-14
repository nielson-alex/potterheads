/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.Map;
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

    static void moveCharactersToStartingLocation(Map map) {
        System.out.println("\n*** moveCharactersToStartingLocation function called ***");
    }
}
