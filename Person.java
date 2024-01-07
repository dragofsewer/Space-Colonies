// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

/**
 * This class represents a person.
 * @author stephenye
 * @version 2022.11.08
 *
 */
public class Person extends Skillset {
    
    private String name;
    private Skillset skills;
    private String planetPreferance;
    
    /**
     * This is the constructor for the person class.
     * @param name the name of the person
     * @param agri the value of the agriculture skill
     * @param tech the value of the technology skill
     * @param medi the value of the medicine skill
     * @param planet the planet preferance
     */
    public  Person(String name, int agri, int medi, int tech, String planet)
    {
        super(agri, medi, tech);
        this.skills = new Skillset(agri, medi, tech);
        this.name = name;
        planetPreferance = planet;
        
    }
    
    /**
     * returns the planet preference of the person
     * @return String the planet preference
     */
    public String getPlanetPreference() 
    {
        return planetPreferance;
        
    }
    
    /**
     * returns a string representation of the person
     * @return String a string representation of the person
     */
    public String toString()
    {
        if (planetPreferance.length() > 0)
        {
            return name + " " + skills.toString() + 
                " Wants:" + planetPreferance;
        }
        return "No-Plane " + name + " " + skills.toString() ;
        
    }
    
    /**
     * determines whether two people are equal
     * @param obj the object to be compared with this person
     * @return boolean true if the two people are equal, or false if not
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
        Person other = (Person) obj;
        return (name.equals(other.name) && super.equals(other) 
            && planetPreferance.equals(other.planetPreferance));

        
        
    }
    
    /**
     * returns the name of the person
     * @return String the name of the person
     */
    public String getName()
    {
        return name;
        
        
    }
    
    /**
     * returns the skillset of the person
     * @return Skillset the skillset of the person
     */
    public Skillset getSkills()
    {
        return skills;
        
        
        
    }
    

}
