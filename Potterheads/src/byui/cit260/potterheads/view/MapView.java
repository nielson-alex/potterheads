/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Location;
import byui.cit260.potterheads.model.Map;
import java.io.PrintWriter;
import potterheads.Potterheads;



/**
 *
 * @author Alex
 */
public class MapView extends View {
    protected final PrintWriter console = Potterheads.getOutFile();
    StringBuilder line;
    
    public MapView() {
        super("Map");
    }

    @Override
    public void display() {
        Map map = Potterheads.getCurrentGame().getMap();
        Location[][] locations = map.getLocations();
        
        line = new StringBuilder();
        StringBuilder hyphens = new StringBuilder();
        line.append("  ");
        hyphens.append("  ");

        for (int i = 1; i <= locations.length; i++) {
            line.append(i);
            line.append("    ");
            hyphens.append("-----");
        }

        this.console.println(line.toString());
        this.console.println(hyphens.toString());

        for (int rowIndex = 0; rowIndex < locations.length; rowIndex++) {
            line = new StringBuilder("");
            line.append(rowIndex + 1);

            Location[] row = locations[rowIndex];

            for (Location column : row) {
                line.append("| ");
                line.append(column.getScene().getMapSymbol());
                line.append(" ");
            }
            line.append("|");
            this.console.println(line.toString());
            this.console.println(hyphens.toString());
        }
        
        this.console.println("\nChoose where you would like to go on the map:\n"
                + "1. Diagon Alley             2. Polyjuice Potion Lab\n"
                + "3. Quidditch Pitch          4. Hagrid's House\n"
                + "5.                          6.\n"
                + "7.                          8.\n"
                + "9.                          10.\n"
                + "11.                         12.\n"
                + "13.                         14.\n"
                + "15.                         16.\n"
                + "17.                         18.\n"
                + "19.                         20.\n"
                + "21.                         22.\n"
                + "23.                         24.\n"
                + "25.\n\n"
                + "Q - quit");

        
        String input = this.getInput();
        boolean done = this.doAction(input);
//        boolean done = this.doAction(this.getInput());
        if (!done) {
            this.display();
        }
    }
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        
        switch (value) {
            case "DA":
                DiagonAlleyView diagonAlleyView = new DiagonAlleyView();
                diagonAlleyView.display();
                break;
            case "PJ":
                PolyjuiceView polyjuiceView = new PolyjuiceView();
                polyjuiceView.display();
                break;
            case "QP":
                QuidditchView quidditchView = new QuidditchView();
                quidditchView.display();
                break;
            case "HH":
                GetSpellView getSpellView = new GetSpellView();
                getSpellView.display();
                break;
            case "Q":
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid selection. Choose an item from the map");
                break;
        }
        return false;
    }
}
