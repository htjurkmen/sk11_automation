package lecture06;

import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        isPalindrome();

    }

    public static double findSmallestNumber(double num1, double num2, double num3) {
        double smallestNumber = num1;

        if (smallestNumber > num2) {
            smallestNumber = num2;
        }

        if (smallestNumber > num3) {
            smallestNumber = num3;
        }

        return smallestNumber;
    }

    public static double computeAverageNumber(double num1, double num2, double num3) {
        return (num1 + num2 + num3) / 3;
    }

    public static void displayMiddleChar(String value) {
        int position;
        int length;

        //If the length of the string is even there will be two middle characters.
        if (value.length() % 2 == 0) {
            position = value.length() / 2 - 1; // we find the middle of the string
            length = 2;

        } else {
            //If the length of the string is odd there will be one middle character.
            position = value.length() / 2; // we find the middle of the string
            length = 1;
        }
        // based on the lenght above we pull on char for odd and two for even strings,
        // starting from string middle found above.
        System.out.println(value.substring(position, position + length));
    }

    public static void displayMiddleCharacter2(String value) {

        int index = value.length() / 2;;

        if (value.length() % 2 == 0) {
            System.out.print(value.charAt(index-1));
            System.out.print(value.charAt(index));
        } else System.out.println(value.charAt(index));
    }
    public static int countWords(String text) {
        text = text.trim();
        int count = 0;
        int textLength = text.length();

        if (textLength > 1) {
            count++; //After trim() we removed leading and trailing spaces the text will always start with a word

            for (int i = 1; i < textLength; i++) {
                //we look for space and each new space is sign new word starts so we can increase the count
                if (text.charAt(i) == ' ') {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void isEvenDetails() {
        Scanner checkNum = new Scanner(System.in);
        System.out.println("Enter Number");
        int i = checkNum.nextInt();
        if (i >= 0) {
            isEven(i);
        } else {
            System.out.println("Enter Positive Integer!");
        }
        if (isEven(i) == true) {
            System.out.println("true");
        } else if (isEven(i) == false) {
            System.out.println("false");
        }
    }

    public static boolean isPalindrome() {
        int remainder;
        int sum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number ");

        int num = scanner.nextInt();

        if (num >= 0) {
            int palindrome = num;

            while (palindrome > 0) {
                // we do modul devision so we ge the last digit from the number
                remainder = palindrome % 10;
                // we do multiplication by 10 to increase digit size and add the new number at the end
                sum = (sum * 10) + remainder;
                // we can also write it on singe line remainder = (remainder * 10) + (palindrome % 10);
                // we divide by 10 and get only the whole digits ie we remove numbers at the end
                palindrome = palindrome / 10;
            }
            return num == sum;
        } else {
            System.out.println("The integer must be non-negative!");
            return false;
        }
    }




}

