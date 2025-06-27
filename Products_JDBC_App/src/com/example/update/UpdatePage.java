package com.example.update;

import java.util.Scanner;

public class UpdatePage {

	public void updateDetailsById() {
		
		UpdationApp updationApp = new UpdationApp();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Product ID:: ");
		int id = scanner.nextInt();
		
		String value = updationApp.updationOperationById(id);
		
		if(value.equalsIgnoreCase("Product not Available")) {
			System.out.println("Sorry! Entered Product ID is not available..! " + id);
		} else if (value.equalsIgnoreCase("success")) {
			System.out.println("Record Updation successfully completed..!");
		} else {
			System.out.println("Record update operation failed..!");
		}
		
	}

}
