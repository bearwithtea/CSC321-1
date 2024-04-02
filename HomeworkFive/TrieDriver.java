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
        String wordOrPre;
        
        while (file.hasNext()) {
            trie.add(file.next());
        }

        System.out.println(trie.add(""));
        System.out.println(trie.contains(""));
        
        System.out.println("The number of words in the trie is: " + trie.size());

        do { 
            System.out.println("What word or prefix would you like to search? (Key 'enter' to exit the program)");
            wordOrPre = scanner.nextLine();

            if (wordOrPre != "") { 

                if (trie.contains(wordOrPre)) {
                    System.out.println(wordOrPre + " is a word!");
                } else if (trie.containsPrefix(wordOrPre)) {
                    System.out.println(wordOrPre + " is a prefix!");
                } else {
                    System.out.println("That is neither a word nor a prefix");
                } 
                
            }   

        } while (wordOrPre != "");

        System.out.println("Thank you for using my program, have a wonderful day!");

    }
} 