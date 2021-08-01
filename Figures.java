import java.util.Scanner;

public class Figures {

    public static void main(String[] args) {
        // declare variables
        int size, option;
        String strMenu = "MENU: " + "\n" + "1. Print box" + "\n" + "2. Print diamond" + "\n" + "3. Print X" +
            "\n" + "4. Quit program";

        Scanner sc = new Scanner(System.in); // create scanner 

        System.out.println("Programming Fundamentals");
        System.out.println("NAME: Seth Howells");
        System.out.println("PROGRAMMING ASSIGNMENT 2");
        System.out.println();
        System.out.print("Enter the size of the figure (odd number): ");

        size = sc.nextInt(); // user input equals size dimension of figure


        // while-loop to prompt user to re-enter if number is not odd
        while (size % 2 == 0) {
            System.out.println("Invalid figure size - must be an odd number");
            System.out.println();
            System.out.print("Re-enter the size of the figure: ");
            size = sc.nextInt();
        }

        // if user number is odd, automatically prompt the menu
        System.out.println(strMenu);
        System.out.println();
        System.out.print("Please select an option: ");

        option = sc.nextInt();

        // while-loop to prompt option type
        // create switch for keyboard input to map to type of method
        while (option != 4) {
            switch (option) {
                case 1:
                    System.out.println();
                    printBox(size);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    printDiamond(size);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    printX(size);
                    System.out.println();
                    break;
            }

            System.out.println(strMenu);
            System.out.println();
            System.out.print("Please select an option: ");

            option = sc.nextInt();
        }
        // if option 4 selected, end program
        System.out.println("Good bye!");
        System.exit(0);

        sc.close(); // close scanner
    }


    // Box figure method
    static void printBox(int size) {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    // Diamond figure method
    static void printDiamond(int size) {
        int diamondSize = (size / 2); // format size

        // nested for-loop for top half of diamond
        for (int i = 1; i <= diamondSize + 1; i++) // Limit rows to half of size (plus one) 
        {
            for (int j = 1; j <= (diamondSize + 1) - i; j++) // spacing
            {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i; k++) // x for each row in i
            {
                if (k == 1 || k == 2 * i) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

        // nested for-loop for bottom half of diamond
        for (int i = 1; i <= diamondSize; i++) { // Limit rows to half of size 
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * (diamondSize - i) + 2; k++) {
                if (k == 1 || k == 2 * (diamondSize - i) + 2) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }

    }

    // X figure method
    static void printX(int size) {
        for (int rows = 1; rows <= size; rows++) { // get table for n rows
            for (int cols = 1; cols <= size; cols++) { // get table for n columns
                // if i = j prints right downward diagonal
                // if i +j = size +1 print left downward diagonal
                if (rows == cols || rows + cols == size + 1) {
                    System.out.print("X"); // Print both diagonal lines
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Wrap each line after printing.
        }
    }
}