
/**
 * @author Owen McGrath
 * @version 3/21/2024
 * This is a class that adds words to a trie, checks if a word or prefix is contained in the trie, and then returns the size of the trie
 **/
public class Trie {

    protected TrieNode root; //creating root node
    int size = 0;

    /**
     * @version 3/21/2024
     * This is a constructor that instatiates the root of a trie.
     */
    public Trie () {

        root = new TrieNode(); //instantiaing root object

    }

    /**
     * @param word
     * @return true
     * Adds a word to the tree 
     **/
    public boolean add(String word) { //sets the indexed node to root, starting point.

        word = word.toLowerCase();

        TrieNode currentNode = root;

        if (contains(word)) {
            return false; //checking for duplicates
        }

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

        word = word.toLowerCase();

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
     * @param pre
     * @return the flag of whether or not it is a prefix or not
     */
    public boolean containsPrefix(String pre) {

        pre = pre.toLowerCase();

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
/**
 * @author Owen McGrath
 * @version 3/21/2024
 * This is a class that instantiates the edges array,the flag, and then the number of possible letters, as well as gettings and setters for each.
 */
class TrieNode {
    private int possibleLetters = 26; // no magic numbers!
    private boolean isWordorPre;
    private TrieNode [] edges;

    /**
     * This is a constructoir that sets the intial variables to their necessary starting points.
     */
    public TrieNode() {
        edges = new TrieNode[possibleLetters];
        isWordorPre = false;
    }

    /**
     * @return isWordorPre
     * This method gets the flag.
     */
    public boolean getWordorPre() {
        return isWordorPre;
    }

    /**
     * @param isWordorPre
     * This is a method that sets the flag
     */
    public void setWordorPre(boolean isWordorPre) {
        this.isWordorPre = isWordorPre;
    }

    /**
     * @param letter
     * @return edges
     * This is a method that returns the edges array
     */
    public TrieNode getEdge(char letter) {
        return edges[letter - 'a']; //creating unicode
    }

    /**
     * @param newNode
     * @param i
     * This is a method that sets the edges array
     */
    public void setEdge(TrieNode newNode, char letter) {
        this.edges[letter - 'a'] = newNode; //creating unicode.
    }

    /**
     * @return possibleLetters
     * This is a method that returns the number of possible letters
     */
    public int getPossibleLetters() {
        return possibleLetters;
    }

    /**
     * @param possibleLetters
     * This is a method that sets the possibleLetters
     */
    public void setPossibleLetters(int possibleLetters) {
        this.possibleLetters = possibleLetters;
    }

}
