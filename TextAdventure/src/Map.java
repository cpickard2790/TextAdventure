/*
Map class
Creates a map for the player to move around
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Map
{
    protected int x;        // Player x position
    protected int y;        // Player y position
    protected int r;        // Map x size
    protected int c;        // Map y size
    
    // Keyboard input
    Scanner keyboard = new Scanner(System.in);
    
    /**
     * Map Constructor
     * @param x The players starting x position
     * @param y The players starting y position
     * @param r The number of rows(x)
     * @param c The number of columns(y)
     */
    
    public Map(int x, int y, int r, int c)
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
    }
    
    /**
     * move method moves player(X) around on 2d array
     * @param keyboard Keyboard input
     * @param player The player
     */
    
    public void move(Scanner keyboard, Player player)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~Map~~~~~~~~~~~~~~~~~~~~~~~");
        // Print the 2D array with a map of "0" and player position as "X"
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (i == y && j == x)
                        System.out.print("X");
                else
                    System.out.print("0");
            }
            System.out.println("");
        }
        
        // Get input for player movement
        String input;
        
        // Show player HUD
        System.out.println(player.getHUD());
        
        // Menu choices
        System.out.println("1. Inventory  2. Player Stats  3. Quit");
        System.out.print("W = Up  A = Left  S = Down  D = Right\n> ");
        input = keyboard.nextLine();
        
        if (input.equalsIgnoreCase("w") && y != 0)          // Move Up
            y--;
        if (input.equalsIgnoreCase("s") && y != (r - 1))    // Move Left
            y++;
        if (input.equalsIgnoreCase("a") && x != 0)          // Move down
            x--;
        if (input.equalsIgnoreCase("d") && x != (c - 1))    // Move right
            x++;
        if (input.equals("1"))              // Get inventory
            player.getInventory();
        if (input.equals("2"))              // View player stats
            System.out.println(player);
        if (input.equals("3"))              // Quit game
        {
            boolean choice = false;
            
            while (choice == false)
            {
                System.out.print("Are you sure you wish to quit?\n1. Yes\n"
                    + "2. No\n> ");
                input = keyboard.nextLine();
                if (input.equals("1"))
                    System.exit(0);
                else if (input.equals("2"))
                {
                    System.out.println();
                    choice = true;
                }
                else
                    System.out.println("Invalid choice. Try again...");
            }
        }   
    }
    
    /**
     * chest method has item for player to pick up
     * @param item The item to pick up
     * @param player The player character
     * @return True if the item was picked up
     */
        
    public boolean chest(Item item, Player player)
    {
        String input;

        boolean choice = false;
        boolean chestEmpty = false;
            
        while (choice == false)
        {   
            if (chestEmpty == false)
            {
                System.out.println("You found a chest!");
                System.out.print("Would you like to pick up a " + item
                    + "?\n1. Yes\n2. No");
                input = keyboard.nextLine();
                
                switch (input)
                {
                    case "1":
                        player.addToInventory(item);
                        choice = true;
                        chestEmpty = true;
                        break;
                    case "2":
                        System.out.println("Ok. Not picking item up.");
                        choice = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again...");
                        break;
                }
            }
        }
        return chestEmpty;
    }
}
