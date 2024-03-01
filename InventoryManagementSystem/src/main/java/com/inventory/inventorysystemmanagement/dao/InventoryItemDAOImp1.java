package com.inventory.inventorysystemmanagement.dao;

//InventoryItemDAOImp1.java
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.InventoryManagementSystem.InventoryManagementSystem.InventoryItem; // Add this import statement

public class InventoryItemDAOImp1 implements InventoryItemDAO {
	private final SessionFactory sessionFactory;

 public InventoryItemDAOImp1(SessionFactory sessionFactory) {
     this.sessionFactory = sessionFactory;
 }

 @Override
 public void saveInventoryItem(InventoryItem inventoryItem) {
     try (Session session = sessionFactory.openSession()) {
         Transaction transaction = session.beginTransaction();
         session.save(inventoryItem);
         transaction.commit();
     }
 }
 @Override
 public InventoryItem getInventoryItemById(int id) {
     try (Session session = sessionFactory.openSession()) {
         return session.get(InventoryItem.class, id);
     }
 }


 @Override
 public void updateInventoryItem(InventoryItem updatedInventoryItem) {
     try (Session session = sessionFactory.openSession()) {
         Transaction transaction = session.beginTransaction();
         
         // Retrieve the existing inventory item from the database using its ID
         InventoryItem existingInventoryItem = session.get(InventoryItem.class, updatedInventoryItem.getId());
         
         // Update the attributes of the existing inventory item with the new values
         existingInventoryItem.setQuantity(updatedInventoryItem.getQuantity()); // Adjust accordingly
         
         // Save the updated inventory item
         session.update(existingInventoryItem);
         
         transaction.commit();
     }
 }

 @Override
 public void deleteInventoryItemById(int id) {
     try (Session session = sessionFactory.openSession()) {
         Transaction transaction = session.beginTransaction();
         
         // Retrieve the existing inventory item from the database using its ID
         InventoryItem existingInventoryItem = session.get(InventoryItem.class, id);
         if (existingInventoryItem != null) {
             session.delete(existingInventoryItem);
             System.out.println("Inventory item with ID " + id + " deleted successfully.");
         } else {
             System.out.println("No inventory item found with ID " + id + ".");
         }
         
         transaction.commit();
     }
 }

 // Other methods...
}
