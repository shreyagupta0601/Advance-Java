package Lab3.Hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Delete 
{
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
        Scanner sc = new Scanner(System.in);
        patient s = new patient();
        System.out.println("Enter The Id whose Details needs to be Deleted");
		int id = sc.nextInt();
		s.setID(id);
		session.delete(s);
		System.out.println("Data Deleted");
		tx.commit();
		sc.close();
        session.close();
	}
}
