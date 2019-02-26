/*
StartRoom class extends Map
*/

import java.util.Scanner;

public class StartRoom extends Map
{ 
    Enemy e;    // The enemy to place on map
    
    /**
     * StartRoom Constructor
     * @param x The players starting x position
     * @param y The players starting y position
     */
    
    public StartRoom(int x, int y)
    {
        super(x, y, 5, 5);
        e = new Enemy("Skeleton", 20, 5, 5, 5, 5, 5);
    }
    
    /**
     * move method overrides super class move method, add enemy to a location
     * on the map
     * @param keyboard Keyboard input
     * @param player The player
     */

    @Override
    public void move(Scanner keyboard, Player player)
    {
        String input;                   // Hold input
        boolean active = true;          // 2D array map active
        boolean chestEmpty = false;
        
        // While active, keeping looping 2D array
        while (active)
        {
            super.move(keyboard, player);
        
            // Enemy
            if (x == 2 && y == 2)       
                Character.battle(player, e, keyboard);
            
            // Loot (HealthPotion)
            if (x == 1 && y == 2 && chestEmpty == false)
            {
                Item item = new HealthPotion();
                chestEmpty = super.chest(item, player);  
            }
            
            // Door
            if (x == 4 && y == 4)       
            {
                boolean choice = false;
                while (choice == false)
                {
                    System.out.print("There is a door. Would you like to "
                            + "go through the door?\n1. Yes\n2. No\n> ");
                    input = keyboard.nextLine();
                    switch (input)
                    {
                        case "1":
                            Hall hall = new Hall(0, 1);
                            hall.move(keyboard, player);
                            choice = true;
                            active = false;
                            break;
                        case "2":
                            choice = true;
                            break;
                    }
                }
            }
        }
    }
}
