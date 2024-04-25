import java.io.File;
import java.util.ArrayList;
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
        FiniteStateMachine<String, String> fsm = new FiniteStateMachine<>();

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
            
            //while there is more information, read it in.
            while (fileReader.hasNext()) 
            {
                String startState = fileReader.next(); //set the first thing to startState
                String edge = fileReader.next(); //next thing to transition
                String endState = fileReader.next(); //last thing to endState
                fsm.addEdge(startState, edge, endState);
            }
            
            while (true) //TODO: Will I lose points if I do it this way?
            {
            
                /* Start State */
                System.out.println("Enter a start state (* to end): ");
                String start = input.nextLine();
                if (start.equals("*")) break; //kinda cool that this works.

                /* Edge State
                System.out.println("\nEnter an edge state (* to end): ");
                String edge = input.nextLine();
                if (edge.equals("*")) break; 
                */

                /* Step Sequence */
                System.out.println("Enter a step sequence (seperated with whitespace): ");
                ArrayList<String> allSteps = new ArrayList<>();
                String step = input.nextLine().trim();

                if (!step.equals("")) 
                {
                    if (step.equals("*")) break;
                    String[] steps = step.split("\\s+");
                    for (String s : steps)
                    allSteps.add(s);
                }

                /* Method Calls */

                if (fsm.findEndState(start, allSteps) == null)  
                {
                    System.out.println("ILLEGAL SEQUENCE");
                }
                else 
                {      
                    //System.out.println(fsm.getAdjacentState(start, edge));
                    //System.out.println(fsm.getAllAdjacentStates(start));
                    System.out.println("End State: " + fsm.findEndState(start, allSteps));
                }
            }
            input.close();
            fileReader.close();
        }

        catch (FileNotFoundException e) 
        {
            System.out.println("File not found, please try again.\n");
            main(args);
            input.close();
            return;
        }
    }
}