import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListCompareDriver {

    private static Scanner scanner = new Scanner(System.in);
    private static StopWatch stopWatch = new StopWatch();

    public static void main(String[] args) throws Exception {

        int startingSize = getsStartingSize();
        int maxSize = getsMaxSize(startingSize);

        increaseUntilMax(startingSize, maxSize);

    }
    
    //getbigger than method, give it a number, if it is positive, give it a starting size, 

    public static Integer getsStartingSize() {   
        System.out.println("What would you like for the structure to start at: ");
        int startingSize = scanner.nextInt(); 
        scanner.nextLine();

        if (startingSize < 1) {
            System.out.println("You have input a negative number or a zero");
            return getsStartingSize();
        }
        return startingSize;
    }

    public static Integer getsMaxSize(int startingSize) {   
        System.out.println("What would you like for the max size to be: ");
        int maxSize = scanner.nextInt(); 
        scanner.nextLine();

        if (maxSize <= startingSize) {
            System.out.println("You have input a negative number or a zero");
            return getsMaxSize(startingSize);
        }
        return maxSize;
    }

    public static void increaseUntilMax(Integer getsStartingSize, Integer getsMaxSize) {

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