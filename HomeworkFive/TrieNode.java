class TrieNode {
    int possibleLetters = 26;
    boolean isWord;
    public TrieNode [] edges;

    public TrieNode() {
        edges = new TrieNode[possibleLetters]; //no magic numbers, right? -> creating all possible edges
        isWord = false;
    }

}

