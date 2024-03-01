package com.inventory.inventorysystemmanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.InventoryManagementSystem.InventoryManagementSystem.Product; // Add this import statement

public class ProductDAOImp1 implements ProductDAO {
	private final SessionFactory sessionFactory;

    public ProductDAOImp1(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void saveProduct(Product product) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }
    }
    @Override
    public Product getProductById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, id);
        }
    }
    @Override
    public void updateProduct(Product updatedProduct) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            
            // Retrieve the existing order from the database using its ID
            Product existingProduct = session.get(Product.class, updatedProduct.getId());
            
            // Update the ID of the existing order with the new value
            existingProduct.setId(updatedProduct.getId());
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            // Save the updated order
            session.update(existingProduct);
            
            transaction.commit();
        }
    }

    @Override
    public void deleteProductById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            
            // Retrieve the existing inventory item from the database using its ID
            Product existingProduct = session.get(Product.class, id);
            if (existingProduct != null) {
                session.delete(existingProduct);
                System.out.println("Product with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No Product found with ID " + id + ".");
            }
            
            transaction.commit();
        }
    }

    // Other methods...
}


