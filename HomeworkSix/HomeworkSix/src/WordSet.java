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

        {
            for (int i = 0; i < word.length(); i++) {
                String letter = word.substring(0);
                
            }
            size++;
        }
        return true;
    }

    public int size() 
    {
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
