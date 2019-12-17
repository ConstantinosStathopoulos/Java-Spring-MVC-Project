package gr.hua.dit.internApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import gr.hua.dit.internApp.Student;


public class CreateStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the student object
			Student student = new Student("Testing", "Tester", 7,6,1,5.5,false);

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(student);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
