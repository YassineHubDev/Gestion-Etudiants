package fr.doranco.gestion.scolarite.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateDataSource {

	private static HibernateDataSource instance;
	private static SessionFactory sessionFactory;
	private Configuration config;
	private ServiceRegistry serviceRegistry;
	
	private HibernateDataSource() {
		
		try {
			// avec Hibernate 4
//			config = new Configuration().configure(); // va rechercher le fichier "hibernate.cfg.xml" dans le dossier de resources
//													  // puis va charger tous les paramètres qui y sont indiqués.
//			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
//			serviceRegistryBuilder.applySettings(config.getProperties());
//			serviceRegistry = serviceRegistryBuilder.build();
//			sessionFactory = config.buildSessionFactory(serviceRegistry);

			// avec Hibernate 5
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
		} catch(Throwable ex) {
			System.out.println("Echec de la Création et de l'initialisation de la SessionFactory !");
			System.out.println(ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static HibernateDataSource getInstance() {
		
		if (instance == null) {
			instance = new HibernateDataSource();
		}
		return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Session getSession() {
		Session session = sessionFactory.openSession();
		if (!session.isConnected()) {
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		}
		return session;
	}
	
}
