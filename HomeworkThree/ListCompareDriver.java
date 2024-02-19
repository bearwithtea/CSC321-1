import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListCompareDriver {

//add error checking :)
    public static void main(String[] args) throws Exception {
        String userInput = getsUserInput();
        Integer getsStartingSize = getsStartingSize();
        Integer getsMaxSize = getsMaxSize();

        if (userInput.startsWith("a") || userInput.startsWith("A")) {
            ArrayList<Integer> testArrayQueue = new ArrayList<Integer>();
            increaseUntilMax(testArrayQueue, null, getsStartingSize, getsMaxSize());
        } else if (userInput.startsWith("l") || userInput.startsWith("L")) {
            LinkedList<Integer> testLinkedList = new LinkedList<Integer>();
            increaseUntilMax(testLinkedList, null, getsStartingSize, getsMaxSize());
        } else {
            ComboList<Integer> testComboList = new ComboList<Integer>(10);
            increaseUntilMax(null, testComboList, getsStartingSize, getsMaxSize());
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

        while (!scanner.hasNextInt()) { //how do i make sure that the starting size is less than max size if max size is defined here
            System.out.println("Invalid input. Please enter a valid number LESS THAN your starting size.");
            scanner.nextLine();

        }

        Integer doublingSizeUntil = scanner.nextInt();
        scanner.nextLine(); 
        return doublingSizeUntil;
        
    }

    public static void increaseUntilMax(List<Integer> L, ComboList<Integer> comboList, Integer getsStartingSize, Integer getsMaxSize) {
        for (int i = 0; i < getsStartingSize; i++){
            L.add(getsStartingSize);
            comboList.add(getsStartingSize);
        }

        StopWatch stopWatch = new StopWatch();
        long elapsedTime = 0;

        while (L.size() < getsMaxSize) {
            stopWatch.start();
            for (int i = 0; i < getsMaxSize; i++) {
                L.get(i);
                comboList.get(i);
            }
            stopWatch.stop();
            elapsedTime = stopWatch.getElapsedTime();
            System.out.println("Size: " + L.size() + " Time: " + elapsedTime);

        }
    }
}