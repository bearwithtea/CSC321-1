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

        //unit testing
        /* 
        System.out.println(trie.add("sillyhehe")); //true - new word
        System.out.println(trie.add("car")); //false - duplicate
        // System.out.println(trie.add("")); //throws error
        System.out.println(trie.contains("car")); //true
        System.out.println(trie.contains("sdfgsdfg")); //false
        System.out.println(trie.containsPrefix("pre")); //true
        System.out.println(trie.containsPrefix("hghghgh")); //false
        */
        
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