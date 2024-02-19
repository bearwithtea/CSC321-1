import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListCompareDriver {

//add error checking :)
    private static Scanner scanner = new Scanner(System.in);
    private static StopWatch stopWatch = new StopWatch();

    public static void main(String[] args) throws Exception {

        String userInput = getsUserInput();
        Integer getsStartingSize = getsStartingSize();
        Integer getsMaxSize = getsMaxSize();

        if (userInput.startsWith("a") || userInput.startsWith("A")) {
            ArrayList<Integer> testArrayQueue = new ArrayList<Integer>();
            increaseUntilMaxforList(testArrayQueue, getsStartingSize, getsStartingSize);
        } else if (userInput.startsWith("l") || userInput.startsWith("L")) {
            LinkedList<Integer> testLinkedList = new LinkedList<Integer>();
            increaseUntilMaxforList(testLinkedList, getsStartingSize, getsStartingSize);
        } else {
            ComboList<Integer> testComboList = new ComboList<Integer>(10);
            increaseUntilMaxforCombo(testComboList, getsStartingSize, getsMaxSize());
        }
        scanner.close();
    }


    public static String getsUserInput() {
        Scanner scanner = new Scanner(System.in);
        String linkedArrayorCombo = "";
        linkedArrayorCombo.toLowerCase();

        while (!linkedArrayorCombo.startsWith("a") && !linkedArrayorCombo.startsWith("l") && !linkedArrayorCombo.startsWith("c")) {
            System.out.println("(A)rray, (L)inked, or (C)ombo Implementation: ");
            linkedArrayorCombo = scanner.nextLine();
            

            if (!linkedArrayorCombo.startsWith("a") && !linkedArrayorCombo.startsWith("l") && !linkedArrayorCombo.startsWith("c")) {
            System.out.println("Invalid input. Please enter a valid letter or word.");
            }
        }
        return linkedArrayorCombo;
    }

    public static Integer getsStartingSize() {
        System.out.println("What would you like for the structure to start at: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }  

        Integer startingSize = scanner.nextInt();
        scanner.nextLine();
        return startingSize;

    }

    public static Integer getsMaxSize() {
        System.out.println("What is your maximum size: ");

        while (!scanner.hasNextInt()) { //how do i make sure that the starting size is less than max size if max size is defined here
            System.out.println("Invalid input. Please enter a valid number LESS THAN your starting size.");
            scanner.nextLine();

        }

        Integer doublingSizeUntil = scanner.nextInt();
        scanner.nextLine();
        return doublingSizeUntil;
        
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