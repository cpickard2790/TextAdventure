
import java.util.Scanner;


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
            damage = equipped.useItem() + 5;

            System.out.println("~Critical hit! You did " + damage +
                                " damage!");
        }
        // Normal hit. Subtract enemy acModifier from damage
        else if (acRoll >= enemy.armorClass)
        {
            damage = equipped.useItem() - enemy.acModifier;

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
    
    /**
     * specialAttacks method
     * @param p The player character
     * @param e The enemy to do damage to
     */
    
    @Override
    public void specialAttacks(Player p, Enemy e)
    {
        String input;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("1. Lightning Bolt\n2. Fireball\n> ");
        input = keyboard.nextLine();
        switch (input)
        {
            case "1":
                if (mana >= 25)
                {
                    int dexCheck = Dice.RollTwentySided();
                    if (dexCheck > (e.dexterity + e.dexModifier))
                    {
                        lightningBolt(e);
                        if (e.health > 0)
                            e.EnemyAttack(p);
                    }
                    else
                    {
                        e.EnemyAttack(p);
                        if (p.health > 0)
                            lightningBolt(e);
                    }
                    System.out.println();
                }

                else
                    System.out.println("You dont have enough mana!");
                break;
            case "2":
                System.out.println("Haven't learned this ability yet.");
        }
    }
    
    public void lightningBolt(Enemy enemy)
    {
        int rollDamage = Dice.RollEightSided();         // Weapon damage   
        int critDamage;                                 // Critical damage
        int totalDmg = rollDamage + intelModifier;         // Total damage
        
        // Roll for hit check
        int checkHit = Dice.RollTwentySided();
        
        // Critical Hit
        if (checkHit == 20)
        {
            critDamage = 5;
            enemy.health -= (totalDmg + critDamage);
            System.out.println("Lightning Bolt was a critical hit!");
            System.out.println("You did " + totalDmg + " damage!");
        } 
        
        // Normal special attack hit
        else if (checkHit >= enemy.dexterity)
        {
            enemy.setHealth(totalDmg);
            System.out.println("Lightning Bolt did " + totalDmg + " damage.");
        }
        
        // Miss
        else
            System.out.println("Lightning Bolt missed!");
        
        mana -= 25;      // Rage used for special attack
    }
}
