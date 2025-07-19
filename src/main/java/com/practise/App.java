package com.practise;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.practise.Repositories.VehicleRepository;
import com.practise.Utility.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("WELCOME TO VEHICLE REGISTRATION SYSTEM");
			System.out.println("Please Select as per Requirement");
			System.out.println("1. Add new vehicle");
			System.out.println("2. Search by model or year");
			System.out.println("3. Update vehicle number");
			System.out.println("4. Delete by ID");

			System.out.println("Please Enter your choice: ");
			int choice = sc.nextInt();

			VehicleRepository vehicle = new VehicleRepository();
			switch (choice) {
			case 1:
				vehicle.addData(sc);
				break;

			case 2:

				vehicle.searchData(sc);
				break;
				
			case 3:
				vehicle.updateData(sc);
				break;
				
			case 4:
				vehicle.deleteData(sc);
				break;
			}
		}
	}
}
