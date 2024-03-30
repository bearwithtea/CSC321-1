import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
/**
 * Driver class that generates stats on an ArrayList storing a dictionary.
 *   @author Dave Reed
 *   @version 3/17/24
 */
public class StatsDriver {
  public static void main(String[] args) throws java.io.FileNotFoundException {
	  Scanner input = new Scanner(new File("dictionary.txt"));
	  
	  long before=Runtime.getRuntime().freeMemory();
	     ArrayList<String> words = new ArrayList<String>();
	  // LinkedList<String> words = new LinkedList<String>();
	  // TreeSet<String> words = new TreeSet<String>();
	  // Trie words = new Trie();
	  while (input.hasNext()) {
		  words.add(input.next());
	  }
	  long after=Runtime.getRuntime().freeMemory();
	  System.out.println("memory (MB): " + (before-after)/1e6);
	  input.close();
	  
	  long startTime = System.currentTimeMillis();
	  for (int i = 0; i < 10000; i++) {
		  words.contains("zyzzyvas");
		  words.contains("zzzzzzzz");
	  }
	  long endTime = System.currentTimeMillis();
	  System.out.println("time (sec): " + (endTime-startTime)/1e3);
  }
}