package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Vehicles;
import com.practise.Utility.HibernateUtility;

public class GetDeleteDataById {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Vehicles  vehicles= session.find(Vehicles.class, 1);
		session.remove(vehicles);

		System.out.println("Data deleted successfully");
		transaction.commit();
		session.close();
	}
}
