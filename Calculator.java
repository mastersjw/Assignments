package com.mastersjw.calculator;
import java.util.ArrayList;

public class Calculator implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private double num1;
	private double num2;
	private String operator;
	private double result;
	private ArrayList<Object> s;
	
	public Calculator() {
		s = new ArrayList<Object>();
	}

	public void performOperation() {
		if(this.operator.equals("+")) result = this.num1 + this.num2;
		else if(this.operator.equals("-")) result= this.num1-this.num2;
		else if(this.operator.equals("*")) result = this.num1*this.num2;
		else if(this.operator.equals("/")) result = this.num1/this.num2;
		else System.out.println("Error Bad input");
	}
	
	//overload method that takes in a String
	public void performOperation(String op) {
		//if not and equals then just add it the array list
		if (!op.equals("=")) s.add(op);
		//else run through the array list left to right performing operations
		else {			
			//going to go through the array list setting num1,num2,operator then call perform operation
			//and put the result on the front of the arrayList
			while (!s.isEmpty() && s.size() !=1) {
				this.num1 = (double)s.get(0);
				s.remove(0);
				this.operator = (String)s.get(0);
				s.remove(0);
				this.num2 = (double)s.get(0);
				s.remove(0);
				this.performOperation();
				s.add(0,result);
			}
			//only 1 item in arrayList. set to result and remove it
			if(s.size()==1) {
				result = (double)s.get(0);
				s.remove(0);
			}
		}
	}
	
	public void performOperation(double num) {
		//if not first number in equation look at last operator inputed 
		if(!s.isEmpty()) {
			String peek = (String)s.get(s.size()-1);
			//check operator.if mult/div we can do operation right away
			//set num1,num2,operator remove them along the way then call perform operation
			if(peek.equals("*") || peek.equals("/")) {
				this.operator = (String)(s.get(s.size()-1));
				s.remove(s.size()-1);
				this.num2 = num;
				this.num1 = (double)(s.get(s.size()-1));
				s.remove(s.size()-1);
				this.performOperation();
				s.add(result);
			}
			//the last operand was a + or - so just add the number
			else s.add(num);
		}
		//first number in equation..add it
		else s.add(num);
	}
	
	public double getResults() {
		return result;
	}
}