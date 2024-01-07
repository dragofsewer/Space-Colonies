// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

import student.TestCase;

/**
 * This class tests the ArrayQueue class.
 * @author stephenye
 * @version 2022.11.08
 *
 */
public class ArrayQueueTest extends TestCase {

    private ArrayQueue<Person> queue1;
    private ArrayQueue<Person> queue2;

    /**
     * Sets up the tests that follow.
     */
    public void setUp() {
        queue1 = new ArrayQueue<Person>(1);
        queue2 = new ArrayQueue<Person>(5);
        queue2.enqueue(new Person("bob", 1, 2, 3, "Uranus"));
    }

    /**
     * Tests the getSize method.
     */
    public void testGetSize() {
        assertEquals(0, queue1.getSize());
        assertEquals(1, queue2.getSize());
    }
    
    /**
     * Tests the getLengthOfUnderlyingArray method.
     */
    public void testGetLengthOfUnderlyingArray() {
        assertEquals(2, queue1.getLengthOfUnderlyingArray());
        assertEquals(6, queue2.getLengthOfUnderlyingArray());
    }
    
    /**
     * tests the clear method.
     */
    public void testClear() {
        queue1.clear();

        assertEquals(0, queue1.getSize());

        
    }
    
    /**
     * tests the toArray method.
     */
    public void testToArray() {
        
        
        Object[] array1 = new Object[1];
        

        Exception thrown = null;
        try 
        {
            array1 = queue1.toArray();
        }
        catch (Exception e) 
        {
            thrown = e;
        }
        assertEquals(1, array1.length);
        queue1.enqueue(new Person("bob", 1, 2, 3, "Uranus"));
        Object[] array2 = new Object[1];
        array2 = queue1.toArray();
        assertEquals(1, array2.length);

        
    }
    
    /**
     * tests the toString method.
     */
    public void testToString() {
        assertEquals("[]", queue1.toString());
        assertEquals("[null, ]", queue2.toString());
    }
   
    
    /**
     * tests the equals method.
     */
    public void testEqual() {
        ArrayQueue<Person> n = null;
        assertFalse(queue1.equals(n));
        String a = "a";
        assertFalse(queue1.equals(a));
        assertTrue(queue1.equals(queue1));
        assertFalse(queue1.equals(queue2));
        queue1.enqueue(new Person("joe", 0, 0, 0, "Mars"));
        assertFalse(queue1.equals(queue2));
        queue2.clear();
        queue1.clear();
        queue2.enqueue(new Person("bob", 1, 2, 3, "Uranus"));
        queue1.enqueue(new Person("bob", 1, 2, 3, "Uranus"));
        assertTrue(queue1.equals(queue2));
    }
    
    /**
     * tests the dequeue method.
     */
    public void testDequeue() {
        Exception thrown = null;
        try 
        {
            queue1.dequeue();
        }
        catch (Exception e) 
        {
            thrown = e;
        }
        assertNotNull(thrown);

        queue2.dequeue();
        assertEquals(0, queue2.getSize());

    }
    
    

    /**
     * tests the getFront method.
     */
    public void testGetFront() {
        Exception thrown = null;
        try 
        {
            queue1.getFront();
        }
        catch (Exception e) 
        {
            thrown = e;
        }
        assertNotNull(thrown);
        
        queue1.enqueue(new Person("joe", 0, 0, 0, "Mars"));
        assertEquals("joe", queue1.getFront().getName());
        
    }
    
    /**
     * tests the isEmpty method.
     */
    public void testIsEmpty() {
        queue1.clear();
        assertTrue(queue1.isEmpty());
        assertFalse(queue2.isEmpty());
    }
    
    /**
     * tests the ensure capacity method
     */
    public void testEnsureCapacity() {
        queue1.enqueue(new Person("joe", 0, 0, 0, "Mars"));
        queue1.enqueue(new Person("joe", 0, 0, 0, "Mars"));
        assertEquals(3, queue1.getLengthOfUnderlyingArray());
    }
   

    


}