class TrieNode {
    private int possibleLetters = 26;
    private boolean isWordorPre;
    private TrieNode [] edges;

    public boolean getWordorPre() {
        return isWordorPre;
    }

    public void setWordorPre(boolean isWordorPre) {
        this.isWordorPre = isWordorPre;
    }

    public TrieNode[] getEdges() {
        return edges;
    }

    
    public void setEdges(TrieNode[] edges) {
        this.edges = edges;
    }


    public int getPossibleLetters() {
        return possibleLetters;
    }

    public void setPossibleLetters(int possibleLetters) {
        this.possibleLetters = possibleLetters;
    }

    public TrieNode() {
        edges = new TrieNode[possibleLetters];
        isWordorPre = false;
    }
}