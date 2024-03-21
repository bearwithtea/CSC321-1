
/*
 * @author Owen McGrath
 * @version 3/21/2024
 * This is a class that instantiates a trie and a boolean value representing a flag. 
 */

import java.util.ArrayList;

public class Trie {
    private TrieNode root; //creating root node

    public Trie () {
        root = new TrieNode(); //instantiattingng root object

        for (int i = 0; i < root.possibleLetters; i++) {
            root.edges[i] = null; //setting all edges to null
        }
    }

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
}

