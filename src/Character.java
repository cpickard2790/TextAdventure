
import java.util.Scanner;

/*
Characters class is the superclass for Player and Enemy
*/
public class Character
{
    // Base Stats
    protected String name;              // Characters name
    protected int health;               // Character health
    protected int strength;             // Characters strength
    protected int dexterity;            // Characters dexterity
    protected int intelligence;         // Characters intelligence
    protected int armorClass;           // Characters armor class

    
    // Modifiers
    protected int strModifier;          // Characters bonus to damage
    protected int dexModifier;          // Characters bonus to dodge
    protected int intelModifier;        // Characters bonus for spells
    protected int acModifier;           // Characers bonus towards armor
    
    /**
     * Constructor
     * @param n The characters name
     * @param hlth The characters health
     * @param str The characters strength
     * @param dex The characters dexterity
     * @param intel The characters intelligence
     * @param ac The characters armor class
     */
    
    public Character(String n, int hlth, int str, int dex, int intel, int ac)
    {
        name = n;
        health = hlth;
        strength = str;
        dexterity = dex;
        intelligence = intel;
        armorClass = ac;
    }

    /**
     * setStrModifier sets the strModifier
     */
    
    public void setStrModifier()
    {
         if (strength <= 3)
             strModifier = 0;
         else if (strength <= 6)
             strModifier = 1;
         else if (strength <= 9)
             strModifier = 2;
         else if (strength <= 12)
             strModifier = 3;
         else if (strength <= 15)
             strModifier = 4;
         else if (strength <= 18)
             strModifier = 5;
         else
             strModifier = 6;
    }
    
    /**
     * setDexModifier sets the dexModifier
     */
    
    public void setDexModifier()
    {
        if (dexterity <= 3)
             dexModifier = 0;
         else if (dexterity <= 6)
             dexModifier = 1;
         else if (dexterity <= 9)
             dexModifier = 2;
         else if (dexterity <= 12)
             dexModifier = 3;
         else if (dexterity <= 15)
             dexModifier = 4;
         else if (dexterity <= 18)
             dexModifier = 5;
         else
             dexModifier = 6;
    }
    
    /**
     * setIntelModifier sets the intelModifier
     */
    
    public void setIntelModifier()
    {
        if (intelligence <= 3)
             intelModifier = 0;
         else if (intelligence <= 6)
             intelModifier = 1;
         else if (intelligence <= 9)
             intelModifier = 2;
         else if (intelligence <= 12)
             intelModifier = 3;
         else if (intelligence <= 15)
             intelModifier = 4;
         else if (intelligence <= 18)
             intelModifier = 5;
         else
             intelModifier = 6;
    }
    
    /**
     * setArmorClass sets the acModifier
     */
    
    public void setArmorModifier()
    {
        if (armorClass <= 3)
            acModifier = 0;
        else if (armorClass <= 6)
            acModifier = 1;
        else if (armorClass <= 9)
            acModifier = 2;
        else if (armorClass <= 12)
            acModifier = 3;
        else if (armorClass <= 15)
            acModifier = 4;
        else if (armorClass <= 18)
            acModifier = 5;
        else
            acModifier = 6;
    }
    
    /**
     * getStrModifier returns the strModifier
     * @return The int in strModifier
     */
    
    public int getStrModifier()
    {
        return strModifier;
    }
    
    /**
     * getDexModifier returns the dexModifier
     * @return The int in dexModifier
     */
    
    public int getDexModifier()
    {
        return dexModifier;
    }
    
    /**
     * getIntelModifier returns the intelModifier
     * @return The int in intelModifier
     */
    
    public int getIntelModifier()
    {
        return intelModifier;
    }
    
    /**
     * setName method sets the characters name
     * @param n The String value to hold in name
     */
    
    public void setName(String n)
    {
        name = n;
    }
    
    /**
     * getName method returns the players name
     * @return The string value in name
     */
    
    public String getName()
    {
        return name;
    }
    
    /**
     * setHealth method sets the characters health
     * @param health The int value to hold in health
     */
    
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    /**
     * getHealth returns the characters health
     * @return The int value in health
     */
    
    public int getHealth()
    {
        return health;
    }
    
    /**
     * setStrength method sets the characters strength
     * @param str The int value to store in strength
     */
    
    public void setStrength(int str)
    {
        strength = str;
    }
    
    /**
     * getStrength method returns the characters strength
     * @return The int value in strength
     */
    
    public int getStrength()
    {
        return strength;
    }
    
    /**
     * setDexterity method sets the characters dexterity
     * @param dex The int value to store in dexterity
     */
    
    public void setDexterity(int dex)
    {
        dexterity = dex;   
    }
    
    /**
     * getDexterity method returns the characters dexterity
     * @return The int value in dexterity
     */
    
    public int getDexterity()
    {
        return dexterity;
    }
    
    /**
     * setIntelligence method sets the characters intelligence
     * @param intel The int value to store in intelligence
     */
    
    public void setIntelligence(int intel)
    {
        intelligence = intel;
    }
    
    /**
     * getIntelligence method returns the characters intelligence
     * @return The int value in intelligence
     */
    
    public int getIntelligence()
    {
        return intelligence;
    }
    
    /**
     * setArmorClass method sets the characters armor class
     * @param ac The int value to store in armorClass
     */
    
    public void setArmorClass(int ac)
    {
        armorClass = ac;
    }
    
    /**
     * getArmorClass method returns the characters armorClass
     * @return The int value in armorClass
     */
    
    public int getArmorClass()
    {
        return armorClass;
    }
    
    /**
     * takeDamage method subtracts health from the character
     * @param dmg The damage to subtract from health
     */
    
    public void takeDamage(int dmg)
    {
        health -= dmg;
    }
    
    /**
     * battle method allows characters to battle and do damage
     * @param p The player character
     * @param e The enemy character
     * @param keyboard Input
     */
    
    public static void battle(Player p, Enemy e, Scanner keyboard)
    {
        String input;
        
        while (p.isAlive() && e.health > 0)
        {
            p.battleHUD();
            System.out.println("Enemy: " + e.getName() + " ~ Health: " + 
                    e.getHealth() + "\n------------------------------");
            
            System.out.print("1. Attack\n2. Special Attacks\n"
                    + "3. Inventory\n> ");
            input = keyboard.nextLine();
            
            switch (input)
            {
                case "1":
                    int dexCheck = Dice.RollTwentySided();
                    if (dexCheck > (e.dexterity + e.dexModifier))
                    {
                        p.playerMeleeAttack(e);
                        if (e.health > 0)
                            e.EnemyAttack(p);
                    }
                    else
                    {
                        e.EnemyAttack(p);
                        if (p.health > 0)
                            p.playerMeleeAttack(e);
                    }
                    System.out.println();
                    break;
                case "2":
                    p.specialAttacks(e);
                    break;
                case "3":
                    p.getInventory();
                    break;
                default:
                    System.out.println("Sorry, that is not a valid choice...");                       
            }
        }
    }
    
    /**
     * toString method
     * @return A reference to a String
     */
    
    public String toString()
    {
        String str;
        
        str = "Name: " + name + "\nHealth: " + health;
        
        return str;
                
    }
}
