package com.java.assignment;

import javax.swing.JOptionPane;

public class TaxCalculator {

	public static int optionNumber = -1;
	public static int optionNumber2 = -1;
	public static double taxIncome;
	public static double tax;
	
	public static void main(String[] args) {
		
		TaxCalculator question = new TaxCalculator();
		
		//if option is valid
		if(question.optionValidator(question.selectOption())){
			
			//if taxIncome is valid
			if(question.incomeValidator(question.enterTaxIncome())){
				
				tax = question.getTax(optionNumber, taxIncome);
				
				if(optionNumber == 5 || optionNumber == 0){
					
				}else{
					String message = "Your tax for filing status \n"+optionNumber+""
							+ "\n for taxable Income of "+taxIncome+" naira is "
									+ "\n"+tax;
					
					if(optionNumber2 != -1){
						 message = "Your tax for filing status \n"+optionNumber+" , "+optionNumber2
								+ "\n for taxable Income of "+taxIncome+" naira is "
										+ "\n"+tax+" , "+question.getTax(optionNumber2, taxIncome);
					}
					JOptionPane.showMessageDialog(null, message, "Tax Calculator", JOptionPane.PLAIN_MESSAGE);
				}

			}else{
				JOptionPane.showMessageDialog(null, "Restart App to use");
				System.exit(0);;
			}
		}else{
			JOptionPane.showMessageDialog(null, "Restart App to use");
			System.exit(0);
		}
		
		System.exit(0);
	}

	/**
	 * Applicaton Menu
	 * @return
	 */
	public String selectOption(){
		
		String Question = "Enter filing status \n"
				+ "0. Query \n"
				+ "1. Single\n"
				+ "2. Married(Joint)\n"
				+ "3. Married(Singly)\n"
				+ "4. Head of Houehold\n"
				+ "5. Listing";
		
		//welcome to tax income calculator
		return  JOptionPane.showInputDialog(null, Question,"TAX CALCULATOR", JOptionPane.QUESTION_MESSAGE);	
	}
	
	/**
	 * get user's Taxable Income
	 * @return
	 */
	public String enterTaxIncome(){
		String Question = "Enter Taxable Income";
		return  JOptionPane.showInputDialog(null, Question,"TAX CALCULATOR", JOptionPane.QUESTION_MESSAGE);
	}
	
	/**
	 * this method validates the option selected by the user
	 * @param option
	 * @return
	 */
	public boolean optionValidator(String option) {
		
		//if user enters a string or real number
		try{
			
			if(option.contains(",")){
				String[] options = option.split(",");
				
				optionNumber = Integer.parseInt(options[0]);
				optionNumber2 = Integer.parseInt(options[1]);				
			}else{
				optionNumber = Integer.parseInt(option);
			}

		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Am sorry, you entered a wrong Option","TAX CALCULATOR", JOptionPane.ERROR_MESSAGE);
			return false;
		}catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "Goodbye","TAX CALCULATOR", JOptionPane.ERROR_MESSAGE);
			return false;			
		}
		
		
		if(!option.contains(",")){
			if(optionNumber > 5 || optionNumber < 0){
				JOptionPane.showMessageDialog(null, "Am sorry, That was not part of the option","TAX CALCULATOR", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			if(optionNumber == 0 || optionNumber == 5){
				return true;				
			}
			
		}else{
			//option should be within the range 1-4
			if((optionNumber > 4 || optionNumber < 1) || (optionNumber2 > 4 || optionNumber2 < 1)){
				JOptionPane.showMessageDialog(null, "Am sorry, comma separtated Option have to be within the range 1-4","TAX CALCULATOR", JOptionPane.ERROR_MESSAGE);
				return false;				
			}
		}
		
		return true;
	}
	
	/**
	 * Validates the user's income
	 * @param income
	 * @return
	 */
	public boolean incomeValidator(String income){
		
		//if user eneters a string of a double
		try{
			taxIncome = Double.parseDouble(income);
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Am very Sorry, you entered an Invalid income value","TAX CALCULATOR", JOptionPane.ERROR_MESSAGE);
			return false;
		}catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "Goodbye","TAX CALCULATOR", JOptionPane.ERROR_MESSAGE);
			return false;			
		}
		
		if(taxIncome < 0){
			JOptionPane.showMessageDialog(null, "Am very Sorry, you entered an Invalid income value","TAX CALCULATOR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	/**
	 * Generates tax for the selected option and the user's tax Income
	 * @param option
	 * @param taxIncome
	 * @return
	 */
	public double getTax(int option, double taxIncome){
		switch (option) {
		case 0:
			if(taxIncome == 0){
				String message = "Tax Rate  Single\n"
						+ "	10%  0-25,000\n"
						+ "15%  25,001 - 135,000\n"
						+ "20%  135,001 - 380,000\n"
						+ "30%  380,001 - 650,000\n"
						+ "34%  650,001 - 1,200,000\n"
						+ "38%  1,200,000+\n"
						+ "\n"
						+ "Tax Rate  marriedJoint\n"
						+ "10%  0-50,000\n"
						+ "15%  50,001 - 265,000\n"
						+ "20%  265,001 - 520,000\n"
						+ "30%  520,001 - 800,000\n"
						+ "34%  800,001 - 1,200,000\n"
						+ "38%  1,200,000+\n"
						+ "\n"
						+ "Tax Rate  married(Singly)\n"
						+ "10% 	0-25,000\n"
						+ "15% 	25,001 - 135,000\n"
						+ "20% 	135,001 - 330,000\n"
						+ "30% 	330,001 - 600,000\n"
						+ "34% 	600,001 - 1,200,000\n"
						+ "38% 	1,200,000+\n"
						+ "\n"
						+ "Tax Rate  HeadOfHousehold\n"
						+ "10% 	0-35,000\n"
						+ "15% 	35,001 - 165,000\n"
						+ "20% 	165,001 - 420,000\n"
						+ "30% 	420,001 - 700,000\n"
						+ "34% 	700,001 - 1,200,000\n"
						+ "38% 	1,200,000+\n";
				JOptionPane.showMessageDialog(null, message, "Tax Calculator", JOptionPane.PLAIN_MESSAGE);
				
			}else{
				JOptionPane.showMessageDialog(null, "Your filing Status is \'Single\'", "Tax Calculator", JOptionPane.PLAIN_MESSAGE);
			}
			break;
			
		case 1:
			return single(taxIncome);

		case 2:
			return marriedJoint(taxIncome);
			
		case 3:
			return marriedSingly(taxIncome);
			
		case 4:
			return headOfHousehold(taxIncome);
			
		case 5:
			
			boolean shouldStop = true;
			String message = "Listing \n "
					+ " * Income  Tax(single)  Tax(Married Joint)  Tax(Married Singly)  Tax(HeadofhouseHold)\n";
			double value = taxIncome;
			
			while(shouldStop){
				
				message += " * "+value+"  "+single(value)+"  "+marriedJoint(value)+"  "+marriedSingly(value)+"  "+headOfHousehold(value)+" \n";
				
				if(value >= 10000){
					value = value - 10000;
				}else{
					shouldStop = false;
				}
			}
			
			JOptionPane.showMessageDialog(null, message, "Tax Calculator", JOptionPane.PLAIN_MESSAGE);			
			break;
			
		default:
			break;
		}
		
		return 0;
	}

	
	public double single(double taxIncome){
		/*
		 * 10% 0-25,000
		 * 15% 25,001 - 135,000
		 * 20% 135,001 - 380,000
		 * 30% 380,001 - 650,000
		 * 34% 650,001 - 1,200,000
		 * 38% 1,200,000+
		 */
		
		if(taxIncome <= 25000){
			return percent_10(taxIncome);
			
		}else if(taxIncome > 25000 && taxIncome < 135000){
			return percent_10(25000) + percent_15(taxIncome - 25000);
			
		}else if(taxIncome > 135000 && taxIncome < 380000){
			return percent_15(135000) + percent_20(taxIncome - 135000);
			
		}else if(taxIncome > 380000 && taxIncome < 650000){
			return percent_20(380000) + percent_30(taxIncome - 380000);
			
		}else if(taxIncome > 650000 && taxIncome < 1200000){
			return percent_30(650000) + percent_34(taxIncome - 650000);
			
		}else if(taxIncome > 1200000){
			return percent_34(1200000) + percent_38(taxIncome - 1200000);
		}
		
		return 0;
	}
	
	public double marriedJoint(double taxIncome){
		/*
		 * 10% 0-50,000
		 * 15% 50,001 - 265,000
		 * 20% 265,001 - 520,000
		 * 30% 520,001 - 800,000
		 * 34% 800,001 - 1,200,000
		 * 38% 1,200,000+
		 */
		
		if(taxIncome <= 50000){
			return percent_10(taxIncome);
			
		}else if(taxIncome > 50000 && taxIncome < 265000){
			return percent_10(50000) + percent_15(taxIncome - 50000);
			
		}else if(taxIncome > 265000 && taxIncome < 520000){
			return percent_15(265000) + percent_20(taxIncome - 265000);
			
		}else if(taxIncome > 520000 && taxIncome < 800000){
			return percent_20(520000) + percent_30(taxIncome - 520000);
			
		}else if(taxIncome > 800000 && taxIncome < 1200000){
			return percent_30(800000) + percent_34(taxIncome - 800000);
			
		}else if(taxIncome > 1200000){
			return percent_34(1200000) + percent_38(taxIncome - 1200000);
		}
		
		return 0;
	}
	
	public double marriedSingly(double taxIncome){
		/*
		 * 10% 0-25,000
		 * 15% 25,001 - 135,000
		 * 20% 135,001 - 330,000
		 * 30% 330,001 - 600,000
		 * 34% 600,001 - 1,200,000
		 * 38% 1,200,000+
		 */
		
		if(taxIncome <= 25000){
			return percent_10(taxIncome);
			
		}else if(taxIncome > 25000 && taxIncome < 135000){
			return percent_10(25000) + percent_15(taxIncome - 25000);
			
		}else if(taxIncome > 135000 && taxIncome < 330000){
			return percent_15(135000) + percent_20(taxIncome - 135000);
			
		}else if(taxIncome > 330000 && taxIncome < 600000){
			return percent_20(330000) + percent_30(taxIncome - 330000);
			
		}else if(taxIncome > 600000 && taxIncome < 1200000){
			return percent_30(600000) + percent_34(taxIncome - 600000);
			
		}else if(taxIncome > 1200000){
			return percent_34(1200000) + percent_38(taxIncome - 1200000);
		}
		
		return 0;
	}
	
	public double headOfHousehold(double taxIncome){
		/*
		 * 10% 0-35,000
		 * 15% 35,001 - 165,000
		 * 20% 165,001 - 420,000
		 * 30% 420,001 - 700,000
		 * 34% 700,001 - 1,200,000
		 * 38% 1,200,000+
		 */
		
		if(taxIncome <= 35000){
			return percent_10(taxIncome);
			
		}else if(taxIncome > 35000 && taxIncome < 165000){
			return percent_10(35000) + percent_15(taxIncome - 35000);
			
		}else if(taxIncome > 165000 && taxIncome < 420000){
			return percent_15(165000) + percent_20(taxIncome - 165000);
			
		}else if(taxIncome > 420000 && taxIncome < 700000){
			return percent_20(420000) + percent_30(taxIncome - 420000);
			
		}else if(taxIncome > 700000 && taxIncome < 1200000){
			return percent_30(700000) + percent_34(taxIncome - 700000);
			
		}else if(taxIncome > 1200000){
			return percent_34(1200000) + percent_38(taxIncome - 1200000);
		}
		
		return 0;
	}
	
	public double percent_10(double value){
		return 0.10 * value;
	}
	
	public double percent_15(double value){
		return 0.15 * value;
	}
	
	public double percent_20(double value){
		return 0.20 * value;
	}
	
	public double percent_30(double value){
		return 0.30 * value;
	}
	
	public double percent_34(double value){
		return 0.34 * value;
	}
	
	public double percent_38(double value){
		return 0.38 * value;
	}
	
}
