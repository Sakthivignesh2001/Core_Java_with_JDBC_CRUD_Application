package com.example;

import java.util.Scanner;

import com.example.delete.DeletePage;
import com.example.insert.InsertPage;
import com.example.retrieve.RetrievePage;
import com.example.update.UpdatePage;

public class MenuPage {

	public static void displayMenu() {

		MenuPage menuPage = new MenuPage();

		// Displaying the Operation List
		menuPage.showList();

		// Collection Dynamic input
		int value = menuPage.getInput();

		// Based on the 'Value' Performing the operation
		switch (value) {

		case 1:
			menuPage.getAllDetailsPage();
			break;

		case 2:
			menuPage.insetionOperationPage();
			break;

		case 3:
			menuPage.getDetailsByIdPage();
			break;

		case 4:
			menuPage.updationOperationPage();
			break;

		case 5:
			menuPage.deleteOperationPage();
			break;

		case 0:
			System.out.println("-----------------------------");
			System.out.println("Terminating the Application");
			System.out.println("-----------------------------");
			System.exit(value);
			break;

		default:
			System.out.println("Please Enter valid number..!");
			break;
		}

	}

	private void showList() {
		
		System.out.println("Press 1 for Get All Details Operation");
		System.out.println("Press 2 for Insertion Operation");
		System.out.println("Press 3 for Get Details By ID Operation");
		System.out.println("Press 4 for Update Operation");
		System.out.println("Press 5 for Delete Operation");
		System.out.println("Press 0 for exit");
		System.out.println("-------------------------------------------");

	}

	private int getInput() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please Select any one of the above option:: ");
		int value = scanner.nextInt();
		return value;
		
	}

	private void deleteOperationPage() {
		
		DeletePage deletePage = new DeletePage();
		deletePage.deleteById();
	}

	private void updationOperationPage() {
		
		UpdatePage updatePage = new UpdatePage();
		updatePage.updateDetailsById();

	}

	private void getDetailsByIdPage() {
		
		RetrievePage retrievePage = new RetrievePage();
		retrievePage.getDetailsById();
	}
	
	private void insetionOperationPage() {

		InsertPage insertPage = new InsertPage();
		insertPage.insertOperation();
	}


	private void getAllDetailsPage() {
		
		RetrievePage retrievePage = new RetrievePage();
		retrievePage.getAllOperation();

	}
}
