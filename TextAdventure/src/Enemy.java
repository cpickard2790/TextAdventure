/*
Enemy class. Subclass of Character
*/

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Character
{
    Random rand = new Random();     // Create a new random object
    
    // Item/s enemy will drop
    protected ArrayList<Item> loot = new ArrayList<>();
    
    protected int rollDamage;       // Enemy damage
    
    /**
     * Constructor
     * @param n The enemy's name
     * @param hlth  The enemy's health
     * @param str The enemy's strength
     * @param dex The enemy's dexterity
     * @param intel
     * @param ac 
     */
    
    public Enemy(String n, int hlth, int str, int dex, int intel, int ac,
            int dmg)
    {
        super(n, hlth, str, dex, intel, ac);
        super.setStrModifier();
        super.setDexModifier();
        super.setIntelModifier();
        rollDamage = dmg;
    }
    
    /**
     * getDamage method gets the enemy's damage
     * @return The enemy's damage
     */
    
    public int getDamage()
    {
        int damage = rand.nextInt(rollDamage) + 1;
        
        return damage;
    }
    
    /**
     * EnemyAttack method attacks the player
     * @param player The player to attack
     */
    
    public void EnemyAttack(Player player)
    {
        int damage = 0;                            // enemy's damage

        int acRoll = Dice.RollTwentySided();    // enemy's roll for armor check
        
        if (acRoll == 20)
        {
            damage = getDamage() + 5;
            
            System.out.println("A " + name + " critically hit you for " +
                    damage + " damage!");
        }
        // Subtract enemy acModifier from damage
        else if (acRoll >= player.armorClass)
        {
            damage = (getDamage() + strModifier) - player.acModifier;
            System.out.println("A " + name + " hit you for " + damage + 
                    " damage");
        }
        // Hit target, but enemy armor blocked your attack
        else 
            System.out.println("You missed!");

        player.health -= damage;
        
        if (player.health <= 0)
            System.out.println("You have died!");
    }
}
