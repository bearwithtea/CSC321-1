class TrieNode {
    int possibleLetters = 26;
    boolean isWordorPre;
    public TrieNode [] nodesArray; //makes more sens eot mne if I call it nodesArray, can change it back if need be.

    public TrieNode() {
        nodesArray = new TrieNode[possibleLetters]; //no magic numbers, right? -> creating all possible edges
        isWordorPre = false;
    }

}

