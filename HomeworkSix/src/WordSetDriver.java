import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException ;

/**
 * @author Owen McGrath
 * @version 04/04/2024
 * Reads a user file in and throws an error if it is not found, reads all of the content, and then prints out the formatted string.
 */
public class WordSetDriver 
{

    /**
     * @param args
     * @throws Exception
     * Main method that instaties the tree, asks the user for a file, and then prints output if a file is found.
     */
    public static void main(String[] args) throws Exception
    {
        WordSet tree = new WordSet();

        Scanner input = new Scanner(System.in); 
        System.out.println("\nPlease input the file name that you would like to read in: ");
        String filename = input.nextLine();
        filename.toLowerCase();
        
        try 
        {
            File inputFile = new File(filename);
            Scanner fileReader = new Scanner(inputFile);
            while (fileReader.hasNext()) 
            {
                tree.add(fileReader.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("\n" + "File not found, please try again.\n");
            main(args);
            return;
        }

        /* Unit Testing (Adding) */
        //System.out.println(tree.add("HEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEH")); //-- new word
        //System.out.println(tree.add("above")); //-- duplicate
        //System.out.println(tree.add("--")); //-- should be removed

        System.out.println("\n");
        System.out.println("There are " + tree.size() + " unique words in the tree");
        System.out.println("The longest word is '" + tree.getLongest() + "' with " + tree.getLongest().length() + " letters. \n");
        System.out.println("-------------------------------------------------------------------------------- \n");
        System.out.println(tree.toString());

        /* Unit Testing (T/F) */
        //System.out.println(tree.add("HEHEHEHEHEHEHEHEHEHEHEHEHEHEHEHEH")); //-- new word
        //System.out.println(tree.add("above")); //-- duplicate (lincoln.txt)
        //System.out.println(tree.add("--")); //-- should be removed in its entirety

    }

}
