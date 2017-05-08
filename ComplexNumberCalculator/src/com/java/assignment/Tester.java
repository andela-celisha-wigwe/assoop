package com.java.assignment;

import java.util.Scanner;

public class Tester {

	//complex number = a + bi i.e realNumber + imaginaryNumber*i;
	double realNumber = 0;
	double imaginaryNumber = 0;
	static boolean validInitialValue = false; 
	static boolean continueOperation = true;
	
	public static void main(String[] args) {
		
		ComplexNumber complexNumber = new ComplexNumber();
		
		Scanner userInput = new Scanner(System.in);
		String[] userOperation = null;
		String resultOutput = "";
		
//		System.out.println("Welcome to the complex number calculator.");
//		System.out.println("=========================================");
//		
		while(!validInitialValue){
			System.out.print("Please enter the initial complex number,  Acceptable format is a+bi : ");			
			try {
				complexNumber.splitter(userInput.nextLine());
			} catch (Exception e) {
				
			}
			
			if(ComplexNumber.realNumber == 0 && ComplexNumber.imaginaryNumber == 0){
				System.out.println("Invalid complex number. Acceptable format is a+bj");
			}else{
				validInitialValue = true;
			}		
		}

		while (continueOperation) {
			
			System.out.println("you can perform any operation. sample format .? add 3.2+j2.4");
			userOperation = userInput.nextLine().split(" ");
			
			if(userOperation.length <= 1 || userOperation == null){
				System.out.println("Please provide a vaild operation format");
				continue;
			}else if(userOperation.length == 2){
				
				//End the program
				if(userOperation[1].equalsIgnoreCase("end")){
					System.out.println("Goodbye");
					continueOperation = false;
					break;
				}
				
				if(userOperation[1].equalsIgnoreCase("mag")){
					resultOutput = ComplexNumber.magnitude()+"";
				}
				
				if(userOperation[1].equalsIgnoreCase("cnj")){
					resultOutput = ComplexNumber.conjugate();
				}
				
				if(userOperation[1].equalsIgnoreCase("ang")){
					resultOutput = ComplexNumber.angle()+"";
				}
				
			}else if(userOperation.length == 3){
				
				Tester tester = new Tester();
				tester.splitter(userOperation[2]);

				complexNumber.userRealNumber = tester.realNumber;
				complexNumber.userImaginaryNumber = tester.imaginaryNumber;
				
				if (userOperation[1].equalsIgnoreCase("add") || userOperation[1].equalsIgnoreCase("+")) {
					resultOutput = complexNumber.add(complexNumber);
				}
				if (userOperation[1].equalsIgnoreCase("substract") || userOperation[1].equalsIgnoreCase("-")) {
					resultOutput = complexNumber.substract(complexNumber);
				}
				if (userOperation[1].equalsIgnoreCase("multiply") || userOperation[1].equalsIgnoreCase("*")) {
					resultOutput = complexNumber.multiple(complexNumber);
				}
				if (userOperation[1].equalsIgnoreCase("division") || userOperation[1].equalsIgnoreCase("/")) {
					resultOutput = complexNumber.divide(complexNumber);
				}	
				if(userOperation[1].equalsIgnoreCase("mag")){
					resultOutput = complexNumber.magnitude(complexNumber)+"";
				}
				
				if(userOperation[1].equalsIgnoreCase("cnj")){
					resultOutput = complexNumber.conjugate(complexNumber);
				}
				
				if(userOperation[1].equalsIgnoreCase("ang")){
					resultOutput = complexNumber.angle(complexNumber)+"";
				}
				
			}else if(userOperation.length == 4){
				
				Tester tester = new Tester();
				tester.splitter(userOperation[1]);

				complexNumber.userRealNumber = tester.realNumber;
				complexNumber.userImaginaryNumber = tester.imaginaryNumber;
				
				ComplexNumber complexNumber2 = new ComplexNumber();
				tester.splitter(userOperation[3]);

				complexNumber2.userRealNumber = tester.realNumber;
				complexNumber2.userImaginaryNumber = tester.imaginaryNumber;				
				
				if (userOperation[2].equalsIgnoreCase("add") || userOperation[2].equalsIgnoreCase("+")) {
					resultOutput = complexNumber.add(complexNumber, complexNumber2);
				}
				if (userOperation[2].equalsIgnoreCase("substract") || userOperation[2].equalsIgnoreCase("-")) {
					resultOutput = complexNumber.substract(complexNumber, complexNumber2);
				}
				if (userOperation[2].equalsIgnoreCase("multiply") || userOperation[2].equalsIgnoreCase("*")) {
					resultOutput = complexNumber.multiple(complexNumber, complexNumber2);
				}
				if (userOperation[2].equalsIgnoreCase("division") || userOperation[2].equalsIgnoreCase("/")) {
					resultOutput = complexNumber.divide(complexNumber, complexNumber2);
				}				
			}
			
				System.out.println("The output is " + resultOutput);
				System.out.println("Enter .? end to quit.");				

		}
	    
	}
	
	/**
	 * Split user input
	 * @param complex
	 */
	public void splitter(String complex){
		
		String[] splittedString = null;
		if(complex.contains("+")){
			splittedString = complex.split("\\+");
			imaginaryNumber = splittedString != null ? Double.parseDouble(splittedString[1].replace("j", "").replace("i", "")) : 0;
		}
		else if(complex.contains("-")){
			splittedString = complex.split("\\-");
			imaginaryNumber = -1 * (splittedString != null ? Double.parseDouble(splittedString[1].replace("j", "").replace("i", "")) : 0);
		}
		else{
			imaginaryNumber = Double.parseDouble(complex.replace("j", "").replace("i", ""));
		}
		
			realNumber = splittedString != null ? Double.parseDouble(splittedString[0]) : 0;
	}

}
