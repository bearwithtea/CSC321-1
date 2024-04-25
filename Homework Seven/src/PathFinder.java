import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException ;
public class PathFinder {
    @SuppressWarnings("resource") //annoying errors be gone (this is detrminetal to the code.)
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
