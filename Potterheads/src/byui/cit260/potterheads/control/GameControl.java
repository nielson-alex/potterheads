/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.InventoryItem;
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
import java.util.ArrayList;
import potterheads.Potterheads;

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
        MapControl.moveCharactersToStartingLocation(map);

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
        ArrayList<InventoryItem> tradeableInventory = new ArrayList<InventoryItem>(8);

        InventoryItem timeTurner = new InventoryItem("Time Turner", "Hermione goes back in time with this",
                "Tradeable", 0);
        tradeableInventory.add(timeTurner);
//        InventoryItem timeTurner = new InventoryItem();
//        timeTurner.setName("Time Turner");
//        timeTurner.setDescription("Lets you go back in time.");
//        timeTurner.setQuantityInStock(0);
//        timeTurner.setInventoryType("Tradeable");
//        inventory[Item.timeTurner.ordinal()] = timeTurner;

        InventoryItem snitch = new InventoryItem("Golden Snitch", "You caught this",
                "Tradeable", 0);
        tradeableInventory.add(snitch);
//        InventoryItem snitch = new InventoryItem();
//        snitch.setName("Golden Snitch");
//        snitch.setDescription("You won this, good job");
//        snitch.setQuantityInStock(0);
//        snitch.setInventoryType("Tradeable");
//        inventory[Item.snitch.ordinal()] = snitch;

        InventoryItem maraudersMap = new InventoryItem("Marauder's Map", "Lupin might want this back",
                "Tradeable", 0);
        tradeableInventory.add(maraudersMap);
//        InventoryItem maraudersMap = new InventoryItem();
//        maraudersMap.setName("Marauder's Map");
//        maraudersMap.setDescription("It's the Marauder's Map");
//        maraudersMap.setQuantityInStock(0);
//        maraudersMap.setInventoryType("Tradeable");
//        inventory[Item.maraudersMap.ordinal()] = maraudersMap;

        InventoryItem invisibilityCloak = new InventoryItem("Invisibility Cloak",
                "Belongs to Harry", "Tradeable", 0);
        tradeableInventory.add(invisibilityCloak);
//        InventoryItem invisibilityCloak = new InventoryItem();
//        invisibilityCloak.setName("Invisibility Cloak");
//        invisibilityCloak.setDescription("Harry uses this for illegal reasons");
//        invisibilityCloak.setQuantityInStock(0);
//        invisibilityCloak.setInventoryType("Tradeable");
//        inventory[Item.invisibilityCloak.ordinal()] = invisibilityCloak;

        InventoryItem americanMoney = new InventoryItem("American Money",
                "Used to buy things.", "Tradeable", 0);
        tradeableInventory.add(americanMoney);
//        InventoryItem americanMoney = new InventoryItem();
//        americanMoney.setName("American cash");
//        americanMoney.setDescription("Why did Hagrid have this?");
//        americanMoney.setQuantityInStock(0);
//        americanMoney.setInventoryType("Tradeable");
//        inventory[Item.americanMoney.ordinal()] = americanMoney;

        InventoryItem gillyweed = new InventoryItem("Gillyweed", "Snape might like this",
                "Tradeable", 0);
        tradeableInventory.add(gillyweed);
//        InventoryItem gillyweed = new InventoryItem();
//        gillyweed.setName("Gilly Weed");
//        gillyweed.setDescription("I don't even remember this from the books.");
//        gillyweed.setQuantityInStock(0);
//        gillyweed.setInventoryType("Tradeable");
//        inventory[Item.gillyweed.ordinal()] = gillyweed;

        InventoryItem firecrackers = new InventoryItem("Firecrackers",
                "Fred and George would like these", "Tradeable", 0);
        tradeableInventory.add(firecrackers);
//        InventoryItem firecrackers = new InventoryItem();
//        firecrackers.setName("Firecrackers");
//        firecrackers.setDescription("Fred and George could do real damage with these.");
//        firecrackers.setQuantityInStock(0);
//        firecrackers.setInventoryType("Tradeable");
//        inventory[Item.firecrackers.ordinal()] = firecrackers;

        InventoryItem replacementWand = new InventoryItem("Replacement Wand",
                "Ron could use this", "Tradeable", 0);
        tradeableInventory.add(replacementWand);
//        InventoryItem replacementWand = new InventoryItem();
//        replacementWand.setName("Replacement Wand");
//        replacementWand.setDescription("Ron could use this.");
//        replacementWand.setQuantityInStock(0);
//        replacementWand.setInventoryType("Tradeable");
//        inventory[Item.replacementWand.ordinal()] = replacementWand;

        return tradeableInventory;
    }
    
    public static ArrayList<Spell> createSpellList() {
        potterheads.Potterheads.getPlayer().setSpells(new ArrayList<Spell>());
        ArrayList<Spell> spellInventory = potterheads.Potterheads.getPlayer().getSpells();
        
        //    ----------SPELLS-----------
        Spell expelliarmus = new Spell(SpellType.expelliarmus);
        spellInventory.add(expelliarmus);
        
        Spell stupify = new Spell(SpellType.stupify);
        spellInventory.add(stupify);

        Spell sectumsempra = new Spell(SpellType.sectumsempra);
        spellInventory.add(sectumsempra);

        Spell petrificusTotalus = new Spell(SpellType.petrificusTotalus);
        spellInventory.add(petrificusTotalus);

        Spell wingardiumLeviosa = new Spell(SpellType.wingardiumLeviosa);
        spellInventory.add(wingardiumLeviosa);
        
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
}
