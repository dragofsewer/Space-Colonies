// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

import student.TestCase;

/**
 * This class tests the colony calculator class.
 * @author stephenye
 * @version 2022.11.08
 *
 */
public class ColonyCalculatorTest extends TestCase {

    private ColonyCalculator calc;
    private Person person1;
    private ArrayQueue<Person> queue;
    private Planet planet1;
    private Planet planet2;
    private Planet planet3;
    private Planet[] planets;


    /**
     * sets up the tests that follow.
     */
    public void setUp() {
        person1 = new Person("bob", 1, 2, 3, "Uranus");
        queue = new ArrayQueue<Person>(1);
        queue.enqueue(person1);
        planet1 = new Planet("Uranus", 1, 2, 3, 4);
        planet2 = new Planet("Mars", 1, 2, 1, 4);
        planet3 = new Planet("Earth", 1, 2, 3, 4);
        planets = new Planet[3];
        planets[0] = planet1;
        planets[1] = planet2;
        planets[2] = planet3;
        calc = new ColonyCalculator(queue, planets);
    }
    
    
    /**
     * tests the getPlanetForPerson method.
     */
    public void testGetPlanetForPerson() {
        Person personNull = null;
        assertEquals(null, calc.getPlanetForPerson(personNull));
        Planet uranus = new Planet("Uranus", 1, 2, 3, 4);
        assertEquals(uranus, calc.getPlanetForPerson(person1));
        Person person2 = new Person("bob", 1, 2, 1, "Uranus");
        assertEquals(planet2, calc.getPlanetForPerson(person2));
        
        assertFalse(planet1.equals(calc.getPlanetForPerson(person2)));
        assertFalse(planet2.equals(calc.getPlanetForPerson(person2)));
    }
    
    /**
     * tests the accept method.
     */
    public void testAccept() {
        assertTrue(calc.accept());
        Person person2 = new Person("bob", 1, 2, 3, "Neptune");
        assertFalse(calc.accept());
        Person person3 = new Person("bob", 3, 3, 3, "Mars");
        assertFalse(calc.accept());
    }
    
    /**
     * tests the reject method.
     */
    public void testReject() {
        calc.reject();
        assertEquals(0, queue.getSize());
        Exception thrown = null;
        try 
        {
            calc.reject();
        }
        catch (Exception e) 
        {
            thrown = e;
        }
        assertNotNull(thrown);
        
    }
    
    /**
     * tests the getPlanetIndex method.
     */
    public void testGetPlanetIndex() {
        String bad = null;

        assertEquals(0, calc.getPlanetIndex("Uranus"));
        assertEquals(-1, calc.getPlanetIndex("Neptune"));
        Exception thrown = null;
        try 
        {
            calc.getPlanetIndex(bad);
        }
        catch (Exception e) 
        {
            thrown = e;
        }
        assertNotNull(thrown);
        
    }
    
    /**
     * tests the getQueue method.
     */
    public void testGetQueue() {
        assertEquals(queue, calc.getQueue());
    }
    
    /**
     * tests the getPlanet method.
     */
    public void testGetPlanets() {
        assertEquals(planets, calc.getPlanets());
    }
    
    



}
