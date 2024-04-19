import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException ;
public class PathFinder {

    @SuppressWarnings("resource")
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

                while (true) 
                {
                    /* Start State */
                    System.out.println("\nEnter a start state (* to end): ");
                    String start = input.nextLine();
                    if (start.equals("*")) break;

                    /* End State */
                    System.out.println("\nEnter an end state: ");
                    String end = input.nextLine();

                    System.out.println("State Path: " + fsm.findPath(start, end)); //this errors on the second example.
                    //System.out.println("Edge Labels: " + fsm.getAdjacentState(start, edge));
                }
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
