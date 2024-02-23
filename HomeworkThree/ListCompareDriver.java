import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * This is a class that takes a combolist, arraylist, and linkedlist and takes user input of initial size and max size and then times them while each list doubles. Then it prints it out in a readable format
 * @author Owen McGrath
 * @version 2/15/2023
 */
public class ListCompareDriver {

    private static Scanner scanner = new Scanner(System.in);
    private static StopWatch stopWatch = new StopWatch();

    /**
     * Main method that creates starting size and maxsize.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        int startingSize = getsStartingSize();
        int maxSize = getsMaxSize(startingSize);

        increasesUntilMax(startingSize, maxSize);

    }

    /**
     * This is a method that gets the user input for what they want the structure to start at. If it is a negative number or zero, it will reprompt them. It will also reprompt them for a decimal or non-integer.
     * @return startingSize
     */

    public static Integer getsStartingSize() {
        System.out.println("What would you like for the structure to start at: ");
        int startingSize;
        if (scanner.hasNextInt()) {
            startingSize = scanner.nextInt();
            scanner.nextLine();
            if (startingSize < 1) {
                System.out.println("You have input a negative number or a zero");
                return getsStartingSize();
            }
        } else {
            System.out.println("You have input a non-integer");
            scanner.nextLine();
            return getsStartingSize();
        }
        return startingSize;
    }

    /**
     * This is a method that gets user input for what they want the structure to start at. If the number is less than or equal to the starting size, then it will reprompt them. It will also reprompt them for a decimal or non-integer.
     * @param startingSize
     * @return maxSize
     */
    public static Integer getsMaxSize(int startingSize) {
        System.out.println("What would you like for the max size to be: ");
        int maxSize;
        if (scanner.hasNextInt()) {
            maxSize = scanner.nextInt();
            scanner.nextLine();
            if (maxSize <= startingSize) {
                System.out.println("You have input a number less than your starting size.");
                return getsMaxSize(startingSize);
            }
        } else {
            System.out.println("You have input a non-integer");
            scanner.nextLine();
            return getsMaxSize(startingSize);
        }
        return maxSize;
    }

    /**
     * This is a method that takes in the starting size and maxsize, and then creates an arraylist, combolist, and linkedlist. While the starting size is less than the max size and one of the list sizes is less than the starting size, a timer is stopped and started for get methods equal to the size of the list. After that, the count is doubled and the list repeats while the size of the arraylist is smaller than the starting size.
     * @param getsStartingSize
     * @param getsMaxSize
     */
    public static void increasesUntilMax(Integer getsStartingSize, Integer getsMaxSize) {

        long elapsedTimeArray = 0;
        long elapsedTimeLinked = 0;
        long elapsedTimeCombo = 0;

        ArrayList<Integer> testArrayList = new ArrayList<Integer>();
        LinkedList<Integer> testLinkedList = new LinkedList<Integer>();
        ComboList<Integer> testComboList = new ComboList<Integer>(10);

        while (getsStartingSize < getsMaxSize) {
            while (testArrayList.size() < getsStartingSize)
                {
                testArrayList.add(getsStartingSize);
                testLinkedList.add(getsStartingSize);
                testComboList.add(getsStartingSize);
                }

                stopWatch.start();
                for (int i = 0; i < getsStartingSize; i++) {
                    testArrayList.get(i);
                }
                stopWatch.stop();
                elapsedTimeArray = stopWatch.getElapsedTime();

                stopWatch.start();
                for (int i = 0; i < getsStartingSize; i++) {
                    testLinkedList.get(i);
                }
                stopWatch.stop();
                elapsedTimeLinked = stopWatch.getElapsedTime();

                stopWatch.start();
                for (int i = 0; i < getsStartingSize; i++) {
                    testComboList.get(i);
                }
                stopWatch.stop();
                elapsedTimeCombo = stopWatch.getElapsedTime();

                getsStartingSize = getsStartingSize * 2;

                System.out.println("Size for ArrayList: " + testArrayList.size() + " Time: " + elapsedTimeArray);
                System.out.println("Size for LinkedList: " + testLinkedList.size() + " Time: " + elapsedTimeLinked);
                System.out.println("Size for ComboList: " + testComboList.size() + " Time: " + elapsedTimeCombo);
                System.out.println("");

        }
    }
}
