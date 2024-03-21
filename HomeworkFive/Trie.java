
/*
 * @author Owen McGrath
 * @version 3/21/2024
 * This is a class that instantiates a trie and a boolean value representing a flag. 
 */
public class Trie {
    private TrieNode root;

    public Trie () {
        root = new TrieNode(); //creating trieNode object

        for (int i = 0; i < root.possibleLetters; i++) {
            root.edges[i] = null; //setting all edges to null
        }
    }

    public boolean add(String word) {
        
    }
}

