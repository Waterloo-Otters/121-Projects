// Matthew Schneider
// Assignment 6 Question 2
// March 11 2018
// This program counts the occurrence of the first four prime factors in an integer and outputs them. It also returns the remainder after division by the prime factors.
// This program takes one integer from the user as input.
// This program outputs the occurrence of the first four prime numbers in the chosen integer's prime factorization, as well as an expression equal to the chosen number using the prime factors and the remainder after division.



public class MDSCHNEI_A6_Q2 {

	static final int[] PRIME_NUMBERS = { 2, 3, 5, 7 };						// defines the first four prime numbers in an array
	
	public static void main(String[] args) {
		
		System.out.println("Please input an integer to be analyzed.");		// asks the user for an integer to be tested by the method
		
		java.util.Scanner scan = new java.util.Scanner(System.in);
		int number = scan.nextInt();										// uses the scanner to receive an integer from the user
		scan.close();
		
		printPrimeFactors(number);											// calls the method created below
	}
		
	static void printPrimeFactors(int number) {
		
		int originalNumber = number;										// saves the original value of the variable number for later use
		
		int[] primeCount = new int[4];										// creates an array to hold the prime factor tallies
		
		while (number % 2 == 0) {											// if the number is divisible by 2 with no remainder, adds 1 to the tally for prime factor 2
			primeCount[0]++;												// increases the tally by 1
			number = number / 2;											// divides the number by 2 and tests again if it is divisible by 2 with no remainder
		}
			
		while (number % 3 == 0) {											// repeats previous steps for the prime factor 3
			primeCount[1]++;
			number = number / 3;
		}

		while (number % 5 == 0) {											// repeats previous steps for the prime factor 5
			primeCount[2]++;
			number = number / 5;
		}
		
		while (number % 7 == 0) {											// repeats previous steps for the prime factor 7
			primeCount[3]++;
			number = number / 7;
		}

		for (int i = 0; i < primeCount.length; i++) {
			System.out.println(PRIME_NUMBERS[i] + ": " + primeCount[i]);
		}
		
		
		// for part b
		
		System.out.print(originalNumber + ": ");							// prints the originally defined value of number
		
		for (int count2 = primeCount[0]; count2 > 0; count2--) {			// prints "2 * " an amount of times equal to the amount of times that 2 appears in the prime factorization of the original number
			System.out.print("2 * ");
		}
		for (int count3 = primeCount[1]; count3 > 0; count3--) {			// repeats previous steps for prime factor 3
			System.out.print("3 * ");
		}
		for (int count5 = primeCount[2]; count5 > 0; count5--) {			// repeats previous steps for prime factor 5
			System.out.print("5 * ");
		}
		for (int count7 = primeCount[3]; count7 > 0; count7--) {			// repeats previous steps for prime factor 7
			System.out.print("7 * ");
		}
		
		System.out.print(number);											// prints the final value of the variable number, which represents the remainder after prime factor division			
	
	}
}
