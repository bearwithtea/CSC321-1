import java.util.TreeSet;

public class WordSet 
{

    int size;
    TreeSet tree = new TreeSet<>();

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
            System.out.println(word);
            size++;
        }
        return true;
    }

    public int size() 
    {
        System.out.println(size);
        return size;
    }

    public String getLongest()
    {
        return "hello";
    }

    public String toString()
    {
        return "hello";
    }

}
