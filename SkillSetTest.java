// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

import student.TestCase;

/**
 * This class tests the SkillSet class.
 * @author stephenye
 * @version 2022.11.08
 */
public class SkillSetTest extends TestCase {

    private Skillset skill1;
    private Skillset skill2;
    private Skillset skill3;
    private Skillset skill4;

    /**
     * sets up the tests that follow.
     */
    public void setUp() {
        skill1 = new Skillset(1, 2, 3);
        skill2 = new Skillset(1, 2, 3);
        skill3 = new Skillset(2, 3, 4);
        skill4 = new Skillset(0, 0, 0);
    }

    /**
     * tests the isLessThanOrEqualTo method
     */
    public void testIsLessThanOrEqualTo() {
        assertTrue(skill1.isLessThanOrEqualTo(skill2));
        assertTrue(skill1.isLessThanOrEqualTo(skill3));
        assertTrue(skill4.isLessThanOrEqualTo(skill1));
        assertFalse(skill3.isLessThanOrEqualTo(skill1));
    }
    
    /** 
     * tests the equals method
     */
    public void testEquals() {
        Skillset n = null;
        assertFalse(skill1.equals(n));
        String a = "a";
        assertFalse(skill1.equals(a));
        assertTrue(skill1.equals(skill2));
        assertFalse(skill1.equals(skill3));
        assertFalse(skill1.equals(skill4));
    }
    
    /**
     * tests the compareTo method
     */
    public void testCompareTo() {
        assertEquals(0, skill1.compareTo(skill2));
        assertEquals(1, skill1.compareTo(skill4));
        assertEquals(-1, skill4.compareTo(skill1));
    }
    
    /**
     * tests the getter methods
     */
    public void testGetters() {
        assertEquals(1, skill1.getAgriculture());
        assertEquals(2, skill1.getMedicine());
        assertEquals(3, skill1.getTechnology());
    }
    
    /**
     * tests the toString method
     */
    public void testToString() {
        assertEquals("A:1 M:2 T:3", skill1.toString());
    }

}
