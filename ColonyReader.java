// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Stephen Ye (stepheny)
package spacecolonies;
import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

/**
 * This class reads in a file and creates a colony calculator.
 * @author stephenye
 * @version 2022.11.08
 *
 */
public class ColonyReader {

    private Planet[] planets;
    private ArrayQueue<Person> queue;

    /**
     * creates a colonyreader object and sets its values
     * @param applicantFileName contains the information of a person
     * @param planetFileName contains the information of a planet
     * @throws java.text.ParseException if the file is not formatted correctly
     * @throws FileNotFoundException if the file is not found
     * @throws SpaceColonyDataException if the file wansn't valid in a colony
     */
    public ColonyReader(String applicantFileName,String planetFileName)
        throws java.text.ParseException, 
        FileNotFoundException, SpaceColonyDataException {
            planets = readPlanetFile(planetFileName);
            queue = readQueueFile(applicantFileName);
            ColonyCalculator calc = new ColonyCalculator(queue, planets);

    }

    /**
     * determines whether values are possible skill values
     * @param num1 the first number to be checked
     * @param num2 the second number to be checked
     * @param num3 the third number to be checked
     * @return boolean true if the numbers are possible skill values, false if not
     */
    private boolean isInSkillRange(int num1, int num2, int num3){
        if (num1 >= 1 && num1 <= 5 && num2 >= 1 && num2 <= 5 && num3 >= 1 && num3 <= 5){
            return true;
        }
        return false;

    }

   
    

    /**
     * determines the nessasary actions using the information 
     * from a planet's file
     * @param fileName the file where the information comes from
     * @return Planet[] the list of planets 
     * @throws java.text.ParseException if the file is not formatted correctly
     * @throws FileNotFoundException if the file is not found
     * @throws SpaceColonyDataException if the file wansn't valid in a colony
     */
    private Planet[] readPlanetFile(String fileName) throws FileNotFoundException,
        SpaceColonyDataException, java.text.ParseException{ 
            Planet[] ordered = new Planet[3];
            ordered = planets;
            Scanner scan = new Scanner(new File(fileName));
            for (int i = 0; i < 3 && scan.hasNextLine(); i++){
                String[] line = scan.nextLine().split(",");
                if (line.length != 5) {
                    throw new ParseException(fileName, i + 1);
                }

                int agriculture = Integer.parseInt(line[1]);
                int medicine = Integer.parseInt(line[2]);
                int technology = Integer.parseInt(line[3]);
                int population = Integer.parseInt(line[4]);

                if (!isInSkillRange(agriculture, medicine, technology)){
                    throw new SpaceColonyDataException("go to school");
                }
                planets[i] = new Planet(line[0], agriculture, medicine, technology, population);
            }
            scan.close();

            if (planets[2] == null){
                throw new SpaceColonyDataException("get to med school");
            }
            return planets;
        }
    
    /**
     * determines the actions needed using the infrmation on a person
     * @param fileName the file providing the information
     * @return ArrayQueue<Person> the queue of people
     * @throws java.text.ParseException if the file is not formatted correctly
     * @throws FileNotFoundException if the file is not found
     * @throws SpaceColonyDataException if the file wansn't valid in a colony
     */
    private ArrayQueue<Person> readQueueFile(String fileName) throws FileNotFoundException,
    SpaceColonyDataException, java.text.ParseException{
    
    
        
        ArrayQueue<Person> queue = new ArrayQueue<Person>(20);
        Scanner scan = new Scanner(new File(fileName));

        while (scan.hasNextLine()) {
            String[] data = scan.nextLine().split(",");
            for (int i = 0; i < data.length; i++){
                if (data[i] == null || data[i].equals("")) {
                    scan.close();
                    throw new SpaceColonyDataException("go to school");
                }
        }
        if (!isInSkillRange(Integer.valueOf(data[1]), Integer.valueOf(data[2]), Integer.valueOf(data[3]))) {
            throw new SpaceColonyDataException("not in skill range");
        }
    }
        
    scan.close();
    return queue;
    }
        

}





