import java.util.Scanner;
import java.io.File;
public class TrieDriver {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        Scanner file = new Scanner(new File("dictionary.txt"));
        TrieNode trie = new TrieNode();

        while (file.hasNext()) {
            trie.add(file.next());
        }
    }
}
