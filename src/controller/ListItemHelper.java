package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;




public class ListItemHelper {

	static	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineCarShoppingList"); 
	
	public void insertCar(ListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteCar(ListItem toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.make = :selectedMake and li.model = :selectedModel and li.year = :selectedYear", ListItem.class);
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setMaxResults(1);
		ListItem result = typedQuery.getSingleResult();

		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<ListItem> searchForCarByYear(String yearName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.year = :selectedYear", ListItem.class);
		typedQuery.setParameter("selectedYear", yearName);

		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<ListItem> searchForCarByModel(String modelName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.model = :selectedModel", ListItem.class);
		typedQuery.setParameter("selectedModel", modelName);

		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<ListItem> searchForCarByMake(String makeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.make = :selectedMake", ListItem.class);
		typedQuery.setParameter("selectedMake", makeName);

		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
		
	}
	
	public ListItem searchForCarById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, id);
		em.close();
		return found;
	}

	public List<ListItem> showAllCars(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li", ListItem.class);
		List<ListItem> allCars = typedQuery.getResultList();
		em.close();
		return allCars;
	}

	public void updateCar(ListItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	
	public	void	cleanUp(){
		emfactory.close();
	}
		
}
