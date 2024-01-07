// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

import student.TestCase;

/**
 * tests the person class
 * @author stephenye
 * @version 2022.11.08
 *
 */
public class PersonTest extends TestCase {

    private Person person1;
    private Person person2;
    

    /**
     * sets up the tests that follow.
     */
    public void setUp() {
        person1 = new Person("bob", 1, 2, 3, "Uranus");
        
        person2 = new Person("bob", 1, 2, 3, "");
        
    }

    /**
     * tests the getPlanetPreference method.
     */
    public void testGetPlanetPreference() {
        assertEquals("Uranus", person1.getPlanetPreference());
    }
    
    /**
     * tests the toString method.
     */
    public void testToString() {
        assertEquals("bob A:1 M:2 T:3 Wants:Uranus", person1.toString());
        assertEquals("No-Plane bob A:1 M:2 T:3", person2.toString());
        
    }
    
    /**
     * tests the equals method.
     */
    public void testEquals() {
        Person n = null;
        assertFalse(person1.equals(n));
        String a = "a";
        assertFalse(person1.equals(a));
        
        assertTrue(person1.equals(person1));
        assertFalse(person1.equals(person2));
        
    }
    
    /**
     * tests the getter methods
     */
    public void testGetters()
    {
        assertEquals("bob", person1.getName());
        Skillset skills = new Skillset(1, 2, 3);
        assertEquals(skills, person1.getSkills());
        
    }
    

}
