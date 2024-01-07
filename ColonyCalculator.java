// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

import list.AList;
import queue.EmptyQueueException;

/**
 * this class calculates the best planet
 *  for each person in the queue using 
 *  the information from the planet queue
 * @author stephenye
 * @version 2022.11.08
 *
 */
public class ColonyCalculator {

    /**
     * number of planets
     */
    static final int NUM_PLANETS = 3;
    /**
     * minimum skill level
     */
    static final int MIN_SKILL_LEVEL = 1;
    /**
     * max skill level
     */
    static final int MAX_SKILL_LEVEL = 5;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private Planet[] planets;

    /**
     * creates the colony calculator object
     * @param queue the people trying to get into a planet
     * @param planets the list of planets
     */
    public ColonyCalculator(ArrayQueue<Person> queue, Planet[] planets) {

        this.applicantQueue = queue;
        this.planets = planets;
        rejectBus = new AList<Person>();
        if (queue == null) {
            throw new IllegalArgumentException();
        }

    }
    

    /**
     * whether or not a person can be added to a planet
     * @param person the person trying to get into a planet
     * @param planet the planet the person is trying to get into
     * @return boolean true if the person can be 
     * added to the planet, false if not
     */
    private boolean canAccept(Planet planet, Person person) {
        if (planet == null || person == null) {
            throw new IllegalArgumentException();
        }
        return (planet.isQualified(person) && !planet.isFull());
        

    }

    /**
     * returns the planet with the highest 
     * capacity that a person can be added to
     * @param person the person trying to get into a planet
     * @return Planet the planet with the highest capacity
     */
    private Planet getHighestCapacityPlanet(Person person) {
        if (person == null) {
            throw new IllegalArgumentException();
        }
        Planet highest = null;
        for (int i = 0; i < planets.length; i++) {
            if (canAccept(planets[i], person)) {
                if (highest == null) {
                    highest = planets[i];
                } 
                else if (planets[i].getAvailability() 
                    > highest.getAvailability()) {
                    highest = planets[i];
                }
            }
        }
        return highest;


    
    }

    /**
     * returns the planet that a person will be added to
     * @param nextPerson the person trying to get into a planet
     * @return Planet the planet the person will be added to
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null) {
            return null;
        }

        for (int i = 0; i < planets.length; i++) {
            if (nextPerson.getPlanetPreference().equals(planets[i].getName())) {
                if (canAccept(planets[i], nextPerson)) {
                    return planets[i];
                }
            }
        }
        return getHighestCapacityPlanet(nextPerson);
    }
            
            

    /**
     * whether or not a person can be added to a planet
     * @return boolean true if the person can be
     */
    public boolean accept() {
        if (applicantQueue.isEmpty()) {
            return false;
        }
        Person nextPerson = applicantQueue.dequeue();
        Planet planet = getPlanetForPerson(nextPerson);
        if (planet != null) {
            planet.addPerson(nextPerson);
            return true;
        }
        else {
            
            return false;
        }

    }

    /**
     * preforms the actions needed when a person cannot be added to a planet
     */
    public void reject()  {
        
        Person nextPerson = applicantQueue.dequeue();
        rejectBus.add(nextPerson);

    }

    /**
     * find the index of a planet in the planet array
     * @param planet the planet to be found
     * @return int the index of the planet in the planet array
     */
    public int getPlanetIndex(String planet)  {
        if (planet == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < planets.length; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return -1;


    }

    /**
     * returns the queue of people applying to get into a planet
     * @return ArrayQueue<Person> the queue 
     * of people applying to get into a planet
     */
    public ArrayQueue<Person> getQueue()  {
        return applicantQueue;


    }

    /**
     * returns the list of planets
     * @return Planet[] the list of planets
     */
    public Planet[] getPlanets() {
        return planets;


    }

}
