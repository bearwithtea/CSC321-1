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
                Character letter = word.charAt(i);

                if (!Character.isLetterOrDigit(letter)) {
                    word  = word.replace(Character.toString(letter), "");
                }
                
            }

            System.out.println(word);
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
