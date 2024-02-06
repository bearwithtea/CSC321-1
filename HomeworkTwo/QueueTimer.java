import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTimer {
    public static void main(String[] args) throws Exception {
        String linkedOrArray = getsLinkedOrArrayInput();
        Integer startingQueueSize = getsStartingQueueSize();
        Integer doublingSizeUntil = getsDoublingSizeUntil();
        Integer numberOfOperations = getsNumberOfOperations();

        if (linkedOrArray.startsWith("a") || linkedOrArray.startsWith("A")) {
            ArrayQueue<Integer> testArrayQueue = new ArrayQueue<Integer>();
            increaseUntilMaxForQueue(testArrayQueue, startingQueueSize, doublingSizeUntil, numberOfOperations);
        } else {
            LinkedList <Integer> testLinkedList = new LinkedList<Integer>();
            increaseUntilMaxForQueue(testLinkedList, startingQueueSize, doublingSizeUntil, numberOfOperations);
        }
    }

    public static String getsLinkedOrArrayInput() {
        Scanner scanner = new Scanner(System.in);
        String linkedOrArray = "";

        while (!linkedOrArray.startsWith("a") && !linkedOrArray.startsWith("A") && !linkedOrArray.startsWith("l") && !linkedOrArray.startsWith("L")) {
            System.out.println("(A)rray or (L)inked Implementation: ");
            linkedOrArray = scanner.nextLine();
            

            if (!linkedOrArray.startsWith("a") && !linkedOrArray.startsWith("A") && !linkedOrArray.startsWith("l") && !linkedOrArray.startsWith("L")) {
            System.out.println("Invalid input. Please enter a valid letter or word.");
            }
        }
        return linkedOrArray;
    }

    public static Integer getsStartingQueueSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting queue size: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }  

        Integer startingQueueSize = scanner.nextInt();
        return startingQueueSize;

    }

    public static Integer getsDoublingSizeUntil() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Doubling size until: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
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

    public static void increaseUntilMaxForQueue(Queue<Integer> Q, Integer startingQueueSize, Integer doublingSizeUntil, Integer numberOfOperations) {
        for (int i = 0; i < startingQueueSize; i++){
            Q.add(startingQueueSize);
        }

        StopWatch stopWatch = new StopWatch();
        long elapsedTime = 0;

        while (Q.size() < doublingSizeUntil) {
            stopWatch.start();
            for (int i = 0; i < numberOfOperations; i++) {
                Q.add(i);
                Q.remove(i);
                Q.peek();
            }
            stopWatch.stop();
            elapsedTime = stopWatch.getElapsedTime();
            System.out.println("Size: " + Q.size() + " Time: " + elapsedTime);

            Integer currentSize = Q.size();
            for (int i = 0; i < currentSize; i++) {
                Q.add(0);
            }
        }
    }
}