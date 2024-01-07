// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

/**
 * creates the exception for when a item isn't valid as a planet or person
 * @author stephenye
 * @version 2022.11.08
 *
 */
@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {

    /**
     * the message shown for the exception
     * @param string the message
     */
    public SpaceColonyDataException(String string)
    {
        super(string);
    }

}
