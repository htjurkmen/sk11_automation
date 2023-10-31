package lecture07;

import java.rmi.RemoteException;
import java.util.*;
import java.io.*;
public class Examples {


    public static void main(String[] args) {

        //Here we handle exception that is not handled insite the method testThrowsException()
         /*try {
            testThrowsException("src/testFile1.txt");
        }catch (FileNotFoundException e){
            System.out.println("The file path is wrong or file is missing !");
        }*/



    }

    /*    static void testCheckedException() {
        File file = new File("src/lecture07/exceptions/testFile.txt");
        FileReader fr = new FileReader(file);
    }*/

    static void testUncheckedException() {
        int[] num = {1, 2, 3, 4};
        System.out.println(num[5]);
    }

    /**
     * @param path example:
     *             "src/lecture07/testFile.txt" valid path
     *             "src/lecture07/testFile1.txt" invalid path
     */
    static void testTryCatch(String path) {
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("The file is not found! Please check the file name and try it again!");
        }
    }

    /**
     * @param number ex: 100, 99, 99, 10
     * @param factor ex: 10, 5, 0, "test"
     */
    static void testTryMultipleCatch(int number, int factor) {
        try {
            if (number % factor == 0)
                System.out.println(factor + " is a factor of " + number);
        } catch (ArithmeticException ex) {
            System.out.println("Arithmetic " + ex);
        } catch (NumberFormatException ex) {
            System.out.println("Number Format Exception " + ex);
        }
    }

    /**
     * @param number ex: 100, 99, 99, 10
     * @param factor ex: 10, 5, 0, "test"
     */
    static void testTryCatchMultipleExceptions(int number, int factor) {
        try {
            if (number % factor == 0)
                System.out.println(factor + " is a factor of " + number);
        } catch (ArithmeticException | NumberFormatException ex) {
            System.out.println("Exception encountered " + ex);
        }
    }

    /**
     * @param path example:
     *             "src/lecture07/exceptions/testFile.txt"
     *             "src/lecture07/testFile1.txt"
     */
    static void testThrowsException(String path) throws FileNotFoundException {
        File file = new File(path);
        FileReader fileReader;
        fileReader = new FileReader(file);
    }

    /**
     * @param number ex: 100, 99, 99, 10
     * @param factor ex: 10, 5, 0, "test"
     */
    static void testThrowException(int number, int factor) {
        try {
            if (number % factor == 0)
                System.out.println(factor + " is a factor of " + number);
        } catch (ArithmeticException | NumberFormatException ex) {
            throw new IllegalArgumentException("Incorrect input! Please enter only numbers bigger than 0!");
        }
    }

    /**
     * @param path example:
     *             "src/lecture07/exceptions/testFile.txt"
     *             "src/lecture07/testFile1.txt"
     */
    static void testTryFinally(String path) throws IOException {
        FileInputStream fis = null;
        BufferedReader in = null;
        try {
            fis = new FileInputStream(path);
            in = new BufferedReader(new InputStreamReader(fis));
            String temp;

            while ((temp = in.readLine()) != null) {
                System.out.println(temp);
            }
        }
        //System.out.println("Print Bla bla "); Example that you can not have code between try catch finally
        finally {
            if (in != null) {
                in.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
    }
}
