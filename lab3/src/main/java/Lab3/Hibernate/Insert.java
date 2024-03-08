package Lab3.Hibernate;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class Insert 
{
    public static void main( String[] args )
    {
        Session sex=HibernateUtil.getSessionFactory().openSession(); 
        Transaction tits = sex.beginTransaction();
        
        
        Scanner sc = new Scanner(System.in);
        patient s = new patient();
       
        System.out.print("Enter The Details of the patient\nFirst Name = ");
		String fname = sc.next();
		s.setFirst_Name(fname);
		System.out.print("Last Name = ");
		String lname = sc.next();
		s.setLast_Name(lname);
		System.out.print("Age = ");
		String age = sc.next();
		s.setAge(age);
		System.out.print("DOB (YYYY-MM-DD) = ");
		String date = sc.next();
		s.setDOB(date);
		sex.save(s);
		System.out.println("Data Inserted");
        
        sex.save(s);
        sc.close();
        tits.commit();
        sex.close();

        
        
        
    }
    
}
