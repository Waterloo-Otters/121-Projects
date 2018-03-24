// Matthew Schneider
// Assignment 7 Question 1
// March 18 2018
// This program reads the data from two files, and computes and outputs several pieces of information about the data
// This program takes two premade .csv files as input, relating to the occurrence and severity of pranks committed by people with and without invisible cloaks
// This program outputs the following data analyzations for participants with and without cloaks: Average number of pranks, Average severity of pranks, Standard Deviation of number of pranks, and Standard Deviation of severity of pranks.



package MSCI121.assignment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MDSCHNEI_A7_Q1 {

	public static void main(String[] args) {
		
		int[][] noCloakArray = new int[2][50];								// creates a multidimensional array with two embedded arrays
		
		File noCloak = new File("C:\\MSCI121\\A7Q1_nocloak.csv");			// defines the file that will be read

		try {
			Scanner scanNoCloak = new Scanner(noCloak).useDelimiter("[,\\p{javaWhitespace}]+");		// initializes a scanner for use in reading the file

			int row = 0;													// creates a new variable to keep track of the current row in the file
			
			scanNoCloak.nextLine();											// skips the first line of the data file, since we are only concerned with the integers and not the headers
			
			while (scanNoCloak.hasNextInt()) {								// continues the loop so long as there is still unread data in the file
					scanNoCloak.nextInt();									// skips the first data point of each row, since it simply denotes the participant number which always corresponds to the row variable
					noCloakArray[0][row] = scanNoCloak.nextInt();			// assigns the value in the second column of data (number of pranks) to a slot in the first array in the multidimensional noCloak array
					noCloakArray[1][row] = scanNoCloak.nextInt();			// assigns the value in the third column of data (severity of pranks) to a slot in the second array in the multidimensional noCloak array
					row++;													// moves on to the next row of data for array indexing purposes
				}
			
			scanNoCloak.close();											// closes the scanner we have been using
		} catch (FileNotFoundException e) {
		}
		
		int[][] cloakArray = new int[2][50];								// creates a multidimensional array with two embedded arrays
		
		File Cloak = new File("C:\\MSCI121\\A7Q1_cloak.csv");				// defines the file that will be read
		
		try {
			Scanner scanCloak = new Scanner(Cloak).useDelimiter("[,\\p{javaWhitespace}]+");		// initializes a scanner for use in reading the file

			int row = 0;													// creates a new variable to keep track of the current row in the file
			
			scanCloak.nextLine();											// skips the first line of the data file, since we are only concerned with the integers and not the headers
			
			while (scanCloak.hasNextInt()) {								// continues the loop so long as there is still unread data in the file
					scanCloak.nextInt();									// skips the first data point of each row, since it simply denotes the participant number which always corresponds to the row variable
					cloakArray[0][row] = scanCloak.nextInt();				// assigns the value in the second column of data (number of pranks) to a slot in the first array in the multidimensional cloak array
					cloakArray[1][row] = scanCloak.nextInt();				// assigns the value in the third column of data (severity of pranks) to a slot in the second array in the multidimensional cloak array
					row++;													// moves on to the next row of data for array indexing purposes
				}

			scanCloak.close();												// closes the scanner we have been using
		} catch (FileNotFoundException e) {
		}
		
		
		
							// Non Cloaked Data Manipulation
		
		
		double sumNumberNoCloak = 0;															// declares a variable to track the current total number of pranks
		double sumSeverityNoCloak = 0;															// declares a variable to track the current total severity of pranks
		int ParticipantNoCloak = 0;
		
		for (int i = 0; i < noCloakArray[0].length; i++) {										// creates a loop to iterate a number of times equal to the number of indices in the array
			sumNumberNoCloak = noCloakArray[0][ParticipantNoCloak] + sumNumberNoCloak;			// adds the number of pranks committed by a given non cloaked participant to the total sum of pranks committed by all non cloaked participants
			sumSeverityNoCloak = noCloakArray[1][ParticipantNoCloak] + sumSeverityNoCloak;		// adds the severity of a prank committed by a given non cloaked participant to the total sum of pranks committed by all non cloaked participants
			ParticipantNoCloak++;																// moves to the next participant
		}
		
		double avgNumberNoCloak = sumNumberNoCloak / noCloakArray[0].length;				// finds the average number of pranks by dividing the sum by the number of participants
		double avgSeverityNoCloak = sumSeverityNoCloak / noCloakArray[1].length;			// finds the average severity of pranks by dividing the sum by the number of participants
		
		
		double noCloakStdDev[][] = new double[2][50];													// creates a new array
		int ncSlot = 0;
		double sumNumberNoCloakStdDev = 0;
		double sumSeverityNoCloakStdDev = 0;
		
		for (int i = 0; i < noCloakStdDev[0].length; i++) {												// loop that repeats so long as there are still more unread data points
			noCloakStdDev[0][ncSlot] = Math.pow(noCloakArray[0][ncSlot] - avgNumberNoCloak, 2);			// subtracts each value of number of pranks committed by the mean, and squares the value and stores it in the array
			noCloakStdDev[1][ncSlot] = Math.pow(noCloakArray[1][ncSlot] - avgSeverityNoCloak, 2);		// subtracts each value of severity of pranks committed by the mean, and squares the value and stores it in the array
			
			sumNumberNoCloakStdDev = noCloakStdDev[0][ncSlot] + sumNumberNoCloakStdDev;					// sums the values for number of pranks committed that were just calculated above
			sumSeverityNoCloakStdDev = noCloakStdDev[1][ncSlot] + sumSeverityNoCloakStdDev;				// sums the values for severity of pranks committed that were just calculated above
			ncSlot++;
		}
		
		double avgNumberNoCloakStdDev = sumNumberNoCloakStdDev / noCloakStdDev[0].length;				// finds the mean of the standard deviation values for number of pranks
		double avgSeverityNoCloakStdDev = sumSeverityNoCloakStdDev / noCloakStdDev[1].length;			// finds the mean of the standard deviation values for severity of pranks
		
		double ncNumberStdDev = Math.sqrt(avgNumberNoCloakStdDev);										// square roots the mean of the standard deviation values for number of pranks to get the final standard deviation
		double ncSeverityStdDev = Math.sqrt(avgSeverityNoCloakStdDev);									// square roots the mean of the standard deviation values for severity of pranks to get the final standard deviation
		
		
		
							// Cloaked Data Manipulation


		double sumNumberCloak = 0;																// declares a variable to track the current total number of pranks
		double sumSeverityCloak = 0;															// declares a variable to track the current total severity of pranks
		int ParticipantCloak = 0;
		
		for (int i = 0; i < cloakArray[0].length; i++) {										// creates a loop to iterate a number of times equal to the number of indices in the array
			sumNumberCloak = cloakArray[0][ParticipantCloak] + sumNumberCloak;					// adds the number of pranks committed by a given cloaked participant to the total sum of pranks committed by all cloaked participants
			sumSeverityCloak = cloakArray[1][ParticipantCloak] + sumSeverityCloak;				// adds the severity of a prank committed by a given cloaked participant to the total sum of pranks committed by all cloaked participants
			ParticipantCloak++;																	// moves to the next participant
		}
		
		double avgNumberCloak = sumNumberCloak / cloakArray[0].length;						// finds the average number of pranks by dividing the sum by the number of participants
		double avgSeverityCloak = sumSeverityCloak / cloakArray[1].length;					// finds the average severity of pranks by dividing the sum by the number of participants
		
		
		
		double cloakStdDev[][] = new double[2][50];														// creates a new array
		int cSlot = 0;
		double sumNumberCloakStdDev = 0;
		double sumSeverityCloakStdDev = 0;
		
		for (int i = 0; i < cloakStdDev[0].length; i++) {												// loop that repeats so long as there are still more unread data points
			cloakStdDev[0][cSlot] = Math.pow(cloakArray[0][cSlot] - avgNumberCloak, 2);					// subtracts each value of number of pranks committed by the mean, and squares the value and stores it in the array
			cloakStdDev[1][cSlot] = Math.pow(cloakArray[1][cSlot] - avgSeverityCloak, 2);				// subtracts each value of severity of pranks committed by the mean, and squares the value and stores it in the array
			
			sumNumberCloakStdDev = cloakStdDev[0][cSlot] + sumNumberCloakStdDev;						// sums the values for number of pranks committed that were just calculated above
			sumSeverityCloakStdDev = cloakStdDev[1][cSlot] + sumSeverityCloakStdDev;					// sums the values for severity of pranks committed that were just calculated above
			cSlot++;
		}
		
		double avgNumberCloakStdDev = sumNumberCloakStdDev / cloakStdDev[0].length;						// finds the mean of the standard deviation values for number of pranks
		double avgSeverityCloakStdDev = sumSeverityCloakStdDev / cloakStdDev[1].length;					// finds the mean of the standard deviation values for severity of pranks
		
		double cNumberStdDev = Math.sqrt(avgNumberCloakStdDev);											// square roots the mean of the standard deviation values for number of pranks to get the final standard deviation
		double cSeverityStdDev = Math.sqrt(avgSeverityCloakStdDev);										// square roots the mean of the standard deviation values for severity of pranks to get the final standard deviation
		
		
		
							// Results Declarations
																																// prints all the final values calculated in the program
		System.out.println("The average number of pranks committed by a non-cloaked participant is " + avgNumberNoCloak);
		System.out.println("The average number of pranks committed by a cloaked participant is " + avgSeverityNoCloak);
		System.out.println("The average severity of a prank committed by a non-cloaked participant is " + avgNumberCloak);
		System.out.println("The average severity of a prank committed by a cloaked participant is " + avgSeverityCloak);
		System.out.println("The standard deviation of the number of pranks committed by a non-cloaked participant is " + ncNumberStdDev);
		System.out.println("The standard deviation of the number of pranks committed by a cloaked participant is " + cNumberStdDev);
		System.out.println("The standard deviation of the severity of pranks committed by a non-cloaked participant is " + ncSeverityStdDev);
		System.out.println("The standard deviation of the severity of pranks committed by a cloaked participant is " + cSeverityStdDev);
		
	}
}
