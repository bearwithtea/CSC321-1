//filename: CreditCardExamples.txt
import java.util.Scanner;

/**
 * Reads in a file and then stores the information in a string before calling the
 * CreditCardReader class, passing in the file name, and then checking for valid/invalid creditcards based
 * on the amount of question marks as well as sorting and generating the reports.
 * @author Owen McGrath 
 * @version 1/13/2024
 */
public class ReadCreditCardMain {

  public static void main(String[] args) throws Exception {
    try (Scanner keyboard = new Scanner(System.in)) {
      System.out.println("What is the file you would like to read in from?");
      String filename = keyboard.nextLine();
      ReadCreditCard creditCards = new ReadCreditCard(filename);
      creditCards.validInvalidChecker();
      creditCards.arrayListSorter();
      creditCards.validReportGenerator();
      creditCards.invalidReportGenerator();
      keyboard.close();
    }
  }
}
