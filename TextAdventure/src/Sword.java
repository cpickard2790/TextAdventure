/*
Class Sword extends Item
Weapon
*/

public class Sword extends Item
{
    /**
     * Sword Constructor
     */
    
    public Sword()
    {
        super("One-Handed Sword", 1);
    }
    
    /**
     * useItem method
     * @return The random integer from Dice.RollSixSided
     */
    
    public int useItem()
    {
        System.out.println("Rolling 6 sided dice for weapon damage...");
        int damage = Dice.RollSixSided();
        System.out.print("You rolled a " + damage + ".");
        
        return damage;
    }

    /**
     * toString method
     * @return A String representation of Sword
     */
    
    public String toString()
    {
        String str = super.toString() + " | Damage: Roll 6 Sided dice";
        
        return str;
    }
}
