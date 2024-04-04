import java.util.ArrayList;
import java.util.TreeSet;

public class WordSet 
{

    int size;
    TreeSet<String> tree = new TreeSet<String>();

    public WordSet() 
    {

    }

    public boolean add(String word) 
    {

        word = word.toLowerCase();
        int firstLetterOrNumber = 0;
        int lastLetterOrNumber = 0;

        {

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

            word = word.substring(firstLetterOrNumber, lastLetterOrNumber + 1);
            size++;
        }
        tree.add(word);
        return true;
    }

    public int size() 
    {
        System.out.println(size);
        return size;
    }

    public String getLongest()
    {
        ArrayList<String> longestWords = new ArrayList<String>();
        String currentLongestWord = "";
        for (String word : tree) 
        {
           while (word.length() > currentLongestWord.length())  //TODO: how do I get this to iterate even after I get a longest word?
           {
                currentLongestWord = word;
           } 
           longestWords.add(currentLongestWord);
        }
        System.out.println(longestWords);
        return currentLongestWord;
    }

    public String toString()
    {
        return "hello";
    }

}
