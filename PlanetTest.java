// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

import java.util.Arrays;
import student.TestCase;

/**
 * this class tests the planet class.
 * @author stephenye
 * @version 2022.11.08
 *
 */
public class PlanetTest extends TestCase {

    private Planet planet1;
    private Planet planet2;

    /**
     * sets up the tests that follow.
     */
    public void setUp() {
        planet1 = new Planet("Uranus", 1, 2, 3, 4);
        planet2 = new Planet("Uranus", 1, 2, 3, 4);
        planet1.addPerson(new Person("bob", 1, 2, 3, "Uranus"));
    }

    /**
     * tests the getter methods
     */
    public void testGetter() {
        assertEquals(3, planet1.getAvailability());
        assertEquals("Uranus", planet1.getName());
        Skillset skill = new Skillset(1, 2, 3);
        assertEquals(skill, planet1.getSkills());
        Person[] person = new Person[4];
        person[0] = new Person("bob", 1, 2, 3, "Uranus");
        assertTrue(Arrays.equals(person, planet1.getPopulation()));
        assertEquals(1, planet1.getPopulationSize());
        assertEquals(4, planet1.getCapacity());
        

    }

    /**
     * tests the isFull method
     */
    public void testIsFull() {
        assertFalse(planet1.isFull());
        planet1.addPerson(new Person("bob", 1, 2, 3, "Uranus"));
        planet1.addPerson(new Person("bob", 1, 2, 3, "Uranus"));
        planet1.addPerson(new Person("bob", 1, 2, 3, "Uranus"));
        assertTrue(planet1.isFull());
    }
    
    /** 
     * tests the addPerson method
     */
    public void testAddPerson() {
        planet1.addPerson(new Person("bob", 1, 2, 3, "Uranus"));
        planet1.addPerson(new Person("bob", 1, 2, 3, "Uranus"));
        planet1.addPerson(new Person("bob", 1, 2, 3, "Uranus"));
        assertFalse(planet1.addPerson(new Person("bob", 1, 2, 3, "Uranus")));

    }
    
    /**
     * tests the toString method
     */
    public void testToString() {
        assertEquals("Uranus, population 1 (cap: 4), "
            + "Requires: A >= 1, M >= 2, T >= 3", planet1.toString());
    }
    
    /**
     * tests the equals method
     */
    public void testEquals() {
        Planet n = null;
        assertFalse(planet1.equals(n));
        String a = "a";
        assertFalse(planet1.equals(a));
        assertTrue(planet1.equals(planet1));
        assertFalse(planet1.equals(planet2));
    }
    
    /**
     * tests the compareTo method
     */
    public void testCompareTo() {
        assertEquals(1, planet1.compareTo(planet2));
        planet2.addPerson(new Person("bob", 1, 2, 3, "Uranus"));
        assertEquals(0, planet1.compareTo(planet2));
        planet2.addPerson(new Person("bob", 1, 2, 3, "Uranus"));
        assertEquals(-1, planet1.compareTo(planet2));
    }
    
    /** 
     * tests the setName method
     */
    public void testSetName() {
        planet1.setName("Earth");
        assertEquals("Earth", planet1.getName());
    }
    
    /**
     * tests the isQualified method
     */
    public void testIsQualified() {
        Person person = new Person("bob", 1, 1, 1, "Uranus");

        assertFalse(planet1.isQualified(person));
    }
    
    
    
    







}
