// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

/**
 * This class sets up the SkillSet of a 
 * person which will be used in other classes
 * to determine their ability to enter a 
 * planet
 * @author stephenye
 * @version 2022.11.08
 *
 */
public class Skillset implements Comparable<Skillset> {

    
    private int agriculture;
    private int medicine;
    private int technology;
    
    /**
     * creates a SkillSet object and gives it the
     * necessary properties
     * @param ag the value of agriculture skill
     * @param med the value of medicine skill
     * @param tech ghe value of technology skill
     */
    public Skillset(int ag, int med, int tech)
    {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }
    
    /**
     * determines if one skillset contains a 
     * lower skill than another in any of the 
     * three categories 
     * @param other the skillset that is being used 
     * for comparision
     * @return boolean if the skillset contains a lower
     * skill value than another
     */
    public boolean isLessThanOrEqualTo(Skillset other)
    {
        return (agriculture <= other.agriculture && medicine <= other.medicine 
            && technology <= other.technology);

    }
    
    /**
     * detrmines if two skillsets are identical
     * @param obj the object being used for comparision
     * @return boolean if the two skillsets are equal
     */
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj.getClass() != this.getClass())
        {
            return false;
        }
        Skillset other = (Skillset) obj;
        return (agriculture == other.agriculture && medicine == other.medicine 
            && technology == other.technology);

        
    }
    
    /**
     * returns -1 if the sum of the skills is 
     * lower than the skillset being used for comparison
     * returns 1 if the sum of the skills is 
     * greater than the skillset being used for comparison
     * returns 0 if the sum of the skills is 
     * equal to the skillset being used for comparison
     * @param skills the skillset being used for comparision
     * @return int the value that have the above meanings
     */
    public int  compareTo(Skillset skills)
    {
        int total = skills.agriculture + skills.medicine + skills.technology;
        int total2 = agriculture + medicine + technology;
        if (total2 > total)
        {
            return 1;
        }
        else if (total2 < total)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    
    /**
     * returns the value of the agriculture skill
     * @return int the vlaue of the agriculture skill
     */
    public int getAgriculture()
    {
        return agriculture;
        
    }
    
    /**
     * returns the value of the medicine skill
     * @return int the value of the medicine skill
     */
    public int getMedicine()
    {
        return medicine;
        
        
    }
    
    /**
     * returns the value of the technology skill
     * @return int the value of the technology skill
     */
    public int getTechnology()
    {
        return technology;
        
        
    }
    
    /**
     * returns the string with information of a skillset
     * @return String the string with the information
     */
    public String toString()
    {
        return "A:" + agriculture + " M:" + medicine + " T:" + technology;
        
        
    }

}
