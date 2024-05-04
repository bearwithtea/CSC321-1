import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class focused on reading in and sorting creditcard numbers based on Luhn's formula
 * @author Owen McGrath 
 * @version 1/13/2024
 */
public class ReadCreditCard {

  private ArrayList<String> creditCardNumbers = new ArrayList<String>();
  private ArrayList<String> sortedValidCreditCards = new ArrayList<String>(); 
  private ArrayList<String> sortedInvalidCreditCards = new ArrayList<String>();

  /**
   * Constructor which reads in a file and adds items to a copy string only
   * if they are numbers. The sorted list is then added back into the predefined ArrayList
   * @author Owen McGrath
   * @param filename the name of the file that reads in the credit card
   * @version 1/14/2024
   */
  public ReadCreditCard(String filename) {
    try {
      Scanner infile = new Scanner(new File(filename));
      while (infile.hasNextLine()) {
        String copyString = "";
        String newCardNumbers = infile.nextLine();
        for (int i = 0; i < newCardNumbers.length(); i++) {
          if (Character.isDigit(newCardNumbers.charAt(i)) || newCardNumbers.charAt(i) == '?') {
            copyString += newCardNumbers.charAt(i);
          }
        }
        creditCardNumbers.add(copyString);
      }
    } catch (FileNotFoundException e) {
      System.out.println("No such file found");
    }
  }


  /**
   * This method counts how many question marks there are in each cardnumber
   * and then, based off of how many question marks there are, adds it to the 
   * respective arraylist. if there is more than one corrupted digit, it is
   * automatically added to invalid. otherwise, luhnsFormulaChecker is called
   * and the card number is sorted based off of that.
   * @author Owen McGrath
   * @version 1/22/2024
   */
  public void validInvalidChecker() {
    String digits = "0123456789";
    for (String cardNumber : creditCardNumbers) {
      int questionMarkSum = 0;
      for (int i = 0; i < creditCardNumbers.size(); i++) {
        if (cardNumber.charAt(i) == '?') {
          questionMarkSum++;
        }
      }
      if (questionMarkSum > 1) {
        sortedValidCreditCards.add(cardNumber);
      } else if (questionMarkSum == 1) {
        for (int i = 0; i < 10; i++) {
          char ch = digits.charAt(i);
          String copy = cardNumber.replace('?', ch);
          if (luhnsFormulaChecker(copy) == true) {
            sortedValidCreditCards.add(copy);
            
          }
        }
      }
      else {
        if (luhnsFormulaChecker(cardNumber) == true) {
          sortedValidCreditCards.add(cardNumber);
        }
        else {
          sortedInvalidCreditCards.add(cardNumber);
        }
      }
    }
  }

  /**
   * Method which takes the creditCardNumbers arrayList and iterates over it with a for
   * each loop, performing Luhn's formula and eventually checking if the final result is
   * divisible by ten
   * @author Owen McGrath 
   * @version 1/15/2024
   * @param cardNumber
   * @return boolean
   */
  public boolean luhnsFormulaChecker(String cardNumber) {
    int totalSumOfCreditCardNumbers = 0;
    for (int i = cardNumber.length() - 1; i > -1; i--) {
      if ((cardNumber.length() - i) % 2 == 0) {
        if ((Character.getNumericValue(cardNumber.charAt(i)) * 2) > 9) {
          int placeholderNumber = Character.getNumericValue(cardNumber.charAt(i)) * 2;
          placeholderNumber -= 9;
          totalSumOfCreditCardNumbers += placeholderNumber;
        } else {
          totalSumOfCreditCardNumbers += Character.getNumericValue(cardNumber.charAt(i)) * 2;
        }
      } else {
        totalSumOfCreditCardNumbers += Character.getNumericValue(cardNumber.charAt(i));
      }
      //System.out.println("Cardnumber:" + cardNumber + "Sum:" + sum);
    }
    if (totalSumOfCreditCardNumbers % 10 == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Uses the collections library to sort validCreditCards and invalidCreditCards
   * in ascending numerical order. 
   * @author Owen McGrath
   * @version 1/19/2024
   */
  public void arrayListSorter() {
    Collections.sort(sortedValidCreditCards);
    Collections.sort(sortedInvalidCreditCards);
  }

  /**
   * Prints out each card number in the validCreditCards arraylist
   * @author Owen McGrath
   * @version 1/19/2024
   */
  public void validReportGenerator() {
    System.out.println("Valid");
    for (int i = 0; i < sortedValidCreditCards.size(); i++) {
      System.out.println(sortedValidCreditCards.get(i));
    }
  }

  /**
   * Prints out each card number in the invalidCreditCards arrayList
   * @author Owen McGrath
   * @version 1/19/2024
   */
  public void invalidReportGenerator() {
    System.out.println("Invalid");
    for (int i = 0; i < sortedInvalidCreditCards.size(); i++) {
      System.out.println(sortedInvalidCreditCards.get(i));
    }
  }
}
