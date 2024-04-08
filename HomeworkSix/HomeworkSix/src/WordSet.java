import java.util.TreeSet;

public class WordSet 
{

    int size;
    TreeSet<String> tree = new TreeSet<String>();
    String currentLongestWord = "";

    public WordSet() 
    {

    }

    public boolean add(String word) //TODO: This code always deletes the first word. why?
    {

    word = word.toLowerCase();
    int firstLetterOrNumber = 0; //initialize at the first index
    int lastLetterOrNumber = -1; //initalize at the back

        for (int i = 0; i < word.length(); i++) //moving from the front.
        {

            if (Character.isLetterOrDigit(word.charAt(i))) 
            {
                firstLetterOrNumber = i;
                break;
            }
        }

        for (int i = word.length() - 1; i > 0; i--) //moving from the back.
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

        if (firstLetterOrNumber != 0 && lastLetterOrNumber != -1) {
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

    public int size() 
    {
        return size;
    }

    public String getLongest()
    {        
        return currentLongestWord;
    }

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

    public int uniqueWords() 
    {
        return tree.size();
    }
}
