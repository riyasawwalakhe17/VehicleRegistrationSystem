package com.practise;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.RegistrationEntry;
import com.practise.Entity.Vehicles;
import com.practise.Utility.HibernateUtility;

public class GetUpdateData {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		RegistrationEntry rEntry = new RegistrationEntry();
		rEntry.setRegistrationNo("REG2020MH1234");
		rEntry.setIssueDate("2020-01-10");
		rEntry.setRegisteredCity("Mumbai");
		rEntry.setExpiryDate("2025-01-10");

		List<RegistrationEntry> rList = Arrays.asList(rEntry);
		
		Vehicles v = session.find(Vehicles.class, 1);
		
		v.setOwnerName("Rakesh Singh	");
		v.setRegistrationYear(2020);
		v.setModel("Honda City");
		v.setVehicleName("car");
		v.setVehicleNo("MH12AB1234");
		v.setrEntry(rList);
		
		System.out.println("Vehicle Data updated successfully");
        session.persist(v);
		transaction.commit();
		session.close();
	}
}
