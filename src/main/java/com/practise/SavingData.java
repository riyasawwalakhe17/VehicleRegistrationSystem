package com.practise;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.practise.Entity.RegistrationEntry;

import com.practise.Entity.Vehicles;
import com.practise.Utility.HibernateUtility;

public class SavingData {

public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		RegistrationEntry rentry = new RegistrationEntry();
		rentry.setRegistrationNo("REG2020MH1234");
		rentry.setIssueDate("2020-01-10");
		rentry.setExpiryDate("2025-01-10");
		rentry.setRegisteredCity("Mumbai");
		
		
		RegistrationEntry rentry1 = new RegistrationEntry();
		rentry1.setRegistrationNo("REG2021DL5678");
		rentry1.setIssueDate("2021-05-12");
		rentry1.setExpiryDate("2026-05-12");
		rentry1.setRegisteredCity("Pune");
		
		RegistrationEntry rentry2 = new RegistrationEntry();
		rentry2.setRegistrationNo("REG2019MH8765");
		rentry2.setIssueDate("2019-12-10");
		rentry2.setExpiryDate("2019-12-10");
		rentry2.setRegisteredCity("Mumbai");
		
		RegistrationEntry rentry3 = new RegistrationEntry();
		rentry3.setRegistrationNo("REG2023MH02C1");
		rentry3.setIssueDate("2023-08-05");
		rentry3.setExpiryDate("2028-08-05");
		rentry3.setRegisteredCity("Nashik");
		
		RegistrationEntry rentry4 = new RegistrationEntry();
		rentry4.setRegistrationNo("REG2019MH01E1");
		rentry4.setIssueDate("2019-12-01");
		rentry4.setExpiryDate("2024-12-01");
		rentry4.setRegisteredCity("Aurangabad");
		
		List<RegistrationEntry> rList = Arrays.asList(rentry,rentry1,rentry2,rentry3,rentry4);
		
		Vehicles vehicles = new Vehicles();
		vehicles.setOwnerName("Rajesh Iyer");
		vehicles.setVehicleNo("KA03PQ9988");
		vehicles.setModel("Mahindra Thar");
		vehicles.setRegistrationYear(2023);
		vehicles.setVehicleName("Car");
		vehicles.setrEntry(rList);
		
		session.persist(vehicles);
		transaction.commit();
		session.close();
	}
}
