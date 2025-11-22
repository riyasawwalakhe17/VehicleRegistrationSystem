package com.practise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.Vehicles;
import com.practise.Utility.HibernateUtility;

public class GetDataById {

public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Vehicle detail are: ");
		int id = 1;
		Vehicles vehicles = session.find(Vehicles.class, 1);
		
		transaction.commit();
		session.close();
		System.out.println("DATA for Vehicles with id " + id + " : " + vehicles.toString());
	}
}
