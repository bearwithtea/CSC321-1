
/**
 * @author Owen McGrath
 * @version 3/21/2024
 * This is a class that instantiates a trie and a boolean value representing a flag. 
 **/

public class Trie {

    protected TrieNode root; //creating root node
    int size = 0;

    public Trie () {

        root = new TrieNode(); //instantiaing root object

    }

    /**
     * @param word
     * @return true
     * Adds a word to the tree 
     **/
    public boolean add(String word) { //sets the indexed node to root, starting point.

        TrieNode currentNode = root;

        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            char currentLetter = word.charAt(i);

            if (currentNode.getEdge(currentLetter) == null) { 
                currentNode.setEdge(new TrieNode(), currentLetter); //have top create a new node if there is no other node already there
            }
            currentNode = currentNode.getEdge(currentLetter);
        }
        size++;

        currentNode.setWordorPre(true); //sets the flag to true at the end of the word.

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

            if (currentNode.getEdge(currentLetter) == null) {
                return false; //if none of the edges are in the trie, then return false
            }

            currentNode = currentNode.getEdge(currentLetter);

        }
        return currentNode.getWordorPre(); //marks the flag if the word is in the trie
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

            if (currentNode.getEdge(currentLetter) == null) {
                return false;
            }
            currentNode = currentNode.getEdge(currentLetter);
        }

        return true; //can't reutrn the flag because there will be none with the prefix.
    }

    /**
     * @return size
     * returns the size that is incremented each time something is added via the add method
     */
    public int size() {

        return size; //O(1) since it is being calculated in add.

    }
}
