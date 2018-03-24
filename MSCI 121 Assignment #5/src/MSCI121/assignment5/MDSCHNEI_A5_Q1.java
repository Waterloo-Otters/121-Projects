// Matthew Schneider
// Assignment 5 Question 1
// March 4 2018
// This program creates additional functionalities for arrays, including adding functions for adding and removing index elements
// This program takes two indices as input for the array indices to remove and insert in, and one integer as a value to insert in the array
// This program outputs three copies of the same array, with changes between each due to the insertion and removal of indices in the array


package MSCI121.assignment5;

public class MDSCHNEI_A5_Q1 {

	public static void main(String[] args) {
		
		int[] values = new int[10];
		
		java.util.Random random = new java.util.Random();			// creates random values to insert into the array
		for (int i = 0; i < values.length; i++) {
			values[i] = random.nextInt();
		}
		
		Array array = new Array(values);
		
		System.out.println( array );
		
		array.remove(2);											// calls the remove method for position 2 of the array
		
		System.out.println( array );
		
		array.insert( random.nextInt(), 5 );						// calls the insert method for position 5 of the array and a random integer
		
		System.out.println( array );
	}	
}

class Array {
	
	private int[] values;

	/**
	 * Creates a new Array object.
	 * @param values Integer array holding the values
	 */
	public Array(int[] values) {
		this.values = values;
	}
	
	/**
	 * Adds an integer to the Array at a given index.
	 * @param value The values of the integer
	 * @param index The index where the integer will be added
	 */
	public void insert(int value, int index) {
		int[] newPos = new int[values.length + 1];                             		// sets a new array to be of a length one value longer than it currently is
		int newPosIdx = 0;
		
		for (int oldPosIdx = 0; oldPosIdx < values.length; oldPosIdx++) {			// creates a loop to cycle a number of times equal to the array's length
			if (oldPosIdx != index) {  												// for all array indices except the one corresponding to the insertion point, copy the old array value into the new array
				newPos[newPosIdx] = values[oldPosIdx];                    
				newPosIdx++;    													// move to the next array position
			}
			if (oldPosIdx == index) {												// when the array position to be replaced is reached, instead insert the chosen value
				newPos[newPosIdx] = value;
				newPosIdx++;
				newPos[newPosIdx] = values[oldPosIdx];								// manually inserts the next array index to ensure nothing is unintentionally overwritten by the loop and if statement
				newPosIdx++;
			}
		}
		
		values = newPos;															// assigns the old array to the new one
	}
	
	/**
	 * Removes an integer from the Array. The new array has one element fewer than before.
	 * @param index Index of the integer
	 */
	public void remove(int index) {
		
		int[] newValues = new int[values.length - 1];                              // array for new values.
		int newValuesIdx = 0;                                                      // index for iterating through the new array
		
		for (int oldValuesIdx = 0; oldValuesIdx < values.length; oldValuesIdx++) { // Loops through the current array to copy values, ...
			if (oldValuesIdx != index) {                                           // ... but skips the index that should be removed.
				newValues[newValuesIdx] = values[oldValuesIdx];                    // the actual copy
				newValuesIdx++;                                                    // increment index for new array
			}
		}
		
		values = newValues;                                                        // Assign the new array to the old one.
	}

	/**
	 * Creates a human-readable String holding the values of this Array.
	 */
	public String toString() {
		return java.util.Arrays.toString(values);
	}
	
}
