
/**
 * @author Owen McGrath
 * @version 3/21/2024
 * This is a class that instantiates a trie and a boolean value representing a flag. 
 **/

public class Trie {
    private TrieNode root; //creating root node

    public Trie () {
        root = new TrieNode(); //instantiattingng root object

        for (int i = 0; i < root.possibleLetters; i++) {
            root.edges[i] = null; //setting all edges to null so that they exist but don't have nything in them
        }
    }

    /**
     * @param word
     * @return true
     * Adds a word to the tree 
     **/
    public boolean add(String word) {

    TrieNode currentNode = root; //sets the indexed node to root, starting point.

        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            char currentLetter = word.charAt(i);
            int index = currentLetter - 'a'; //converting into unicode.

            if (currentNode.edges[index] == null) {
                currentNode.edges[index] = new TrieNode(); //have top create a new node if there is no other node already there
            }
            currentNode = currentNode.edges[index];
        }

        currentNode.isWord = true; //sets the flag to true at the end of the word.

        return true;
    }

    public boolean contains(String word) {

        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++ ) {
            char currentLetter = word.charAt(i);
            int index = currentLetter - 'a';

            if (currentNode.edges[index] == null) {
                return false; //if none of the edges are in the trie, then return false
            }

            currentNode = currentNode.edges[index];

        }
        return currentNode.isWord; //marks the flag if the word is in the trie
    }

    public boolean containsPrefix(String pre) {
        
    }
}

