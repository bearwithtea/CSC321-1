import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException ;
public class PathFinder {

    @SuppressWarnings("resource")
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
            
                try 
                {
                    //TODO: iterate over the findpath method, for each adjacent found, report its edge.
                    List<String> path = fsm.findPath(start, end); //FIXME: This errors out for the second example on the HW7 page.
                    if (path == null)
                    {
                        System.out.println("\nNO SUCH PATH");
                    }
                    else 
                    {
                        System.out.println("State Path: " + path);
                    }
                } 
                catch (NullPointerException e) 
                {
                    System.out.println("\nNO SUCH PATH");
                }
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
