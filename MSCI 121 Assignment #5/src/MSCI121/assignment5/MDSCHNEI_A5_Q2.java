// Matthew Schneider
// Assignment 5 Question 2
// March 4 2018
// This program computes the distances between three 2 dimensional points and outputs them as text
// This program takes three x-coordinates and three y-coordinates from the user that correspond to three 2 dimensional points
// This program outputs the distances between the three points, as well as six text sentences asking for the user to input coordinates


package MSCI121.assignment5;

import java.util.Scanner;

public class MDSCHNEI_A5_Q2 {
	
	public static void main(String[] args) {
		
		double[] points = new double[6];																		// creates an array to hold the x and y coordinates
		
		int arrayPos = 0;		
		Scanner scan = new Scanner(System.in);																	// readies the scanner for use
		
		for (int p = 1; p < 4; p++) {																			// creates a loop to ask the user for coordinate inputs
		
			System.out.println("Please insert the x-coordinate for point " + p + " and press enter.");			// requests an x-coordinate from the user
			points[arrayPos] = scan.nextDouble();
			arrayPos++;																							// advances the array position one slot higher
			
			System.out.println("Please insert the y-coordinate for point " + p + " and press enter.");			// requests a y-coordinate from the user
			points[arrayPos] = scan.nextDouble();
			arrayPos++;
		}
		
		Point p1 = new Point(points[0], points[1]);																// creates a point using an x and y coordinate
		Point p2 = new Point(points[2], points[3]);		
		Point p3 = new Point(points[4], points[5]);
		
		System.out.println("Distance between " + p1 + " and " + p2 + " is " + Point.getDistance(p1, p2));		// calculates distance between two points by following the method getDistance
		System.out.println("Distance between " + p1 + " and " + p3 + " is " + Point.getDistance(p1, p3));
		System.out.println("Distance between " + p2 + " and " + p1 + " is " + Point.getDistance(p2, p1));
		System.out.println("Distance between " + p2 + " and " + p3 + " is " + Point.getDistance(p2, p3));
		System.out.println("Distance between " + p3 + " and " + p1 + " is " + Point.getDistance(p3, p1));
		System.out.println("Distance between " + p3 + " and " + p2 + " is " + Point.getDistance(p3, p2));
	}
}

class Point {

	public double x;
	public double y;
	
	public String toString() {
		return "(" + x + ":" + y + ")";													// creates a convention for listing and outputting coordinates of a point
	}
		
	public Point(double X, double Y) {
		x = X;
		y = Y;
	}
	
	public static double getDistance(Point point1, Point point2) {						// defines a method to calculate distance between two points
		double xDistance = (point2.x - point1.x);
		double yDistance = (point2.y - point1.y);
		double Distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);		// calculates straight-line distance using the distance formula
		return Distance;																// outputs the calculated distance
	}
}

