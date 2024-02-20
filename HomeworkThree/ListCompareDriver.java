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

        ArrayList<Integer> testArrayQueue = new ArrayList<Integer>();
        increaseUntilMaxforList(testArrayQueue, startingSize, maxSize);
        LinkedList<Integer> testLinkedList = new LinkedList<Integer>();
        increaseUntilMaxforList(testLinkedList, startingSize, maxSize);
        ComboList<Integer> testComboList = new ComboList<Integer>(10);
        increaseUntilMaxforCombo(testComboList, startingSize, maxSize);

    }

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
        System.out.println("What is your maximum size: "); 
        int maxSize = scanner.nextInt();
        scanner.nextLine();
    
        if (maxSize <= startingSize) {
            System.out.println("You have input a number smaller than your starting size, please try again");
            return getsMaxSize(startingSize);
        }
        return maxSize;
    }

    public static void increaseUntilMaxforList(List<Integer> L, Integer getsStartingSize, Integer getsMaxSize) {
        for (int i = 0; i < getsStartingSize; i++){
            L.add(getsStartingSize);
        }

        long elapsedTime = 0;

        while (L.size() < getsMaxSize) {
            stopWatch.start();
            for (int i = 0; i < getsMaxSize; i++) {
                L.get(i);
            }
            stopWatch.stop();
            elapsedTime = stopWatch.getElapsedTime();
            System.out.println("Size: " + L.size() + " Time: " + elapsedTime);

        }
    }

    public static void increaseUntilMaxforCombo(ComboList<Integer> testComboList, Integer getsStartingSize, Integer getsMaxSize) {
        for (int i = 0; i < getsStartingSize; i++){
            testComboList.add(getsStartingSize); //how do i do these in the same method?
        }

        long elapsedTime = 0;

        while (testComboList.size() < getsMaxSize) {
            stopWatch.start();
            for (int i = 0; i < getsMaxSize; i++) {
                testComboList.get(i);
            }
            stopWatch.stop();
            elapsedTime = stopWatch.getElapsedTime();
            System.out.println("Size: " + testComboList.size() + " Time: " + elapsedTime);

        }
    }

}