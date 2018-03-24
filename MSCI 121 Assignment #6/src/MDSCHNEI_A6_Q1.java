// Matthew Schneider
// Assignment 6 Question 1
// March 11 2018
// This program creates a histogram of an array of integers and outputs their frequency as text. It also calculates and outputs the median of a second set of integers.
// This program takes no direct input, other than the length of the integer arrays.
// This program outputs the frequency of integers in the first array as text, and calculates and outputs the median of the second set of integers as text.



public class MDSCHNEI_A6_Q1 {

	public static void main(String[] args) {

		java.util.Random rnd = new java.util.Random();

		int[] integers = new int[100];		// creates a new integer array with 100 indices
		
		for (int i = 0; i < integers.length; i++) {		// fills the array with random integers between 0 and 99
			integers[i] = rnd.nextInt(100);
		}
        
     //   System.out.println(java.util.Arrays.toString(integers));	  //  can be used to check that the histogram is correct

		
		int[] histogram = new int[100];		// creates a new integer array with 100 indices to act as the histogram data set
						
		for (int b = 0; b < 100; b++) {		// adds one to each value of a histogram array every time the corresponding value is found in the integers array
			int tally = integers[b];
			histogram[tally]++;
		}
		
	 //   System.out.println(java.util.Arrays.toString(histogram));	  // can be used to check that the histogram is correct
	    
	    for (int results = 0; results < 100; results++) {
	    	if (histogram[results] != 0) {
	    		System.out.print("The integer " + results + " occurs " + histogram[results]);	// prints a statement declaring each integer's non-zero frequency	
	    	}
	    	
	    	if (histogram[results] == 1) {
	    		System.out.println(" time in the data set.");	// for proper grammar
	    	}
	    	
	    	if (histogram[results] > 1) {
	    		System.out.println(" times in the data set.");	// also for proper grammar
	    	}
	    }		
	    
	    
	    
	    
	   // pertains to part b
	    
		int[] oddIntegers = new int[101];		// creates a new integer array with 99 indices
		
		for (int i = 0; i < oddIntegers.length; i++) {		// fills the array with random integers between 0 and 99
			oddIntegers[i] = rnd.nextInt(100);
		}
   		
		int[] oddHistogram = new int[101];		// creates a new integer array with 99 indices to act as the histogram data set
						
		for (int b = 0; b < 101; b++) {		// adds one to each value of the oddHistogram array every time the corresponding value is found in the oddIntegers array
			int oddTally = oddIntegers[b];	
			oddHistogram[oddTally]++;
		}
	    
	    int[] numericalSet = new int[101];		// creates a new integer array with 101 indices
	    
    	int index = 0;
    	
	    for (int value = 0; value < 101; value++) {			// sorts the integers in the new array by numerical order
	    	for (int p = 0; p < oddHistogram[value]; p++) {
	    		numericalSet[(index)] = value;
	    		index ++;
	    	}		    	
	    }
	    System.out.println();
    	System.out.println("The median of the second, odd, dataset is " + numericalSet[(numericalSet.length / 2)] + ".");		// declares the median of the dataset
    	
	}														// note that this is not the same dataset used in part a, and thus does not follow the printed histogram text
}