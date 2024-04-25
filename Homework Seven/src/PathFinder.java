import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException ;

/**
 * @author Owen McGrath
 * @version 4/18/2024
 * Reads in the user file and then produces output for the methods defined in FiniteStateMachine.java
 */
public class PathFinder {
    @SuppressWarnings("resource") //annoying errors be gone (this is detrminetal to the code.)

    /**
     * @param args
     * @throws Exception
     * Main method that instantiates the fsm, reads in all of the content, and then performs the method calls for finding the edge state and the edgeds along that state 
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
            
            //while the file has more information
            while (fileReader.hasNext()) 
            {
                String startState = fileReader.next();
                String transition = fileReader.next();
                String endState = fileReader.next();
                fsm.addEdge(startState, transition, endState);
            }

            while (true)
            {
                /* Start State */
                System.out.println("Enter a start state (* to end): ");
                String start = input.nextLine();
                if (start.equals("*")) break;
            
                /* End State */
                System.out.println("Enter an end state: ");
                String end = input.nextLine();
            
                try 
                {
                    List<String> path = fsm.findPath(start, end);
                    if (path == null)
                    {
                        System.out.println("NO SUCH PATH");
                    }
                    else 
                    {
                        System.out.println("State Path: " + path);
                        System.out.println("Edge Path: " + fsm.getEdgePath(path));
                    }
                } 
                catch (NullPointerException e) 
                {
                    System.out.println("NO SUCH PATH");
                }
            }
        }

        catch (FileNotFoundException e) 
        {
            System.out.println("File not found, please try again.");
            main(args);
            input.close();
            return;
        }
    }
}
