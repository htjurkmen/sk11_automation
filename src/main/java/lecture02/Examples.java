package lecture02;
import java.util.Scanner;

public class Examples {
    public static void main(String[] args) {

        primitiveOperatorsExamples();

    }


    private static void printUsernameFromInput() {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input

    }

    private static void primitiveOperatorsExamples(){

        int firstNum = 14;
        int secondNum = 5;

        firstNum++;
        System.out.println(firstNum % secondNum); //full digit division returns division remains
        System.out.println(firstNum); // Print increase result
        System.out.println(++firstNum); //Increment of firstNum
        System.out.println(--firstNum); //Reduction of firstNum


    }


}
