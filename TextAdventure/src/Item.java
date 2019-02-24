/*
Item class
Creates weapons and potions to be used
*/

public abstract class Item
{
    protected String name;     // Item name
    protected int ident;       // Identification of Item(1. Weapon, 2. Potion)
    
    /**
     * Constructor
     * @param name The name of the item
     * @param ident The identification number of item
     */
    
    public Item(String name, int ident)
    {
        this.name = name;
        this.ident = ident;
    }
    
    /**
     * getName method returns the name of the item
     * @return The name of the item
     */
    
    public String getName()
    {
        return name;
    }
    
    /**
     * getIdent method returns the identification number of the item
     * @return The ident integer
     */
    
    public int getIdent()
    {
        return ident;
    }

    /**
     * Abstract method useItem handles what the item does
     * @return The integer
     */
    
    public abstract int useItem();
    
    /**
     * toString method
     * @return A String representation of an Item
     */
    
    public String toString()
    {
        String str = name;
        return str;
    }
}
