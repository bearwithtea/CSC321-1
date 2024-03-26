/**
 * @author Owen McGrath
 * @version 3/21/2024
 * This is a class that instantiates the edges array,the flag, and then the number of possible letters, as well as gettings and setters for each.
 */
class TrieNode {
    private int possibleLetters = 26;
    private boolean isWordorPre;
    private TrieNode [] edges;

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
     * @return edges
     * This is a method that returns the edges array
     */
    public TrieNode[] getEdges() {
        return edges;
    }

    /**
     * @param edges
     * This is a method that sets the edges array
     */
    public void setEdges(TrieNode[] edges) {
        this.edges = edges;
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

    /**
     * This is a method that sets the intial variables to their necessary starting points.
     */
    public TrieNode() {
        edges = new TrieNode[possibleLetters];
        isWordorPre = false;
    }
}