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

    word = word.toLowerCase();
    int firstLetterOrNumber = -1; //initialize at the first index
    int lastLetterOrNumber = -1; //initalize at the back

        for (int i = 0; i < word.length(); i++) //moving from the front.
        {

            if (Character.isLetterOrDigit(word.charAt(i))) 
            {
                firstLetterOrNumber = i;
                break;
            }
        } 

        for (int i = word.length() - 1; i >= 0; i--) //moving from the back.
        {
            if (Character.isLetterOrDigit(word.charAt(i)))
            {
                lastLetterOrNumber = i;
                break;
            }
        }

        for (String forWord : tree) 
        {
           if (forWord.length() > currentLongestWord.length()) 
           {
                currentLongestWord = forWord;
           } 
        }

        if (firstLetterOrNumber == -1 && lastLetterOrNumber == -1) 
        {
            return false;
        } 

        if (tree.contains(word))
        {
            return false;
        }

        else 
        {
            word = word.substring(firstLetterOrNumber, lastLetterOrNumber + 1);

            size++;

            tree.add(word);

            return true;
        }
    }

    /**
     * @return size
     * Returns the size variable that was incremented in add()
     */
    public int size() 
    {
        return size;
    }

    /**
     * @return getLongest()
     * Returns the getLongest variable that was incremented in add()
     */
    public String getLongest()
    {        
        return currentLongestWord;
    }

    /**
     * @return newResult
     * Formats the text output based on five columns and the padding correlated to the longest word.
     */
    public String toString()
    {
        int i = 0;
        int longestWordLength = currentLongestWord.length() + 1;
        String newResult = "";

        for (String word : tree) 
        {
            i++;
            String formattedString = String.format("%-" + longestWordLength + "s", word);
            newResult += formattedString;

            if (i % 5 == 0)
            {
                newResult += "\n";
            }
        }
        return newResult;
    }

    /**
     * @return tree.Size();
     * Returns the size of the tree, giving the amount of unique words.
     */
    public int uniqueWords() 
    {
        return tree.size();
    }
}
