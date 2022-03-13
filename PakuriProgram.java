import java.util.Scanner;

/**
 * This class creates a game using small creatures called Pakuri.
 */
public class PakuriProgram {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String userInput ="";
        boolean isValidInput = false;
        String maxCapacityAsStr = "";
        int maxCapacityAsInt = 0;
        Pakudex pakudex;
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        while (!isValidInput) {
            System.out.print("Enter max capacity of the Pakudex:");
            maxCapacityAsStr = scr.next();
            try {
                maxCapacityAsInt = Integer.parseInt(maxCapacityAsStr);
                if(maxCapacityAsInt<=0){
                    throw new Exception();
                }
                isValidInput = true;
            }
            catch (Exception e) {
                System.out.println("Please enter a valid size.");
            }
        }
        //Prints "The Pakudex can hold " + maxCapacityAsStr + " species of Pakuri.".
        System.out.println("The Pakudex can hold " + maxCapacityAsStr + " species of Pakuri.");
        pakudex = new Pakudex(maxCapacityAsInt);

        while (true){
            System.out.println();
            System.out.println("Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1.  List Pakuri");
            System.out.println("2.  Show Pakuri");
            System.out.println("3.  Add Pakuri");
            System.out.println("4.  Evolve Pakuri");
            System.out.println("5.  Sort Pakuri");
            System.out.println("6.  Exit");
            System.out.println();
            System.out.print("What would you like to do?");
            userInput = scr.next();
            if(userInput.equals("1")){
                if(pakudex.getSize() == 0){
                    System.out.println("No Pakuri in Pakudex yet!");
                }
                //Prints "Pakuri In Pakudex: " and then prints the creatures in the order they were added.
                else {
                    String [] speciesList = pakudex.getSpeciesArray();
                    System.out.println("Pakuri In Pakudex: ");
                    int pakuriCounter = 1;
                    for ( String species : speciesList) {
                        System.out.println(pakuriCounter + ". "+ species);
                        pakuriCounter++;
                    }
                }
            }
            else if(userInput.equals("2")){
                System.out.print("Enter the name of the species to display: ");
                String pakuriSpeciesToDisplay = scr.next();
                int[] stats = pakudex.getStats(pakuriSpeciesToDisplay);
                if(stats == null) {
                    System.out.println("Error: No such Pakuri!");
                }
                else {
                    System.out.println("Species: " + pakuriSpeciesToDisplay);
                    System.out.println("Attack: " + stats[0]);
                    System.out.println("Defense: " + stats[1]);
                    System.out.println("Speed: " + stats[2]);
                }
            }
            //Adds creatures to the game unless Pakudex is full or a creature already exists then it prints an error message.
            else if(userInput.equals("3")) {
                if (pakudex.getCapacity() == pakudex.getSize()) {
                    System.out.println("Error: Pakudex is full!");
                }
                else {
                    String pakuriSpeciesToAdd = "";
                    System.out.print("Enter the name of the species to add: ");
                    pakuriSpeciesToAdd = scr.next();
                    if (pakudex.addPakuri(pakuriSpeciesToAdd)) {
                        System.out.println("Pakuri species " + pakuriSpeciesToAdd + " successfully added!");
                    }
                }
            }
            else if (userInput.equals("4")) {
                System.out.print("Enter the name of the species to evolve:");
                String pakuriSpeciesToEvolve = scr.next();
                boolean isEvolveSpecies = pakudex.evolveSpecies(pakuriSpeciesToEvolve);
                if(!isEvolveSpecies) {
                    System.out.println("Error: No such Pakuri!");
                }
                else {
                    System.out.println( pakuriSpeciesToEvolve + " has evolved!");
                }
            }
            //Prints "Pakuri have been sorted!" and uses the sortPakuri method.
            else if(userInput.equals("5")){
                System.out.println("Pakuri have been sorted!");
                pakudex.sortPakuri();
            }
            else if(userInput.equals("6")){
                System.out.println("Thanks for using Pakudex! Bye!");
                break;
            }
            else {
                System.out.println("Unrecognized menu selection!");
            }
        }
    }
}
