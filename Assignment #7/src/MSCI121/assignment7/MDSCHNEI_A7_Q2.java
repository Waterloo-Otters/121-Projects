// Matthew Schneider
// Assignment 7 Question 2
// March 18 2018
// This program reads a text file containing paragraphs of text, and  the document's word count, character count, and paragraph count
// This program takes a text file containing text as input
// This program outputs the number of words, the number of characters excluding spaces, and the number of paragraphs in the text document.



package MSCI121.assignment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MDSCHNEI_A7_Q2 {
	
	public static void main(String[] args) {
		
		File doc = new File("C:\\MSCI121\\A7Q2.txt");				// points Java to the file's location so it can be used
		
		try {
			Scanner scanDoc = new Scanner(doc);						// initiates a scanner to read the document
			
			int wordTotal = 0;										// declares a variable for the word count
					
			while (scanDoc.hasNext()) {								// creates a loop that counts each successive word in the document, so long as there are more words left to read
				scanDoc.next();
				wordTotal++;
			}
						
			int spaceCount = wordTotal - 1;							// the number of spaces is equal to the number of words, minus 1 because of the first word
			int charTotal = (int) doc.length();						// counts the total number of characters in the document
			int charTotalExSpaces = charTotal - spaceCount;			// subtracts the number of spaces from the total character count
			
			System.out.println("The number of words in the document is " + wordTotal);
			System.out.println("The number of characters in the document, excluding spaces, is " + charTotalExSpaces);
			
			scanDoc.close();										// closes the scanner
			
			
			int paragraphCount = 1;									// declares a variable to count paragraphs, but the first one will not be counted by our program so we start with 1 paragraph
			
			Scanner scanDocPara = new Scanner(doc);					// initiates a new scanner to the same document, in order to start from the top again
			while (scanDocPara.hasNextLine()) {						// loop continues so long as there are more lines left in the document
				if (scanDocPara.nextLine().length() < 1) {			// if there are no characters in the next line of the document, add 1 to the paragraph total
					paragraphCount++;
				}
			}

			scanDocPara.close();									// closes the scanner
			
			System.out.println("The number of paragraphs in the document is " + paragraphCount);	
			
		} catch (FileNotFoundException e) {
		}
	}
}

