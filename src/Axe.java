/*
 Axe class extends Item
 Weapon
*/

public class Axe extends Item
{
    /**
     * Constructor
     */
    
    public Axe()
    {
        super("One-Handed Axe", 1);
    }
    
    /**
     * useItem method
     * @return The random integer from Dice.RollSixSided
     */
    
    @Override
    public int useItem()
    {
        System.out.println("Rolling 8 sided dice for weapon damage...");
        int damage = Dice.RollEightSided();
        System.out.print("You rolled a " + damage + ".");
        
        return damage;
    }

    /**
     * toString method
     * @return A String representation of Sword
     */
    
    @Override
    public String toString()
    {
        String str = super.toString() + " | Damage: Roll 8 Sided dice";
        
        return str;
    }
}
