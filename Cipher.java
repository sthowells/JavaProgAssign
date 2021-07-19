import java.util.Random;
import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        // header information
        System.out.println("Sample Output 1");
        System.out.println("Programming Fundamentals");
        System.out.println("NAME:  Seth Howells");
        System.out.println("PROGRAMMING ASSIGNMENT 1");
        System.out.println();
        System.out.println("Welcome to the Cipher program.");
        System.out.println("Please enter 5 numbers between 0 and 19");

        // creates scanner object 
        Scanner sc = new Scanner(System.in);

        // step 1
        // prompt user for five numbers between 0 to 19
        // conditional statement exits program if input is out of range
        System.out.print("1st number: ");
        int firstNum = sc.nextInt();
        if (firstNum > 19 || firstNum < 0) {
            System.out.println("Please read directions and try again!");
            System.exit(0);
        }

        System.out.print("2nd number: ");
        int secondNum = sc.nextInt();
        if (secondNum > 19 || secondNum < 0) {
            System.out.println("Please read directions and try again!");
            System.exit(0);
        }

        System.out.print("3rd number: ");
        int thirdNum = sc.nextInt();
        if (thirdNum > 19 || thirdNum < 0) {
            System.out.println("Please read directions and try again!");
            System.exit(0);
        }

        System.out.print("4th number: ");
        int fourthNum = sc.nextInt();
        if (fourthNum > 19 || fourthNum < 0) {
            System.out.println("Please read directions and try again!");
            System.exit(0);
        }


        System.out.print("5th number: ");
        int fifthNum = sc.nextInt();
        if (fifthNum > 19 || fifthNum < 0) {
            System.out.println("Please read directions and try again!");
            System.exit(0);
        }

        // close scanner    
        System.out.println();
        sc.close();

        // step 2
        // sum of the five user input numbers
        int plaintext = firstNum + secondNum + thirdNum + fourthNum + fifthNum;
        System.out.println("Total = " + plaintext);

        // step 3
        // creates parameters for random number generation, 
        // in a range of 0 to 9 inclusive
        int minnumber = 0;
        int maxnumber = 9;
        Random gen = new Random();
        int key = minnumber + gen.nextInt(maxnumber - minnumber);
        System.out.println("Your random key is " + key);

        // step 4
        // separate the tens for the ones digits of Total (plain text)
        int onesPlace = plaintext % 10;
        int tensPlace = (plaintext - onesPlace) / 10;

        // Caesar Code equations, output are digits for encoded number
        int encNum1 = (tensPlace + key) % 10;
        int encNum2 = (onesPlace + key) % 10;

        // convert encoded digits to string then combine string
        String encoded1 = String.valueOf(encNum1);
        String encoded2 = String.valueOf(encNum2);
        String encodedNum = encoded1 + encoded2;
        System.out.println("Your encoded number is  " + encodedNum);
    }
}

