package com.bhaiti.server.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

	private static final String add = "+";
	private static final String subtract = "-";
	private static final String multiply = "*";
	private static final String divide = "/";
	
	public static void main(String args[]) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		List<String> inputList = new ArrayList<>();
		List<String> outputList = new ArrayList<>();
		try {
			System.out.println("Calculator");
			String input = bufferedReader.readLine();
			inputList = Arrays.asList(input.split(","));
			for (String splittedValue : inputList) {
				outputList.add(splittedValue);
			}
			inputSequenceValidator(outputList);
			calculate(outputList);
		} catch (Exception e) {
			System.out.println("Sequence of input should be 1st number then Operator and then 2nd number separated by comma.");
		}
	}

	private static void inputSequenceValidator(List<String> outputList) {
		if(!(outputList.get(1).equals(add) || outputList.get(1).equals(subtract)
				|| outputList.get(1).equals(multiply) || outputList.get(1).equals(divide))) {
			System.out.println("Sequence of input should be 1st number then Operator and then 2nd number separated by comma.");
		}
	}

	private static void calculate(List<String> outputList) {
		switch (outputList.get(1)) {
		case add:
			System.out.println(Float.parseFloat(outputList.get(0)) + Float.parseFloat(outputList.get(2)));
			break;
		case subtract:
			System.out.println(Float.parseFloat(outputList.get(0)) - Float.parseFloat(outputList.get(2)));
			break;
		case multiply:
			System.out.println(Float.parseFloat(outputList.get(0)) * Float.parseFloat(outputList.get(2)));
			break;
		case divide:
			System.out.println(Float.parseFloat(outputList.get(0)) / Float.parseFloat(outputList.get(2)));
			break;
		}
	}

}