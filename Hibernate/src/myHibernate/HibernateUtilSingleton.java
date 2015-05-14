package myHibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/*
 * This class follows the singleton pattern.
 */

public class HibernateUtilSingleton {
	
	// Make a private default constructor so that the HibernateUtilSingleton can only be obtained
	// through a getter ???
	private HibernateUtilSingleton() {

	}

	// The "SessionFactory" class can create or fetch an already existing session
	private static final SessionFactory sessionFactory;

	// Since everything about the configuration of hibernate should be shared among all other objects, wrap all
	// configuration properties in a static block. Also, these configurations must either be done within a method or
	// they need to be done within a static block like this.
	static {

		// Create an object that will allow the configuration of hibernate.
		Configuration config = new Configuration();

		// Set up what SQL dialect hibernate will use to communicate with the DB
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		// The jdbc Driver is what allows Java to communicate with MySQL
		config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

		// Change the next line of code to match your MySQL URL and port
		config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/my_hibernate");

		// Change the next two lines of code to match your MySQL user name and password.
		config.setProperty("hibernate.connection.username", "test_user");
		config.setProperty("hibernate.connection.password", "testpwd");

		// Change the pool size to reflect how many users you expect your application to have initially
		config.setProperty("hibernate.connection.pool_size", "1");

		config.setProperty("hibernate.connection.autocommit", "true"); // Don't need to know for now

		config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider"); // Don't need to know for now

		/*
		 * Uncomment the next line of code if you want to be able to drop and recreate tables based on your data classes listed below.  
		 * This is generally a bad idea for security reasons. It means the structure of the data will be dependent on what's in the
		 * class. You only want to interact with the already existing structure of the database (that was created by a DBA).
		 */
		//config.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		config.setProperty("hibernate.show_sql", "true"); // Don't need to know for now

		// Don't need to know for now
		config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory"); 

		config.setProperty("hibernate.current_session_context_class", "thread"); // Don't need to know for now

		/*
		 *  Add those classes here that match database tables.
		 *  Bro. Barney's example has a User and a PhoneNumber class.
		 */

		config.addAnnotatedClass(Animal.class);
		config.addAnnotatedClass(Exhibit.class);

		// Don't need to know for now
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();     

		// Don't need to know for now
		sessionFactory = config.buildSessionFactory(serviceRegistry);

	}

	// Getter for sessionFactory
	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}
}
