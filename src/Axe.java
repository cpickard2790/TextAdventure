/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cpick
 */
public class Axe extends Item
{
    public Axe()
    {
        super("One-Handed Axe", 1);
    }
    
    /**
     * useItem method
     * @return The random integer from Dice.RollSixSided
     */
    
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
    
    public String toString()
    {
        String str = super.toString() + " | Damage: Roll 8 Sided dice";
        
        return str;
    }
}
