package com.example.retrieve;

import java.util.Scanner;

public class RetrievePage {
	
	public void getAllOperation() {
		
		RetrieveApp retrieveApp = new RetrieveApp();
		retrieveApp.getAllDetails();
		
	}
	
	public void getDetailsById() {
		
		RetrieveApp retrieveApp = new RetrieveApp();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Product Id:: ");
		int id = scanner.nextInt();
		
		retrieveApp.getDetailsById(id);
		
	}

}
