package lecture02;
import java.util.Scanner;


public class Exercises {

    public static void main(String[] args) {

        printPineTree();

    }

    private static void printName() {

        String firstName = "Pesho";
        String middleName = "Petrov";
        String lastName = "Petrov";

        String fullName = firstName + " " + middleName + " " + lastName;

        System.out.println(fullName);

    }

    private static void printTrianglePerimeter() {

        float a = 5.3F;
        float b = 4.2F;
        float c = 3.14F;

        float perimeter = a + b + c;

        System.out.println(perimeter);

    }

    public static void printTriangleArea() {
        float a = 5.1F;
        float h = 2.4F;

        float triangleArea = (a * h) / 2;

        System.out.println("The area of triangle is: " + triangleArea);
    }

    public static void printPineTree() {
        char asterisk = '*';
        System.out.println("     " + asterisk);
        System.out.println("    " + asterisk + " " + asterisk);
        System.out.println("   " + asterisk + " " + asterisk + " " + asterisk);
    }

    public static void printTrianglePerimeterInput() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter side a size");
        float a = myObj.nextFloat();

        System.out.println("Enter side b size");
        float b = myObj.nextFloat();

        System.out.println("Enter side c size");
        float c = myObj.nextFloat();

        float perimeter = a + b + c;

        System.out.println("Triangle Perimeter is: " + perimeter);
    }

    public static void printTriangleAreaInput() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter side a size");
        float a = myObj.nextFloat();

        System.out.println("Enter side b size");
        float h = myObj.nextFloat();

        float area = (a * h) / 2;

        System.out.println("The area of the triangle is: " + area);
    }


    public static void convertMinutesToYearsDays() {
        int minutesInHour = 60;
        int hoursInDay = 24;
        int daysInYear = 365;
        int minutesInYear = minutesInHour * hoursInDay * daysInYear;

        Scanner input = new Scanner(System.in);

        System.out.print("Input the number of minutes: ");

        long min = input.nextLong();

        long years = (min / minutesInYear);
        long days = (min / minutesInHour / hoursInDay) % daysInYear;

        System.out.println(min + " minutes is approximately " + years + " years and " + days + " days");
    }


}
