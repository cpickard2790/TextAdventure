/*
Player class extends Character creating the player character
*/

import java.util.Scanner;
import java.util.ArrayList;

public abstract class Player extends Character      
{
    protected Player playerClass;           // The players class
    
    // Player inventory
    protected ArrayList<Item> backpack = new ArrayList<>();
    protected Item equipped;                // The equipped item
    protected Item p;
    protected boolean alive;
    
    /*
    Constructor
    */
    
    public Player(String n, int hlth, int str, int dex, int intel, int ac,
            boolean alive)
    {
        super(n, hlth, str, dex, intel, ac);
        this.alive = alive;
    }
    
    public boolean isAlive()
    {
        if (health <= 0)
        {
            System.out.println("Game Over!");
            System.exit(0);
        }
        
        return alive;
    }
    

    /**
     * playerAttack method does damage to the enemy
     * @param enemy The enemy to do damage to
     */
    
    public void playerMeleeAttack(Enemy enemy)
    {
        int damage = 0;                 // The players damage

        int acRoll = Dice.RollTwentySided();  // Roll for armor class of enemy
        
        if (acRoll == 20)
        {
            damage = equipped.useItem() + strModifier + 5;
            
            System.out.println("Critical hit! You did " + damage +
                                " damage!");
        }
        // Subtract enemy acModifier from damage
        else if (acRoll >= enemy.armorClass)
        {
            damage = equipped.useItem() + strModifier - enemy.acModifier;
            System.out.println("You did " + damage + 
                        " damage");
        }
        // Hit target, but enemy armor blocked your attack
        else 
            System.out.println("You missed!");

        enemy.health -= damage;
    }
    
    /**
     * setPlayerClass method sets the players class
     * @param playerClass The class of the player
     */
    
    public void setPlayerClass(Player playerClass)
    {
        this.playerClass = playerClass;
    }
    
    /**
     * getPlayerClass returns what class the player is
     * @return The players class
     */
    
    public Player getPlayerClass()
    {
        return playerClass;
    }
    
    /**
     * addToInventory adds a Item object to players backpack
     * @param item The Item object to store in backpack
     */
    
    public void addToInventory(Item item)
    {
        if (backpack.size() <= 10)
            backpack.add(item);
        else
            System.out.println("Sorry, your backpack is full.");
    }
    
    /**
     * getInventory method prints the elements in backpack and gives
     * player options of what to do.
     */
    
    public void getInventory()
    {
        String input;
        boolean done = false;
        Scanner keyboard = new Scanner(System.in);
        if (!backpack.isEmpty())
        {
            backpack.forEach(System.out::println);
            while (!done)
            {
                System.out.print("What would you like to do?\n"
                    + "1. Equip/Use Item\n"
                    + "2. Drop Item\n"
                    + "3. Exit Inventory\n> ");
                input = keyboard.nextLine();
        
                switch (input)
                {
                    case "1":
                        equipItem();
                        done = true;
                        break;
                    case "2":
                        dropItem();
                        done = true;
                        break;
                    case "3":
                        System.out.println("Exiting inventory..");
                        done = true;
                        break;
                    default:
                        System.out.println("That is not a valid choice...");
                        break;
                }   
            }
        }
        else
            System.out.println("Backpack is empty...");
    }
    
    /**
     * equipItem method add a item to equipped
     */
    
    public void equipItem()
    {
        int input;
        Scanner keyboard = new Scanner(System.in);
 
        for (int i = 0; i < backpack.size(); i++)
        {
            System.out.println((i + 1) + ": " + backpack.get(i));
        }
        try
        {
            input = keyboard.nextInt();
            if (backpack.get(input - 1).getIdent() == 1)
            {
                equipped = backpack.get(input - 1);
                System.out.println("Item equipped");
            }
            else if (backpack.get(input - 1).getIdent() == 2)
                health += backpack.get(input - 1).useItem();
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Nothing in that slot...");
        }         
    }
    
    /**
     * equipWeapon equips a weapon to the player
     * @param item Item to store in equipped
     */
    
    public void equipWeapon(Item item)
    {
        equipped = item;
    }
    
    /**
     * dropItem method removes an Item from the backpack array list
     */
    
    public void dropItem()
    {
        int input;
        String choice;
        boolean dropped = false;
        Scanner keyboard = new Scanner(System.in);
        
        for (int i = 0; i < backpack.size(); i++)
        {
            System.out.println((i + 1) + ": " + backpack.get(i));
        }
        try
        {
            input = keyboard.nextInt();
                while (!dropped)
                {
                    System.out.print("Are you sure you wish to drop " + 
                        backpack.get(input - 1).getName() + "?\n"
                                + "1. Yes\n2. No\n> ");
                    choice = keyboard.nextLine();
                    switch (choice)
                    {
                        case "1":
                            backpack.remove(input - 1);
                            System.out.println("Item removed");
                            dropped = true;
                            break;
                        case "2":
                            break;
                    }
                }
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Nothing in that slot...");
        }
    }
    
    // Abstract classes for subclasses of player
    public abstract void specialAttacks(Enemy enemy); // subclasses spec attacks
    public abstract String getHUD();                  // displays classes HUD
    public abstract void battleHUD();                 // subclasses battle HUD
    
    /**
     * toString method
     * @return A String representation of Player
     */
    
    public String toString()
    {
        String str = super.toString() + "\nStrength: " + strength + 
                "\nDexterity: " + dexterity + "\nIntelligence:" + intelligence +
                "\nArmor Class: " + armorClass + "\nStrength Modifer: "
                + strModifier + "\nDexterity Modifier: " + dexModifier +
                "\nIntelligence Modifier: " + intelModifier + "\nArmor Class"
                + "Modifier: " + acModifier + "\n";
        return str;
    }
}
