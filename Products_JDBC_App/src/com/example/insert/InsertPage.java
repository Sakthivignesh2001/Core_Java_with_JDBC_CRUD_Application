package com.example.insert;

import java.util.Scanner;

public class InsertPage {

	public void insertOperation() {
		
		InsertionApp insertionApp = new InsertionApp();
		
		// Getting Dynamic Input for perform operation.
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the Product Name:: ");
		String productName = scanner.next();

		System.out.println("Enter the Product Price:: ");
		int productPrice = scanner.nextInt();

		System.out.println("Enter the Product Catagory:: ");
		String productCatagory = scanner.next();

		System.out.println("Enter the Product Quantity:: ");
		int productQuantity = scanner.nextInt();

		// Performing Insertion Operation.
		String value = insertionApp.insetionOperation(productName, productPrice, productCatagory, productQuantity);
		
		// Printing the Performance Result.
		if (value.equalsIgnoreCase("Success")) {
			System.out.println("Record inserted successfully..!");
		} else {
			System.out.println("Oops! Record insertion failed.");
		}

	}

}
