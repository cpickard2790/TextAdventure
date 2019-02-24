/*
Dice class handles rolling different sided dice
*/

import java.util.Random;

public class Dice
{
    /**
     * RollSixSided method rolls a 6 sided dice
     * @return The integer roll
     */
    
    public static int RollSixSided()
    {
        Random rand = new Random();
        int roll = rand.nextInt(6) + 1;

        return roll;
    }
    
    /**
     * RollEightSided method rolls an 8 sided dice
     * @return The roll integer
     */
    
    public static int RollEightSided()
    {
        Random rand = new Random();
        int roll = rand.nextInt(8) + 1;
        
        return roll;
    }
    
    /**
     * RollTenSided rolls a ten sided dice
     * @return The roll integer
     */
    
    public static int RollTenSided()
    {
        Random rand = new Random();
        int roll = rand.nextInt(10) + 1;
        
        return roll;
    }
    
    /**
     * RollTwelveSided rolls a 12 sided dice
     * @return The roll integer
     */
    
    public static int RollTwelveSided()
    {
        Random rand = new Random();
        int roll = rand.nextInt(12) + 1;
        
        return roll;
    }
    
    /**
     * RollTwentySided rolls a 20 sided dice
     * @return The roll integer
     */
    
    public static int RollTwentySided()
    {
        Random rand = new Random();
        int roll = rand.nextInt(20) + 1;
        
        return roll;
    }
}
