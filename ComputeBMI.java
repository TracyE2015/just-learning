/*
 *  Author: Tracy Evans
 *  Date:  January 21, 2017
 *
 *  Filename:  ComputeBMI.java       
 *  Supporting files: none
 *	 
 *  Description: 
 *  Write a program that computes a persons BMI.    
 *  
 *  The program prompts the user to enter their weight and height (using feet and inches)
 *  and computes their BMI.
 */

import java.util.Scanner;

public class ComputeBMI {
	public static void main(String[] args){
		// Create the scanner 
		Scanner input = new Scanner(System.in);
		
		// Prompt user to enter weight in pounds
		System.out.print("Enter weight in pounds: ");
		double weight = input.nextDouble();
		
		// Prompt user to enter height using feet and inches
		System.out.print("Enter feet: ");
		double feet = input.nextDouble();
		
		System.out.print("Enter inches: ");
		double inches = input.nextDouble();
		
		final double KILOGRAMS_PER_POUND = 0.45359237;
		final double METERS_PER_INCH = 0.0254;
		final double METERS_PER_FEET = 0.3048;
		
		// Compute BMI
		double weightInKilograms = weight * KILOGRAMS_PER_POUND;
		System.out.println("Weight in kilograms: " + weightInKilograms);
		
		double feetInMeters = feet * METERS_PER_FEET;
		System.out.println("Feet in meters: " + feetInMeters);
		
		double inchesInMeters = inches * METERS_PER_INCH;
		System.out.println("Inches in meters: " + inchesInMeters);
		
		double bmi = weightInKilograms / ((feetInMeters + inchesInMeters) * (feetInMeters + inchesInMeters));
		
		// Display results
		System.out.println("BMI is " + bmi);
		if (bmi < 18.5) 
			System.out.println("Underweight");
		else if (bmi <= 24.9)
			System.out.println("Normal");
		else if (bmi <= 29.99)
			System.out.println("Overweight");
		else
			System.out.println("Obese");	
		
		input.close();
	}	
}
