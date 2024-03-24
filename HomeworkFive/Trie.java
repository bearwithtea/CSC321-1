
/**
 * @author Owen McGrath
 * @version 3/21/2024
 * This is a class that instantiates a trie and a boolean value representing a flag. 
 **/

public class Trie {

    protected TrieNode root; //creating root node
    int size = 0;

    public Trie () {
        root = new TrieNode(); //instantiattingng root object

        for (int i = 0; i < root.possibleLetters; i++) {
            root.nodesArray[i] = null; //setting all edges to null so that they exist but don't have nything in them
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

            if (currentNode.nodesArray[index] == null) { 
                currentNode.nodesArray[index] = new TrieNode(); //have top create a new node if there is no other node already there
            }
            currentNode = currentNode.nodesArray[index];
            size++;
        }

        currentNode.isWordorPre = true; //sets the flag to true at the end of the word.

        return true;
    }

    /**
     * @param word
     * @return currentNode.isWordorPre
     */
    public boolean contains(String word) {

        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++ ) {
            char currentLetter = word.charAt(i);
            int index = currentLetter - 'a';

            if (currentNode.nodesArray[index] == null) {
                return false; //if none of the edges are in the trie, then return false
            }

            currentNode = currentNode.nodesArray[index];

        }
        return currentNode.isWordorPre; //marks the flag if the word is in the trie
    }

    /**
     * 
     * @param pre
     * @return the flag of whether or not it is a prefix or not
     */
    public boolean containsPrefix(String pre) {

        TrieNode currentNode = root;

        for (int i = 0; i < pre.length(); i++) {
            char currentLetter = pre.charAt(i);
            int index = currentLetter - 'a';

            if (currentNode.nodesArray[index] == null) {
                return false;
            }
            currentNode = currentNode.nodesArray[index];
        }

        return true;
    }

    /**
     * @return size
     * returns the size that is incremented each time something is added via the add method
     */
    public int size() {

        return size;

        }
    }

