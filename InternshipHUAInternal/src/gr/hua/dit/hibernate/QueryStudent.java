//package gr.hua.dit.hibernate;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import gr.hua.dit.entity.Student;
//
//public class QueryStudent {
//
//        public static void main(String[] args) {
//
//                // create session factory
//                SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
//                                .buildSessionFactory();
//
//                // create session
//                Session session = factory.getCurrentSession();
//
//                try {
//                        // start a transaction
//                        session.beginTransaction();
//
//                        // query all students
//                        List<Student> students =session.createQuery("from Student").getResultList();
//
//                        System.out.println("all students");
//                        displayStudents(students);
//
////                        // query students where email ends with hua.gr
////                        students = session.createQuery("from Student s where s.email LIKE '%hua.gr'").getResultList();
////                        System.out.println("students where email LIKE '%hua.gr'");
////                        displayStudents(students);
//
//                        // commit transaction
//                        session.getTransaction().commit();
//
//                        System.out.println("Done!");
//
//                } finally {
//                        factory.close();
//                }
//
//        }
//
//        private static void displayStudents(List<Student> students) {
//                // display students
//        	students.forEach(System.out::println);
////                
//        }
//
//}

