/*
/* Welcome screen:
/*The end user enters the command to start the program/game. The computer displays the
/*banner screen including the title of the game. The computer also requests for the user to input
/*their desired name. The user enters their name and the computer displays a welcome message,
/*along with a brief description of the game and the Main Menu. An error message is displayed if
/*the user enters an invalid name or command.
*/
package byui.cit260.potterheads.view;

/**
 *
 * @author Alexandra
 */
public class StartProgramView {
   private String promptMessage;
   
   public StartProgramView(){
       this.promptMessage = "\nPlease enter your name: ";
       // display the banner when view is created
       this.displayBanner();
       
   }

    private void displayBanner() {
        System.out.println(
                "\n************************************************************"
                +"\n* Welcome, Potterheads!                                   *"
                +"\n* This text-based game takes players throughout           *"
                +"\n* the world of Harry Potter. Users will discover          *"
                +"\n* they’re a wizard/witch, obtain school supplies of       *"
                +"\n* their choice, attend school and learn spells, and       *"
                +"\n* use these spells to defend and assist themselves as     *"
                +"\n* they explore the world. As players learn and explore,   *"
                +"\n* they are awarded “House Points” which are spent on      *"
                +"\n* mulligans and various items.                            *"
                +"\n************************************************************"
                );
    
    }

    public void displayStartProgramView() {
               System.out.println("\n*** displayStartProgram() fuction called ***");
 
    }
            
}
