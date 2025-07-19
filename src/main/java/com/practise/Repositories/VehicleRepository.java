package com.practise.Repositories;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Vehicles;
import com.practise.Utility.HibernateUtility;

public class VehicleRepository {

	public void addData(Scanner sc) {
		Vehicles v = new Vehicles();
		sc.nextLine(); // to consume the leftover newline from previous nextInt()
		System.out.print("Enter Owner Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Vehicle Number: ");
		String veh_no = sc.nextLine();

		System.out.print("Enter Vehicle Name: ");
		String veh_name = sc.nextLine();

		System.out.print("Enter Registration Year: ");
		int year = sc.nextInt();

		sc.nextLine(); // again, consume newline
		System.out.print("Enter Model: ");
		String model = sc.nextLine();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		v.setOwnerName(name);
		v.setVehicleName(veh_name);
		v.setVehicleNo(veh_no);
		v.setModel(model);
		v.setRegistrationYear(year);

		session.persist(v);
		transaction.commit();
		session.close();

		System.out.println("Vehicle Added successfully ");
	}

	public void searchData(Scanner sc) {

		System.out.println("Enter model or year to search: ");
		sc.nextLine(); // clear the buffer if nextInt() was used before
		String model = sc.nextLine();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// We have to use parameterised query to filter
		List<Vehicles> vlist = session.createQuery("FROM Vehicles WHERE lower(model) = lower(:model)", Vehicles.class)
				.setParameter("model", model).getResultList();

		vlist.stream().forEach(a -> System.out.println(a.toString()));

		transaction.commit();
		session.close();
	}

	public void updateData(Scanner sc) {
		System.out.println("Enter Id to update the Vehicle no : ");
		int id = sc.nextInt();

		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Vehicles v = session.find(Vehicles.class, id);
		System.out.println("Enter New Vehicle Number :");
		String vehno = sc.next();

		v.setVehicleNo(vehno);

		transaction.commit();
		session.close();
		System.out.println("Vehicle Number updated ");
	}

	public void deleteData(Scanner sc) {
		System.out.println("Enter the id of vehicle to  delete : ");
		int id = sc.nextInt();
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Vehicles v = session.find(Vehicles.class, id);
		session.remove(v);
		
		transaction.commit();
		session.close();
		
		System.out.println("Vehicle Deleted ");
	}

}
