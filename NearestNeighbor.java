import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class NearestNeighbor {
	
	 public static final String delimiter = ","; 
	
    //-----------------------------------------------------------------
    // Distance formula to calculate distance between 
	  // training rows and test rows
    //-----------------------------------------------------------------
	  private static double DistanceCalc(double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4) {
    double distance = Math.sqrt(Math.pow((x1 - y1), 2) + Math.pow((x2 - y2), 2) + Math.pow((x3 - y3), 2) + Math.pow((x4 - y4), 2));
    	return distance;
    }
	    
    //-----------------------------------------------------------------
    // Count correctly predicted classes
    //-----------------------------------------------------------------
	  private static int AccuracyCalc(String[] predicted, String[] actual) {
		int countMatch = 0;
        if (predicted.length == actual.length) {
            for (int i = 0; i < predicted.length; i++) {
                if (predicted[i].equals(actual[i])) {
                	countMatch++;
                }
            }
        }
        return countMatch;
        
    }
	    
    //-----------------------------------------------------------------
    // Calculate accuracy: correctly predicted / total rows
    //-----------------------------------------------------------------
	  // return accuracy defined as correct divided by total
    private static double AccuracyScore(double correct, int total) {
        double accuracy = correct / total;
        return accuracy;
    }
	
	

    public static void main(String[] args) throws FileNotFoundException {

    	// Header info
        System.out.println("Programming Fundamentals");
        System.out.println("NAME: Seth Howells");
        System.out.println("PROGRAMMING ASSIGNMENT 3");
        System.out.println();
    	
        
        //-----------------------------------------------------------------
        // Step 1: Prepare for file reading
        //-----------------------------------------------------------------
        
        String CSVtrain, CSVtest;
        Scanner fileScanTrain, fileScanTest;
        String rowScanTrain, rowScanTest;

        // create 1D string array for classes
        String[] trainClass = new String[75];
        String[] testClass = new String[75];
        
        // create 2D array for all CSV data +++
        double[][] trainData = new double[75][4];
        double[][] testData = new double[75][4];
        
        int count = 0; // initialize count to 0

        // Variables for training (x) and testing (y)
        double x1, x2, x3, x4;
        double y1, y2, y3, y4;

        double globalMin = Integer.MAX_VALUE;

        
        //-----------------------------------------------------------------
        // Step 2: User prompt for training and testing files
        //-----------------------------------------------------------------
       
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the name of the training file: ");
        CSVtrain = scan.nextLine();
        File file1 = new File(CSVtrain);
        fileScanTrain = new Scanner(file1);

        System.out.print("Enter the name of the testing file: ");
        CSVtest = scan.nextLine();
        File file2 = new File(CSVtest);
        fileScanTest = new Scanner(file2);

        
        //-----------------------------------------------------------------
        // Step 3: Reads CSV files into separate arrays.
        //-----------------------------------------------------------------

        // Training CSV file
        while (fileScanTrain.hasNext()) {
            // Reads each row as one string 
            rowScanTrain = fileScanTrain.nextLine(); 
            // Separate values in each string by comma, string --> string array
            String[] strArray = rowScanTrain.split(delimiter); 
            
            // all columns except for last (classification)
            for (int i = 0; i < strArray.length - 1; i++) {
                String eleStrTrain = strArray[i];
                double eleDouTrain = Double.parseDouble(eleStrTrain);
                trainData[count][i] = eleDouTrain;
            }
            // only last column (classification)
            trainClass[count] = strArray[4];
            count++;
        }
        
        count = 0;	// reset count

        // Testing CSV file - same method as training while-loop
        while (fileScanTest.hasNext()) {
            rowScanTest = fileScanTest.nextLine(); 
            String[] strArray = rowScanTest.split(","); 

            for (int i = 0; i < strArray.length - 1; i++) {
                String eleStrTest = strArray[i];
                double eleDouTest = Double.parseDouble(eleStrTest);
                testData[count][i] = eleDouTest;
            }
            testClass[count] = strArray[4];
            count++;
        }

        
        //-----------------------------------------------------------------
        // Step 3: Classifies each testing example
        //-----------------------------------------------------------------

        System.out.println("\n" + "EX#: TRUE LABEL, PREDICTED LABEL");

        String[] predicted = new String[75];

        // Assign numeric test-file values to variables
        for (int i = 0; i < testData.length; i++) {
            y1 = testData[i][0];
            y2 = testData[i][1];
            y3 = testData[i][2];
            y4 = testData[i][3];
            // Assign numeric training-file values to variables
            for (int j = 0; j < trainData.length; j++) {
                x1 = trainData[j][0];
                x2 = trainData[j][1];
                x3 = trainData[j][2];
                x4 = trainData[j][3];

                // Compute distance for training and testing rows
                double output = DistanceCalc(x1, x2, x3, x4, y1, y2, y3, y4);
                if (output < globalMin) {
                    globalMin = output;
                    int minIndex = j;
                    predicted[i] = trainClass[minIndex];
                }
            }
            globalMin = Integer.MAX_VALUE;
            // print count of rows (1 to 75), with actual and predicted classes
            System.out.println((i + 1) + ": " + testClass[i] + " " + predicted[i]);
        }

        
        //-----------------------------------------------------------------
        // Step 4: Calculate accuracy of predicted versus actual
        //-----------------------------------------------------------------
        
        int match = AccuracyCalc(trainClass, predicted);
        double accuracy = AccuracyScore(match, testClass.length);
        System.out.println("ACCURACY: " + accuracy);

        // Close the scanners
        fileScanTrain.close();
        fileScanTest.close();
        scan.close();
    }
}
