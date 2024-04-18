import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException ;

/**
 * @author Owen McGrath
 * @version 04/18/2024
 * Reads a user file in and throws an error if it is not found, reads all of the content, and then prints out the formatted string.
 */
public class PathTracer 
{

    /**
     * @param args
     * @throws Exception
     * Main method that instaties the tree, asks the user for a file, and then prints output if a file is found.
     */
    public static void main(String[] args) throws Exception
    {
        FiniteStateMachine fsm = new FiniteStateMachine<>();

        //prompting user for file, setting it to lowercase.
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter FSM file: ");
        String filename = input.nextLine();
        filename = filename.toLowerCase();
        
        //if the file is found, read it in.
        try 
        {
            File inputFile = new File(filename);
            Scanner fileReader = new Scanner(inputFile);
            
            while (fileReader.hasNext()) 
            {
                String startState = fileReader.next();
                String transition = fileReader.next();
                String endState = fileReader.next();
                fsm.addEdge(startState, transition, endState);
            }

            System.out.println("Enter a start state (* to end): ");
            String start = input.nextLine();

            //System.out.println("Enter a step sequence (seperated with whitespace): ");
            //String step = input.nextLine();
            
            //System.out.println("Enter an edge state: ");
            //String edge = input.nextLine();

            //System.out.println(fsm.getAdjacentState(start, edge));
            System.out.println(fsm.getAllAdjacentStates(start));            

            ///fsm.findEndState(startState, step);

        //otherwise throw an error and have them try again using recursion
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("\n" + "File not found, please try again.\n");
            main(args);
            return;
        }
    
    }

}
