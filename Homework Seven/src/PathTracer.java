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
        FiniteStateMachine fsm = new FiniteStateMachine<>();

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
            
            while (fileReader.hasNext()) 
            {
                String startState = fileReader.next();
                String transition = fileReader.next();
                String endState = fileReader.next();
                fsm.addEdge(startState, transition, endState);
            }

            while (true) //is this okay!?!?!??!?!?!?!?!?
            {
            
                /* Start State */
                System.out.println("\nEnter a start state (* to end): ");
                String start = input.nextLine();
                if (start.equals("*")) break;

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
                System.out.println("\nAdjacent State: " + fsm.getAdjacentState(start, edge));
                System.out.println("All Adjacent States: " + fsm.getAllAdjacentStates(start));            
                System.out.println("End State: " + fsm.findEndState(start, allSteps));
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
