import java.io.File;
import java.util.Scanner;

public class WordSetDriver {

    public static void main(String[] args) throws Exception {

        Scanner file = new Scanner(new File("Lincoln.txt"));
        Scanner scanner = new Scanner(System.in); 
        String word;

        WordSet tree = new WordSet();

        /* 
        while (file.hasNext()) {
            tree.add(file.next());
        }
        */

        tree.add("--Abc-123!");
        tree.size();

    }
    
}
