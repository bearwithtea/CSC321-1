import java.util.TreeSet;

/**
 * @author Owen McGrath
 * @version 4/04/2024
 * This class sanitizes file input, gets the amount of words, the unique words, the longest word, and sends it out to a formatted string.
 */
public class WordSet 
{

    int size;
    TreeSet<String> tree = new TreeSet<String>();
    String currentLongestWord = "";

    public WordSet() 
    {

    }

    /**
     * @param word
     * @return true if the word can be added, returns false if it does not meet sanitization standards.
     * Cleans user file input, allowing for only letters and digits unless the special character is sandwhched in between letters and numbers. It also continously counts the size of the TreeMap and checks if one word is longer than the other. 
     */
    public boolean add(String word)
    {

    word = word.toLowerCase(); //making it lowercase [x]
    int firstLetterOrNumber = -1; 
    int lastLetterOrNumber = -1; //initalize at the back

        for (int i = 0; i < word.length(); i++) //moving from the front.
        {

            if (Character.isLetterOrDigit(word.charAt(i))) 
            {
                firstLetterOrNumber = i; //finds the first letter/number, set variable
                break;
            }
        } 

        for (int i = word.length() - 1; i >= 0; i--) //moving from the back.
        {
            if (Character.isLetterOrDigit(word.charAt(i)))
            {
                lastLetterOrNumber = i; //finds the last letter/number, sets variable.
                break;
            }
        }

        //finds longest word in the tree
        for (String wordInTree : tree) 
        {
           if (wordInTree.length() > currentLongestWord.length()) 
           {
                currentLongestWord = wordInTree; 
           } 
        }

        if (firstLetterOrNumber == -1 && lastLetterOrNumber == -1) //if there are no alphanumeric characters left, then these vars remain -1.
        {
            return false;
        } 
        if (tree.contains(word)) //if it has already been added.
        {
            return false;
        } 
        else //build the string and add it.
        {

            word = word.substring(firstLetterOrNumber, lastLetterOrNumber + 1);

            tree.add(word);

            return true;
        }
    }

    /**
     * @return size
     * Returns the size of the tree, which is the number of unique words since sets do not allow for duplicates. :P
     */
    public int size() 
    {
        return tree.size(); //[x]
    }

    /**
     * @return getLongest()
     * Returns the getLongest variable that was found in add()
     */
    public String getLongest()
    {        
        return currentLongestWord; //[x]
    }

    /**
     * @return newResult
     * Formats the text output based on five columns and the padding correlated to the longest word.
     */
    public String toString()
    {

        String newResult = "";
        int longestWordLength = currentLongestWord.length() + 1; //formatting the size of each column, which should be one larger than the longest word [x]

        int wordCount = 0;
        for (String word : tree) 
        {
            wordCount++;
            String formattedString = String.format("%-" + longestWordLength + "s", word);
            newResult += formattedString;

            if (wordCount % 5 == 0) //if the increment is modded to five, then create a new line (five words per line) [x].
            {
                newResult += "\n";
            }
        }
        return newResult;
    }

    //getters and setters!

    /**
     * gets the size variable
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * sets the size variable
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * gets the tree TreeSet
     * @return
     */
    public TreeSet<String> getTree() {
        return tree;
    }

    /**
     * sets the tree TreeSet
     * @param tree
     */
    public void setTree(TreeSet<String> tree) {
        this.tree = tree;
    }

    /**
     * gets the currentLongestWord variable
     * @return
     */
    public String getCurrentLongestWord() {
        return currentLongestWord;
    }

    /**
     * sets the currentLongestWord variable
     * @param currentLongestWord
     */
    public void setCurrentLongestWord(String currentLongestWord) {
        this.currentLongestWord = currentLongestWord;
    }
}
