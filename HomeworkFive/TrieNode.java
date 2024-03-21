class TrieNode {
    int possibleLetters = 26;
    boolean isWord;
    public TrieNode [] edges;//no magic numbers, right? -> creating all possible edges

    public TrieNode() {
        edges = new TrieNode[possibleLetters];
        isWord = false;
    }

}

