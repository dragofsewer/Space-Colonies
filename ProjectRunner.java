// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;

import java.io.FileNotFoundException;

/**
 * thsi class runs the project in a different way depending on what was inputted
 * @author stephenye
 * @version 2022.11.08
 *
 */
public class ProjectRunner {

    /**
     * empty constructor
     */
    public ProjectRunner() {

        // intentionally left blank
    }

    /**
     * determines which way to run the project
     * @param args the array of strings that determines how the project will run
     * @throws java.text.ParseException if the file is not formatted correctly
     * @throws FileNotFoundException if the file is not found
     * @throws SpaceColonyDataException if the file wansn't valid in a colony
     */
    public static void main(String[] args)throws FileNotFoundException,
    SpaceColonyDataException, java.text.ParseException {
        if (args.length == 2)
        {
            ColonyReader reader = new ColonyReader(args[0], args[1]);
        }
        else
        {
            ColonyReader reader = new ColonyReader("input.txt", "planets.txt");
        }

    }
}
