/*
Hall class extends Map
*/

import java.util.Scanner;

public class Hall extends Map
{
    Enemy e;        // The enemy to place on map
    
    /**
     * Constructor
     * @param x The players starting x position
     * @param y The player starting y position
     */
    
    public Hall(int x, int y)
    {
        super(x, y, 3, 8);
        e = new Enemy("Dreaded Skeleton", 40, 10, 10, 10, 10, 10);
    }

    @Override
    public void move(Scanner keyboard, Player player)
    {
        String input;               // Hold input
        boolean active = true;      // 2D array map active
        boolean chestEmpty = false;     // Choice to enter room
        
        // While active, keep looping 2D array
        while (active)
        {
            super.move(keyboard, player); 
            
            if (x == 5 && y == 2)
                Character.battle(player, e, keyboard);
            
            if (x == 8 && y == 1 && chestEmpty == false)
            {
                Item item = new HealthPotion();
                chestEmpty = super.chest(item, player);
            }

            if (x == 5 && y == 0)       // Door
            {
                System.out.print("There is a door. Would you like to "
                    + "go through?\n> ");
            }   
        }
    }
}
