package com.example.delete;

import java.util.Scanner;

public class DeletePage {

	public void deleteById() {

		DeletionApp deletionApp = new DeletionApp();

		// Getting user Input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the ID which you want to delete:: ");
		int id = scanner.nextInt();

		// Processing
		String value = deletionApp.deleteByIdOperation(id);

		// Printing the Result
		if (value.equalsIgnoreCase("Success")) {
			System.out.println("Record has been deleted successfully..!");
		} else {
			System.out.println("Oops! Record deletion operation failed..!");
		}
	}

}
