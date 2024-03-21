class TrieNode {
    int possibleLetters = 26;
    boolean isWord;
    Trie [] edges = new Trie[possibleLetters]; //no magic numbers, right? -> creating all possible edges
}

