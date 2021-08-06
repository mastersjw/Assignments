package com.mastersjw.calculator;

public class Test {
	
	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		
		c1.performOperation(3);
		c1.performOperation("+");
		c1.performOperation(5);
		c1.performOperation("*");
		c1.performOperation(10);
		c1.performOperation("/");
		c1.performOperation(5);
		c1.performOperation("+");
		c1.performOperation(2);
		c1.performOperation("-");
		c1.performOperation(1);
		
		c1.performOperation("=");
		System.out.println(c1.getResults());
	}
}
