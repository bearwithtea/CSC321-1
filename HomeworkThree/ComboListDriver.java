import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class ComboListDriver {
    public static void main(String[] args) throws Exception {

        ComboList<Integer> combolist = new ComboList<Integer>(10);
        
        for (int i = 0; i < 100; i++) {
            combolist.add(i);
        }

        for (int i = 0; i < combolist.size(); i++) {
            combolist.get(i);
        }

        combolist.sneakPeek();
        System.out.println(combolist.size());
        System.out.println(combolist.get(53));
        combolist.add(39, 1000);
        combolist.add(40, 45);
        combolist.sneakPeek();
        System.out.println(combolist.toList());
        System.out.println(combolist.toString());

        String userInput = getsUserInput();
        Integer getsStartingSize = getsStartingSize();
        Integer getsMaxSize = getsMaxSize();
        Integer getsNumberOfOperations = getsNumberOfOperations();

        if (userInput.startsWith("a") || userInput.startsWith("A")) {
            ArrayList<Integer> testArrayQueue = new ArrayList<Integer>();
            increaseUntilMaxForQueue(testArrayQueue, getsStartingSize, getsMaxSize, getsNumberOfOperations());
        } else if (userInput.startsWith("l") || userInput.startsWith("L")) {
            LinkedList<Integer> testLinkedList = new LinkedList<Integer>();
            increaseUntilMaxForQueue(testLinkedList, getsStartingSize, getsMaxSize, getsNumberOfOperations());
        } else {
            ComboList<Integer> testComboList = new ComboList<Integer>(10);
            increaseUntilMaxForQueue(testComboList, getsStartingSize, getsMaxSize, getsNumberOfOperations());
        }
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like for the structure to start at: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }  

        Integer startingSize = scanner.nextInt();
        return startingSize;

    }

    public static Integer getsMaxSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your maximum size: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number LESS THAN your starting size.");
            scanner.nextLine();

        }

        Integer doublingSizeUntil = scanner.nextInt();
        scanner.nextLine(); 
        return doublingSizeUntil;
        
    }

    public static Integer getsNumberOfOperations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of peek/add/remove operations: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }

        Integer numberOfOperations = scanner.nextInt();
        scanner.nextLine(); 
        return numberOfOperations;

    }

    public static void increaseUntilMaxForQueue(List<Integer> L, Integer getsStartingSize, Integer getsMaxSize, Integer getsNumberOfOperations) {
        for (int i = 0; i < getsStartingSize; i++){
            L.add(getsStartingSize);
        }

        StopWatch stopWatch = new StopWatch();
        long elapsedTime = 0;

        while (L.size() < getsMaxSize) {
            stopWatch.start();
            for (int i = 0; i < getsNumberOfOperations; i++) {
                L.get(i);
            }
            stopWatch.stop();
            elapsedTime = stopWatch.getElapsedTime();
            System.out.println("Size: " + L.size() + " Time: " + elapsedTime);

        }
    }
}