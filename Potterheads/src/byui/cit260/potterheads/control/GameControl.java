/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.exceptions.MapControlException;
import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.InventoryItem;
import byui.cit260.potterheads.model.InventoryItem.InventoryItemType;
import byui.cit260.potterheads.model.Item;
//import byui.cit260.potterheads.model.InventoryItem.Item;
import byui.cit260.potterheads.model.Location;
import byui.cit260.potterheads.model.Map;
import byui.cit260.potterheads.model.Player;
import byui.cit260.potterheads.model.Scene;
import byui.cit260.potterheads.model.Scene.SceneType;
import byui.cit260.potterheads.model.Spell;
import byui.cit260.potterheads.model.Spell.SpellType;
import byui.cit260.potterheads.view.GameMenuView;
import byui.cit260.potterheads.view.GetSpellView;
import java.util.ArrayList;
import potterheads.Potterheads;
import byui.cit260.potterheads.model.TradeableItem;

/**
 *
 * @author alex
 */
public class GameControl {

    public static void createNewGame(Player player) {
        Game game = new Game();
        Potterheads.setCurrentGame(game);

        game.setPlayer(player);

        //create the inventory list and save inthe game
        ArrayList<InventoryItem> tradeableInventoryList = GameControl.createTradeableInventoryList();
        game.setTradeableInventory(tradeableInventoryList);
        
        ArrayList<Spell> spellInventoryList = GameControl.createSpellList();
        game.setSpellInventory(spellInventoryList);
        
        Map map = new Map(5, 5);
        game.setMap(map);
        GameControl.createMap();

        // move actors to starting position in the map
        try {
            MapControl.moveCharactersToStartingLocation(map);
        } catch (MapControlException me) {
            System.out.println(me.getMessage());
        }
    }

    public static Player createPlayer(String name) {
        if (name == null) {
            return null;
        }
        Player player = new Player();
        player.setName(name);
        Potterheads.setPlayer(player);
        return player;
    }

    public static ArrayList<InventoryItem> createTradeableInventoryList() {
//        InventoryItem[] inventory = 
//                new InventoryItem[13];
        //create array(list) of inventory items        
        ArrayList<InventoryItem> tradeableInventory = potterheads.Potterheads.getPlayer().getInventoryItems();
  
//            ----------SPELLS-----------
        InventoryItem snitch = new InventoryItem(InventoryItemType.snitch);
        tradeableInventory.add(snitch);

        InventoryItem timeTurner = new InventoryItem(InventoryItemType.timeTurner);
        tradeableInventory.add(timeTurner);
        
        InventoryItem maraudersMap = new InventoryItem(InventoryItemType.maraudersMap);
        tradeableInventory.add(maraudersMap);
        
        InventoryItem invisibilityCloak = new InventoryItem(InventoryItemType.invisibilityCloak);
        tradeableInventory.add(invisibilityCloak);
        
        InventoryItem americanMoney = new InventoryItem(InventoryItemType.americanMoney);
        tradeableInventory.add(americanMoney);
        
        InventoryItem gillyweed = new InventoryItem(InventoryItemType.gillyweed);
        tradeableInventory.add(gillyweed);
        
        InventoryItem firecrackers = new InventoryItem(InventoryItemType.firecrackers);
        tradeableInventory.add(firecrackers);
        
        InventoryItem replacementWand = new InventoryItem(InventoryItemType.replacementWand);
        tradeableInventory.add(replacementWand);

        return tradeableInventory;
    }
    
    public static ArrayList<Spell> createSpellList() {
        ArrayList<Spell> spellInventory = potterheads.Potterheads.getPlayer().getSpells();
  
//            ----------SPELLS-----------
//        Spell expelliarmus = new Spell(SpellType.expelliarmus);
//        spellInventory.add(expelliarmus);
//        
//        Spell stupify = new Spell(SpellType.stupify);
//        spellInventory.add(stupify);
//
//        Spell sectumsempra = new Spell(SpellType.sectumsempra);
//        spellInventory.add(sectumsempra);
//
//        Spell petrificusTotalus = new Spell(SpellType.petrificusTotalus);
//        spellInventory.add(petrificusTotalus);
//
//        Spell wingardiumLeviosa = new Spell(SpellType.wingardiumLeviosa);
//        spellInventory.add(wingardiumLeviosa);
        
        return spellInventory;
    }


    private static Map createMap() {
        //create the map
        Map map = Potterheads.getCurrentGame().getMap();
        
        //create the scenes for the game
        Scene[] scenes = createScenes();

        //assign scenes to locations
        GameControl.assignScenesToLocations(map, scenes);

        return map;
    }

    private static Scene[] createScenes() {

        Scene[] scenes = new Scene[SceneType.values().length];

        Scene startingScene = new Scene();
        startingScene.setDescription(
                "***the description will go here***");
        startingScene.setMapSymbol("ST");
        startingScene.setBlocked(false);
        scenes[SceneType.start.ordinal()] = startingScene;

        Scene finishScene = new Scene();
        finishScene.setDescription(
                "Congratulations, you beat the game.");
        finishScene.setMapSymbol("FN");
        finishScene.setBlocked(false);
        scenes[SceneType.finish.ordinal()] = finishScene;

        Scene puzzleScene = new Scene();
        puzzleScene.setDescription("***bad things happen here***");
        puzzleScene.setMapSymbol("PZ");
        puzzleScene.setBlocked(false);
        scenes[SceneType.puzzle.ordinal()] = puzzleScene;

        Scene characterScene = new Scene();
        characterScene.setDescription("***These scenes have characters***");
        characterScene.setMapSymbol("CH");
        characterScene.setBlocked(false);
        scenes[SceneType.character.ordinal()] = characterScene;

        Scene itemScene = new Scene();
        itemScene.setDescription("***These scenes have items***");
        itemScene.setMapSymbol("IT");
        itemScene.setBlocked(false);
        scenes[SceneType.item.ordinal()] = itemScene;
        
        Scene unknownScene = new Scene();
        unknownScene.setDescription("***not yet defined***");
        unknownScene.setMapSymbol("??");
        unknownScene.setBlocked(false);
        scenes[SceneType.unknown.ordinal()] = unknownScene;

       

        return scenes;
    }

    private static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        //start point
        locations[0][0].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.character.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.puzzle.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.item.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.finish.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[3][0].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[4][0].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.unknown.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.unknown.ordinal()]);
    }
    
    public int getInventoryCount(){
        Game game = new Game();
        ArrayList<InventoryItem> inventory = game.getTradeableInventory();
        int counter = 0;
        for (InventoryItem i: inventory){
            if(i != null){
                counter++;
            }
        }
        return counter;
    }
}
