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
        System.out.println("\nEnter FSM file: ");
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

            System.out.println(fsm.toString());
            while (true) //TODO: Is it okay for me to perform an infinite loop here?
            {
            
                /* Start State */
                System.out.println("\nEnter a start state (* to end): ");
                String start = input.nextLine();
                if (start.equals("*")) break; //kinda cool that this works.

                /* Step Sequence */
                System.out.println("\nEnter a step sequence (seperated with whitespace): ");
                ArrayList<String> allSteps = new ArrayList<>();
                if (input.hasNext()) 
                {
                    String step = input.nextLine();
                    if (step.equals("*")) break;
                    String[] steps = step.split(" ");
                    for (String s : steps)
                    allSteps.add(s);
                }
                
                
                /* Edge State */
                System.out.println("\nEnter an edge state: ");
                String edge = input.nextLine();
                if (edge.equals("*")) break;
                

                /* Method Calls */

                if (fsm.findEndState(start, allSteps) == null || fsm.getAdjacentState(start, edge) == null || fsm.getAllAdjacentStates(start) == null)  
                {
                    System.out.println("\nILLEGAL SEQUENCE"); //TODO: Which output would you like? does it matter?
                }
                else 
                {
                    System.out.println("\nAdjacent State: " + fsm.getAdjacentState(start, edge));
                    System.out.println("All Adjacent States: " + fsm.getAllAdjacentStates(start));            
                    System.out.println("End State: " + fsm.findEndState(start, allSteps));
                }

            }
            input.close();
            fileReader.close();
        }

        catch (FileNotFoundException e) 
        {
            System.out.println("\n" + "File not found, please try again.\n");
            main(args);
            input.close();
            return;
        }
    
    }

}
