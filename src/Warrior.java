import java.util.Scanner;

public class Warrior extends Player
{
    protected int rage;          // Ability points Warrior has
    
    /**
     * Constructor
     * @param n The warriors name
     * @param hlth The warriors health
     * @param str The warriors strength
     * @param dex The warriors dexterity
     * @param intel The warriors intelligence
     * @param ac The warriors armor class
     * @param r The warriors rage amount
     * @param alive Player alive true/false
     */
    
    public Warrior(String n, int hlth, int str, int dex, int intel, int ac, 
                   int r, boolean alive)
    {
        super(n, hlth, str, dex, intel, ac, alive);
        rage = r;
    }
    
    /**
     * Warriors display
     * @return A reference to a String
     */
    
    @Override
    public String getHUD()
    {
        String str = "------------------------------------------------\n" + 
                "Health: " + super.health + "\t\t Class: Warrior" +
                "\nRage: " + rage + "\t\t\t Inventory Space: " + 
                super.backpack.size() +
                " / 10\n" +
                "------------------------------------------------";
        
        return str;
    }
    
    /**
     * The Warriors battle display
     */
    
    @Override
    public void battleHUD()
    {
        System.out.println("------------------------------\n" + "\t    ~BATTLE~\n"
                + "     Health: " + health + " ~ Rage: " + rage +
                "\n---------------\\/-------------");
    }
    
    /**
     * playerMeleeAttack method overrides method from Player
     * @param enemy The enemy to do damage to
     */
    
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
            
            increaseRage();
        }
        // Normal hit. Subtract enemy acModifier from damage
        else if (acRoll >= enemy.armorClass)
        {
            damage = equipped.useItem() + strModifier - enemy.acModifier;
            System.out.println(" + " + strModifier + " added for Strength modifier");
            System.out.println("~You did " + damage + 
                        " damage");
            
            increaseRage();
        }
        // Miss enemy
        else 
            System.out.println("You missed!");

        enemy.health -= damage;     // Subtract health from enemy
        
        // Enemy's health is 0 or less
        if (enemy.health <= 0)
            System.out.println("You killed a " + enemy.getName() + ".");
    }
    
    /**
     * specialAttacks method sets the Warriors special attacks
     * @param p The player character
     * @param e The enemy to do special attack on
     */
    
    @Override
    public void specialAttacks(Player p, Enemy e)
    {
        String input;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("1. Heavy Strike\n2. Slam\n> ");
        input = keyboard.nextLine();
        switch (input)
        {
            case "1":
                if (rage >= 3)
                    heavyStrike(e);
                else
                    System.out.println("You dont have enough rage!");
                break;
            case "2":
                System.out.println("Haven't learned this ability yet.");
        }
    }
    
    /**
     * heavyStreak method is a Warriors special attack
     * @param enemy Enemy to do damage to
     */
    
    public void heavyStrike(Enemy enemy)
    {
        int rollDamage = super.equipped.useItem();    // Weapon damage
        int specAtkDmg = 5;                             // Special atk damage
        int critDamage;                                 // Critical damage
        int totalDmg = rollDamage + specAtkDmg;         // Total damage
        
        // Roll for hit check
        int checkHit = Dice.RollTwentySided();
        
        // Critical Hit
        if (checkHit == 20)
        {
            critDamage = 5;
            enemy.health -= (totalDmg + critDamage);
            System.out.println("Heavy Strike was a critical hit!");
            System.out.println("You did " + totalDmg + " damage!");
        }
        
        // Normal special attack hit
        else if (checkHit >= enemy.dexterity)
        {
            enemy.setHealth(totalDmg);
            System.out.println("Heavy Strike did " + totalDmg + " damage.");
        }
        
        // Miss
        else
            System.out.println("Heavy Strike missed!");
        
        rage -= 3;      // Rage used for special attack
    }
    
    public void slam(Enemy enemy)
    {
        
    }
    
    /**
     * increaseRage method will increase Warriors rage by 1 
     */
    
    public void increaseRage()
    {
        if (rage < 5)
            rage++;
    }
    
    /**
     * toString method returns a string about the warrior
     * @return A reference to a String about Warrior
     */
    
    @Override
    public String toString()
    {
        String str;
        
        str = "Class: Warrior\n" + super.toString();
        
        return str;
    }
}