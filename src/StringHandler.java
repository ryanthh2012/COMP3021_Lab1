package lab5;
import java.util.Scanner;

public class StringHandler {
  private static String originalText;
  private static String modifiedText;
  private static Scanner reader=new Scanner(System.in); //static reader, no need to open reader in the methods of the class
  
  public static void split() {
    System.out.print("Please input a delimiter: ");
    String target = "";
    target = reader.next();
		
    // TODO 1: Split the string whenever there is a delimiter
    //         Output each substring in separate line
    String[] parts = originalText.split(target);
    for (int i=0; i < parts.length; i++){
    	System.out.println(parts[i]);
    }
  }
  
  public static void removeSubstring() {
	System.out.print("Please input string to remove: ");
	String target = reader.next();
	
	System.out.println("String before removing \'" + target + "\': " + originalText);
	
	// TODO 3: Remove the target character sequence from the original string
	//         if it doesn't exist in the string, output "target is not found"
	//         e.g., original = "Hello World", target = "Wor"
	//               target = "Hello ld"
	if (!originalText.contains(target)){
		System.out.println("target is not found");
	}
	else {
		modifiedText = originalText;
		String[] parts = modifiedText.split(target);
		StringBuilder temp = new StringBuilder();
		for (int i=0; i<parts.length; i++){
			temp.append(parts[i]);
		}
		modifiedText = temp.toString();
		System.out.println(modifiedText);
	}
  }
  
  
  public static void shiftString() {
    System.out.print("Please input amount of shift: ");
	int shiftAmount = reader.nextInt();
	
	// TODO 4: Shift characters backward by the amount specified by shiftAmount
	//         e.g., Input string: "Hello World"
	//               shiftAmount: 3
	//               Result: "lo WorldHel"
	StringBuilder temp = new StringBuilder();
	for (int i=0; i<originalText.length(); i++){
		temp.append(originalText.charAt((i+shiftAmount)%originalText.length()));		
	}
	modifiedText = temp.toString();
	System.out.println(modifiedText);
  }
  
  
  public static void countVowels() {
    // TODO 5: Count number of vowels in String. (A, E, I, O, U, a, e, i, o, and u)
	  int count = 0;
	  char[] vowels = {'A','E','I','O','U','a','e','i','o','u'};
	  for (int i=0; i < originalText.length(); i++){
		  for (int j=0; j<vowels.length; j++){
			  if (originalText.charAt(i) == vowels[j])
				  count += 1;
		  }
	  }
	  System.out.println("number of vowels in \"" + originalText + "\": " + count );
  }

  public static void ceaserCipher() {
	System.out.print("Please input amount of shift: ");
	//Scanner reader = new Scanner(System.in); // Scanner is used for Java input
	int shift = reader.nextInt();
	
	// TODO 4: Rotate each characters forward by the amount specified by shiftAmount. Any numbers and special characters should be left the same.
	//         Also, The string should be converted into capital letters first
	//         e.g., Input string: "Hello World! 123"
	//               shiftAmount: 30
	//               Result: "LIPPS ASVPH! 123"
	StringBuilder temp = new StringBuilder(originalText);
	for (int i = 0; i<temp.length(); i++){
		int after_shift = temp.charAt(i)+shift;
		if ((int) temp.charAt(i) >= 65 && (int) temp.charAt(i) <=90){
			if (after_shift > 90)
				after_shift -= 26;
			temp.setCharAt(i, (char) after_shift);
		}
		else if ((int) temp.charAt(i) >= 97 && (int) temp.charAt(i) <=122){
			if (after_shift > 122)
				after_shift -= 26;
			temp.setCharAt(i, (char) after_shift);
		}
	}
	System.out.println(temp.toString());
 }
  
  public static void main(String args[]){
	  
    System.out.println("Welcome to the String Handling System!");
    System.out.print("Please input a string you want to process: ");
		
    Scanner reader = new Scanner(System.in); // Scanner is used for Java input
    originalText = reader.nextLine();
    
    String option = "";
		
    // boolean dummy = true;
    // TODO 1a: Replace dummy with a correct condition that quit when user input "Q"
    while (!option.equals("Q")) {	
      System.out.println("=========== Options ============");
      System.out.println("1: Split the string");
      System.out.println("2: Remove all substring from string");
      System.out.println("3: Shift the string");
      System.out.println("4: Count number of vowels");
	  System.out.println("5: Ceaser cipher");
      System.out.println("================================");
      System.out.println("Please choose an option (type in Q if you want to quit): ");
      option = reader.next();
			
      switch (option){
        case "1":
          split();
          break;
        case "2":
          removeSubstring();
          break;
        case "3":
          shiftString();
          break;
        case "4":
          countVowels();
          break;
        case "5":
          ceaserCipher();
          break;
        default:
          if (option.equals("Q"))
            System.out.println("Goodbye!");
          else
            System.out.println("Invalid Option! Please try again: ");
  		    break;
	   }
	 }
    reader.close();
  }
}
