/*
HealthPotion class extends Item
Potion
*/

public class HealthPotion extends Item
{ 
    /**
     * HealthPotion Constructor
     */
    
    public HealthPotion()
    {
        super("Health Potion", 2);
    }
    
    /**
     * useItem method
     * @return The integer of heal
     */
    
    public int useItem()
    {
        System.out.println("Using health potion...");
        int heal = 10;
        return heal;
    }
}
