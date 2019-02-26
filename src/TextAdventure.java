/**
 * TextAdventure game
 * @author Chad Pickard
 */

import java.util.ArrayList;
import java.util.Scanner;

public class TextAdventure
{
    public static void main(String[] args)
    {       
        // Keyboard input
        Scanner keyboard = new Scanner(System.in);
        
        // Show game instructions
        gameInstructions();
        
        // Create start map
        StartRoom start = new StartRoom(0, 0);
        
        // Create the player
        Player player = createPlayer(keyboard);

        // Start game
        start.move(keyboard, player);
    }
    
    /**
     * gameInstructions method gives game instructions
     */
    
    public static void gameInstructions()
    {
        System.out.println("Welcome adventurer! You will be creating a"
                + " character to take through the dungeon where you will"
                + " battle many foes.\n");
        System.out.println("~First you will give your character a name.\n"
                + "~Second, you will choose a class. Your choices are:\n"
                + "1. Warrior: Uses strength for bonus damage in battle. The"
                + " warrior has special abilities that use rage. You build rage"
                + " by hitting enemies.\n2. Wizard: Uses intelligence for "
                + "bonus spell damage(Special Attacks). Spells use mana. Mana "
                + "is regenerated"
                + " during battle only. Wizards speical abilities do more\n"
                + "damage than warriors, therefore their strength modifier "
                + "will not be added to melee attacks.\n");
        System.out.println("~Third. A twenty sided dice will be rolled three "
                + "times. You will do this three times(one for each stat: "
                + "Strength, Dexterity, and Intelligence. The three highest\n "
                + "rolls will be totalled together. You will choose where to "
                + "put the three totals between strength, dexterity, and "
                + "intelligence. Dexterity will be used to see who attacks"
                + " first.\n");
        System.out.println("Make sure you explore each room 'THOROUGHLY'! You "
                + "can not go back to the previous room!\n"
                + "You will find enemies to battle and you will also find "
                + "items to pick up, such as weapons and health potions.\n");
    }
    
    /**
     * createPlayer will allow the user to create a player. Choose a name,
     * pick a class, and choose where to place their rolls into their stats
     * @param keyboard 
     * @return The player object
     */
    
    public static Player createPlayer(Scanner keyboard)
    {
        String name;        // Player name
        String input;       // Hold input
        int rollOne;        // First set of Rolls
        int rollTwo;        // Second set of Rolls
        int rollThree;      // Third set of Rolls
        
        // ArrayList to hold the three rolls
        ArrayList<Integer> rolls = new ArrayList<>();
        
        // Ask user their name
        System.out.print("Enter your name:\n> ");
        name = keyboard.nextLine();
        
        Player player = null;   // Create player object
        
        // Player picks a class
        boolean choice = false;
        while (choice != true)
        {
            System.out.print("Pick a class: \n" +
                "1. Warrior\n" +
                "2. Wizard\n> ");
            input = keyboard.nextLine();
            switch (input)
            {
                case "1":   // Create a Warrior object
                    player = new Warrior(name, 100, 0, 0, 0, 0, 0, true);
                    Item sword = new Sword();   
                    player.equipWeapon(sword);  
                    player.setPlayerClass(player);
                    choice = true;
                    break;
                case "2":   // Create a Wizard object
                    player = new Wizard(name, 100, 0, 0, 0, 0, 100, true);
                    Item sword1 = new Sword();
                    player.equipWeapon(sword1);
                    player.setPlayerClass(player);
                    choice = true;
                    break;
                default:
                    System.out.println("Sorry, that is not a valid choice...");
                    break;
            }
        }
        
        // Roll for base stats strength, dexterity, and intelligence
        // Add those rolls to rollOne, rollTwo, and rollThree
        System.out.println("\nRoll for your base stats:");
        System.out.println("You will roll four times for each stat(strength,"
                + ", dexterity, and intelligence. \nThe three highest rolls "
                + " of each set will be added together.");
        
        rollOne = rollStats();      // First set of rolls to assign to rollOne
        rollTwo = rollStats();      // Second set of rolls to assign to rollTwo
        rollThree = rollStats();    // Third set of rolls to assign to rollThree
        
        System.out.println("Roll 1: " + rollOne + "\nRoll 2: " + rollTwo +
                "\nRoll 3: " + rollThree);

        // Ask user if they want to keep rolls or roll again
        boolean statChoice = false;
        while (statChoice != true)
        {
            System.out.println("Do you wish to keep these rolls "
                + "or roll again? You can only roll one more "
                + "time.\n1. Keep roll\n2. Roll again");
            input = keyboard.nextLine();
        
            // Keep rolls
            switch (input)
            {
            // Roll again
                case "1":
                    rolls.add(rollOne);
                    rolls.add(rollTwo);
                    rolls.add(rollThree);
                    statChoice = true;
                    break;
                case "2":
                    rollOne = rollStats();
                    rollTwo = rollStats();
                    rollThree = rollStats();
                    rolls.add(rollOne);
                    rolls.add(rollTwo);
                    rolls.add(rollThree);
                    statChoice = true;
                    break;
                default:
                    System.out.println("Sorry, that is not a valid choice...");
                    break;
            }
        }
       
        // Ask user how they want to place their rolls towards
        // strength, dexterity, and intelligence
        for (int i = 0; i < 3; i++)
        {
            boolean picked = false;     // If user picked an attritbute
            
            System.out.println("Here are your three rolls:\nRoll 1: " + rollOne 
                    + "\nRoll 2: " + rollTwo + "\nRoll 3: " + rollThree);
            System.out.print("\nWhere do you want roll " + (i + 1) + "?\n1. "
                    + "Strength " + "\n2. Dexterity\n3. Intelligence\n> ");
            input = keyboard.nextLine();
            
            while (picked != true)
            {
                if (input.equals("1") && player.getStrength() == 0)
                {
                    player.setStrength(rolls.get(i));
                    picked = true;
                }

                else if (input.equals("2") && player.getDexterity() == 0)
                {
                    player.setDexterity(rolls.get(i));
                    picked = true;
                }
                    
                else if (input.equals("3") && player.getIntelligence() == 0)
                {
                    player.setIntelligence(rolls.get(i));
                    picked = true;
                }
                else
                {
                    System.out.println("Sorry, that is not a valid choice...");
                    System.out.print("\nWhere do you want roll " + (i + 1) + "?"
                            + "(" + rolls.get(i) + ")" + "\n1. "
                    + "Strength " + "\n2. Dexterity\n3. Intelligence");
                    input = keyboard.nextLine();
                }
            }
        }
        
        player.setStrModifier();        // Set players Strength modifier
        player.setDexModifier();        // Set players Dexterity modifier
        player.setIntelModifier();      // Set players Intelligence modifier

        return player;
    }
    
    /**
     * rollStats method rolls 'dice' to figure what the players base stats
     * will be.
     * @return The int total to assign to roll # in createPlayer method
     */
    
    public static int rollStats()
    {
        int first = 0;                  // The first highest roll
        int second = 0;                 // The second highest roll
        int third = 0;                  // The third highest roll
        int total = 0;                  // Total of the three highest rolls
        int[] roll = new int[4];        // Array to hold rolls
        
        // Roll Six sided dice four times
        for (int i = 0; i < roll.length; i++)
        {
            roll[i] = Dice.RollSixSided();
        }
        
        // Find the three highest rolls
        for (int i = 0; i < roll.length; i++) 
        { 
            if (roll[i] > first) 
            {
                third = second;
                second = first;
                first = roll[i];
            } 
            else if (roll[i] > second) 
            {
                third = second;
                second = roll[i];
            } 
            else if (roll[i] > third) 
            {
                third = roll[i];
            }
        }
        
        // Print three highest rolls and the total of the three rolls
        System.out.println("\nYour three highest rolls out of four are: ");
        System.out.println("First : " + first);
        System.out.println("Second : " + second);
        System.out.println("Third : " + third);
        total += (first + second + third);
        System.out.println("--------------");
        System.out.println("Total: " + total + "\n");

        return total;       // The total of the three highest rolls
    }
}
