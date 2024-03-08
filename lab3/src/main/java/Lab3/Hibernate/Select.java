package Lab3.Hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class Select 
{
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();
		List<patient> Patient = session.createQuery("FROM patient", patient.class).getResultList();
	    if(Patient.isEmpty()) 
	    {
	        System.out.println("No employees found.");
	    } 
	    else 
	    {
	        System.out.println("ID\tName\t\t\tAge\tDate Of Birth");
	        for(patient Patient1 : Patient) {
	            System.out.println(Patient1.getID() + "\t" + Patient1.getFirst_Name() + " " + Patient1.getLast_Name() + "\t\t" + Patient1.getAge() + "\t" + Patient1.getDOB());
	        }
	    }

        tx.commit();
        session.close();
	}
}
