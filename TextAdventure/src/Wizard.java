
public class Wizard extends Player
{
    protected int mana;
    
    public Wizard(String n, int hlth, int str, int dex, int intel, int ac, 
            int m, boolean alive)
    {
        super(n, hlth, str, dex, intel, ac, alive);
        mana = m;
    }
    
    @Override
    public String getHUD()
    {
        String str = "------------------------------------------------\n" + 
                "Health: " + super.health + "\t\t Class: Wizard" +
                "\nMana: " + mana + "\t\t\t Inventory Space: " + 
                super.backpack.size() +
                " / 10\n" +
                "------------------------------------------------";
        
        return str;
    }
    
    @Override
    public void battleHUD()
    {
        System.out.println("------------------------------\n" + "\t    ~BATTLE~\n"
                + "     Health: " + health + " ~ Mana: " + mana +
                "\n---------------\\/-------------");
    }
    
    @Override
    public void playerMeleeAttack(Enemy enemy)
    {
        int damage = 0;                 // The players damage

        int acRoll = Dice.RollTwentySided();  // Roll for armor class of enemy
        
        // Roll for critical hit
        if (acRoll == 20)
        {
            damage = equipped.useItem() + strModifier + 5;
            System.out.println(" + " + strModifier + " added for Strength"
                    + " modifier. + 5 for a critical hit...");

            System.out.println("~Critical hit! You did " + damage +
                                " damage!");
        }
        // Normal hit. Subtract enemy acModifier from damage
        else if (acRoll >= enemy.armorClass)
        {
            damage = equipped.useItem() + strModifier - enemy.acModifier;
            System.out.println(" + " + strModifier + " added for Strength modifier");
            System.out.println("~You did " + damage + 
                        " damage");
        }
        // Miss enemy
        else 
            System.out.println("You missed!");

        enemy.health -= damage;     // Subtract health from enemy
        
        // Enemy's health is 0 or less
        if (enemy.health <= 0)
            System.out.println("You killed a " + enemy.getName() + ".");
        
        mana += 15;
    }
    
    @Override
    public void specialAttacks(Enemy enemy)
    {
        
    }
}
