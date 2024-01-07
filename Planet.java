// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

/**
 * this class contains the information and methods for the 
 * planet objects in this project
 * @author stephenye
 * @version 2022.11.08
 *
 */
public class Planet implements Comparable<Planet> {
    
    private String name;
    private Skillset minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;

    /**
     * creates the planet object
     * @param planetName the name of the planet
     * @param planetAgri the minimum skill value of agriculture for this planet
     * @param planetMedi the minimum skill value of medicine for this planet
     * @param planetTech the minimum skill value of technology for this planet
     * @param planetCap the maximum capacity of this planet
     */
    public  Planet(String planetName,  int  planetAgri,  
        int  planetMedi,  int  planetTech,  int  planetCap) {
        name = planetName;
        minSkills = new Skillset(planetAgri, planetMedi, planetTech);
        population = new Person[planetCap];
        populationSize = 0;
        capacity = planetCap;

    }

    /**
     * returns the amount of people still able to be accepted into the planet
     * 
     * @return int the number of spaces left in the planet
     */
    public int getAvailability() {
        return capacity - populationSize;

    }

    /**
     * determines whether or not the planet is at max capacity
     * @return boolean whether of not the planet is at max capacity
     */
    public boolean isFull() {
        return (populationSize == capacity);

    }

    /**
     * determines if a person can be added to and planet
     * and if so adds them
     * @param newbie the person that wants to be added
     * @return boolean whether or not he person was added to the planet
     */
    public boolean addPerson(Person newbie) {
        if (populationSize < capacity && this.isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        return false;


    }

    /**
     * creates a string containing the information of the planet
     * @return String the string with the information of the planet
     */
    public String toString() {
        String result = name + ", population " + populationSize + " (cap: " + 
            capacity + "), Requires: A >= " 
            + minSkills.getAgriculture() + ", M >= "
             + minSkills.getMedicine() + ", T >= " + minSkills.getTechnology();
        return result;

    }

    /**
     * determines if two planets are identical
     * @param obj the object being compared to the planet
     * @return boolean whether or not the two planets are equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Planet other = (Planet) obj;
        return (name.equals(other.name) && minSkills.equals(other.minSkills) && 
            populationSize == other.populationSize 
            && capacity == other.capacity);



    }

    /**
     * returns -1 if papulation size is lower than
     *  the planets population size being used for comparison
     * returns 1 if papulation size is higher than 
     * the planets population size being used for comparison
     * returns 0 if papulation size is equal to the
     *  planets population size being used for comparison
     * @param other the other planet being used for comparision
     * @return int the value with the above meaning
     */
    public int compareTo(Planet other) {
        if (this.populationSize > other.populationSize) {
            return 1;
        }
        else if (this.populationSize < other.populationSize) {
            return -1;
        }
        else {
            return 0;
        }


    }

    /**
     * sets the name of the planet
     * @param name the name
     * 
     */
    public void setName(String name) {
        this.name = name;


    }
    

    /**
     * returns the name of the planet
     * @return String the name of the planet
     */
    public String getName() {
        return name;

    }

    /**
     * returns the values of the minimum skills needed
     * @return SkillSet the minimum skills needed
     */
    public Skillset getSkills() {
        return minSkills;


    }

    /**
     * returns the list of people that are in the planet
     * @return Person[] the array of people living in the planet
     */
    public Person[] getPopulation() {
        return population;


    }

    /**
     * returns the population size
     * @return int the population size
     */
    public int getPopulationSize() {
        return populationSize;

    }

    /**
     *  returns the maximum number of being able to be on the planet
     * @return int the capacity
     */
    public int getCapacity() {
        return capacity;


    }

    /**
     * determines whether or not a person is qualified to join a planet
     * @param person the person trying to get added to a planet
     * @return boolean whether or not the person was accepted
     */
    public boolean isQualified(Person person) {
        return (minSkills.isLessThanOrEqualTo(person.getSkills()));
        
    }




}
