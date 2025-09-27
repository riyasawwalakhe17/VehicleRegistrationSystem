package com.practise;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Vehicles;
import com.practise.Utility.HibernateUtility;

public class GetAllData {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Vehicles> vehicleList = session.createQuery("select v FROM Vehicles v", Vehicles.class).getResultList();

		System.out.println("List of vehicles: ");
		vehicleList.stream().forEach(k -> System.out.println(k.toString()));

		transaction.commit();
		session.close();
	}
}
