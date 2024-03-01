package com.inventory.inventorysystemmanagement.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.InventoryManagementSystem.InventoryManagementSystem.Supplier;

public class SupplierDAOImp1 implements SupplierDAO {
	 private final SessionFactory sessionFactory;

	    // Constructor name adjusted to match class name
	    public SupplierDAOImp1(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	    @Override
	    public void saveSupplier(Supplier s) {
	        try (Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            session.save(s);
	            transaction.commit();
	        }
	    }

	    @Override
	    public Supplier getSupplierById(int id) {
	        try (Session session = sessionFactory.openSession()) {
	            return session.get(Supplier.class, id);
	        }
	    }

	    @Override
	    public void updateSupplier(Supplier updatedSupplier) {
	        try (Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            
	            // Retrieve the existing order from the database using its ID
	            Supplier existingSupplier = session.get(Supplier.class, updatedSupplier.getId());
	            
	            // Update the ID of the existing order with the new value
	            existingSupplier.setId(updatedSupplier.getId());
	            existingSupplier.setName(updatedSupplier.getName());
	            existingSupplier.setContactInfo(updatedSupplier.getContactInfo());
	            
	            // Save the updated order
	            session.update(existingSupplier);
	            
	            transaction.commit();
	        }
	    }

	    @Override
	    public void deleteSupplier(int id) {
	    	try (Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            
	            // Retrieve the existing inventory item from the database using its ID
	            Supplier existingSupplier = session.get(Supplier.class, id);
	            if (existingSupplier != null) {
	                session.delete(existingSupplier);
	                System.out.println("Supplier with ID " + id + " deleted successfully.");
	            } else {
	                System.out.println("No Supplier found with ID " + id + ".");
	            }
	            
	            transaction.commit();
	        }
	    }

}

