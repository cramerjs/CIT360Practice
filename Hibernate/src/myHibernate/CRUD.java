package myHibernate;

import myHibernate.Animal;
import myHibernate.Exhibit;
import myHibernate.HibernateUtilSingleton;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CRUD {
	// Declare the List that will hold exhibits and animals
		private List<Exhibit> exhibits;
		private List<Animal> animals;
		
		// this list is nonsense created just for testing/experimentation
		private List<Psychohistorian> psychohistorians;
		
		// explicit constructor
		public CRUD(){

		}

		public static void main(String[] args){
			CRUD dmlStmnt = new CRUD();
			// add Animals
			dmlStmnt.addAnimal("Giant Tortoise");
			dmlStmnt.addAnimal("Alligator");
			dmlStmnt.addAnimal("Zebra");
			dmlStmnt.addAnimal("Orangatan");
			dmlStmnt.addAnimal("Baboon");
			dmlStmnt.addAnimal("Toucan");
			// add Exhibits
//			dmlStmnt.addExhibit("Birds");
//			dmlStmnt.addExhibit("Reptiles");
//			dmlStmnt.addExhibit("Zebras");
//			dmlStmnt.addExhibit("Apes");
			// list all Exhibits
//			dmlStmnt.listAllExhibits();
			// delete all Animals
//			dmlStmnt.deleteAllAnimals();
			// update Exhibit name at given index
			dmlStmnt.updateExhibit(1, "Africa");
			
			// nonsense method calls for testing/experimentation
			dmlStmnt.listAllPsychohistorians();
			dmlStmnt.deleteAllNonexistentRows();
			dmlStmnt.addAnimalNoBeginTrans("Python");
			dmlStmnt.addAnimalNoTransCommit("Ox");
		}

		private void addExhibit(String name) {
			Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			Exhibit exhibit = new Exhibit();
			exhibit.setName(name);
			
			session.save(exhibit);
			
			transaction.commit();

			System.out.println(exhibit.getName() + " has been inserted into the Exhibits table.");
		}
		
		private void addAnimal(String name) {
			Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			Animal animal = new Animal();
			animal.setName(name);
			
			session.save(animal);

			transaction.commit();
			
			System.out.println(animal.getName() + " has been inserted into the Animals table.");
		}
		
		@SuppressWarnings("unchecked")
		private void listAllExhibits() {
			Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
			// A session must hold a transaction in it, even if it is a simple query that the session is used for
			Transaction transaction = session.beginTransaction();
			
			Query allExhibits = session.createQuery("SELECT ex FROM Exhibit AS ex ORDER BY ex.name");
			
			exhibits = allExhibits.list();
			
			Iterator<Exhibit> exhibitIterator = exhibits.iterator();
			while (exhibitIterator.hasNext()) {
				Exhibit exhibit = exhibitIterator.next();
				System.out.println(exhibit.getName());
			}
			
			transaction.commit();
		}
		
		private void deleteAllAnimals() {
			Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();
			
			Query allAnimals = session.createQuery("SELECT an FROM Animal AS an ORDER BY an.name");
			
			animals = allAnimals.list();
			int numAnimals = animals.size();
	        
	        for(int i = 0; i < numAnimals; i++){
	            System.out.println("Deleting animal: " + animals.get(i).getName());
	            session.delete(animals.get(i));
	        }
	        
	        transaction.commit();
	        
	        // at this point the records have been removed from the database but still exist in our class list attribute.
	        // Do not store lists retrieved from the database since they will be out of synch with the database table from which they come.
	        // This example shows that you should not store retrieved lists.
	        System.out.println("Check what's in animals: " + animals);
	        
	        // now the Java instances are also gone and the database is back to its original state so the example application can be run again.
	        animals.clear();
	        
	        System.out.println("Check again what's in animals: " + animals);
		}
		
		private void updateExhibit(int exhibit_id, String nameChange) {
			Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();

			// Hibernate expects a string literal in single quotes so I am wrapping the id in single quotes
			Query selectStmnt = session.createQuery("SELECT ex FROM Exhibit AS ex WHERE ex.exhibit_id = '" + exhibit_id + "'");
			Exhibit theExhibit = (Exhibit)selectStmnt.uniqueResult();

			theExhibit.setName(nameChange);
			session.merge(theExhibit);

			transaction.commit();

			System.out.println("Updated name: " + theExhibit.getName());
			
		}
		
		// ----- "bad stuff" for testing/learning ----- //
		@SuppressWarnings("unchecked")
		private void listAllPsychohistorians() {
			Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
			// A session must hold a transaction in it, even if it is a simple query that the session is used for
			Transaction transaction = session.beginTransaction();
			
			Query allPsychohistorians = session.createQuery("SELECT ph FROM psychohistorians AS ph ORDER BY ph.name");
			
			psychohistorians = allPsychohistorians.list();
			
			Iterator<Psychohistorian> psychohistorianIterator = psychohistorians.iterator();
			while (psychohistorianIterator.hasNext()) {
				Psychohistorian psychohistorian = psychohistorianIterator.next();
				System.out.println(psychohistorian);
			}
			
			transaction.commit();
		}
		
		private void deleteAllNonexistentRows() {
			Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction();
			
			Query allPsychohistorians = session.createQuery("SELECT ph FROM psychohistorians AS ph ORDER BY ph.name");
			
			psychohistorians = allPsychohistorians.list();
			int numPsychohistorians = psychohistorians.size();
	        
	        for(int i = 0; i < numPsychohistorians; i++){
	            System.out.println("Deleting psychohistorian: " + psychohistorians.get(i));
	            session.delete(psychohistorians.get(i));
	        }
	        
	        transaction.commit();

	        psychohistorians.clear();
	        
		}
		
		private void addAnimalNoBeginTrans(String name) {
			Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
			Transaction transaction = (Transaction) session; // this line should be Transaction transaction = session.beginTransaction();

			Animal animal = new Animal();
			animal.setName(name);
			
			session.save(animal);

			transaction.commit();
			
			System.out.println(animal.getName() + " has been inserted into the Animals table.");
		}		
		
		private void addAnimalNoTransCommit(String name) {
			Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
			Transaction transaction = session.beginTransaction(); 
			
			Animal animal = new Animal();
			animal.setName(name);
			
			session.save(animal);

			// disabling this transaction.commit();
			
			System.out.println(animal.getName() + " has been inserted into the Animals table.");
		}		
}