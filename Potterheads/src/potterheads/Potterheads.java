/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potterheads;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.Player;
import byui.cit260.potterheads.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Alex test
 */
/* Alex: diagonalley, item, puzzle scene and character
Glaser: game, polyjuice, quidditch, and map
Reese: itemScene, location, scene, characterScene
 */
public class Potterheads {

    private static Game currentGame = null;
    private static Player player = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    private static PrintWriter logFile = null;

    /**
     * @param args the command line arguments second test
     */
    public static void main(String[] args) {

        try {
            // pen character stream files for end user input and output
            Potterheads.inFile = new BufferedReader(new InputStreamReader(System.in));

            Potterheads.outFile = new PrintWriter(System.out, true);

            // open log file
            String filePath = "log.txt";
            Potterheads.logFile = new PrintWriter(filePath);

            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();

        } catch (Throwable e) {
            System.out.println("Exception: " + e.toString() + "\nCause: " + e.getCause()
                    + "\nMessage: " + e.getMessage());

            e.printStackTrace();
        } finally {
            try {
                if (Potterheads.inFile != null) {
                    Potterheads.inFile.close();
                }

                if (Potterheads.outFile != null) {
                    Potterheads.outFile.close();
                }

                if (Potterheads.logFile != null) {
                    Potterheads.logFile.close();
                }

            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
        }
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Potterheads.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Potterheads.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutfile(PrintWriter outfile) {
        Potterheads.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        Potterheads.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        Potterheads.logFile = logFile;
    }
}
