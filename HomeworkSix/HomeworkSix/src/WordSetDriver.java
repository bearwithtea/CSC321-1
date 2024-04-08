import java.io.File;
import java.util.Scanner;

public class WordSetDriver 
{

    public static void main(String[] args) throws Exception 
    {

        Scanner file = new Scanner(new File("Lincoln.txt"));
        Scanner scanner = new Scanner(System.in); 
        String word;

        WordSet tree = new WordSet();

        while (file.hasNext()) 
        {
            tree.add(file.next());
        }
        System.out.println("\n");
        System.out.println("There are " + tree.size() + " total words in the tree" + " and " + tree.uniqueWords() + " unique words in the tree.");
        System.out.println("The longest word in the tree is '" + tree.getLongest() + "' with " + tree.getLongest().length() + " letters. \n");
        System.out.println("-------------------------------------------------------------------------------- \n");
        System.out.println(tree.toString());

    }
    
}
