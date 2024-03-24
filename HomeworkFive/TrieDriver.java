import java.util.Scanner;
import java.io.File;

/**
 * @author Owen McGrath 3/21/2024
 * A class that acts as a driver for testing methods and getting user input
 */
public class TrieDriver {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        Scanner file = new Scanner(new File("dictionary.txt"));
        Trie trie = new Trie();
        Scanner scanner = new Scanner(System.in); 


        long beforeAdd = Runtime.getRuntime().freeMemory();
        long startTimeAdd = System.currentTimeMillis();
        while (file.hasNext()) {
            trie.add(file.next());
        }
        long afterAdd = Runtime.getRuntime().freeMemory();
        long endTimeAdd = System.currentTimeMillis();

        System.out.println("memory (add) (MB): " + (beforeAdd-afterAdd)/1e6);
        System.out.println("time (add) (sec): " + (endTimeAdd-startTimeAdd)/1e3);
        System.out.println("The number of words in the trie is: " + trie.size());

        System.out.println("What word or prefix would you like to search?");
        String wordOrPre = scanner.nextLine();

        if (trie.contains(wordOrPre)) {
            System.out.println(wordOrPre + " is a word!");
        } else if (trie.containsPrefix(wordOrPre)) {
            System.out.println(wordOrPre + " is a prefix!");
        } else {
            System.out.println("That is neither a word nor a prefix");
        }
    }
}
