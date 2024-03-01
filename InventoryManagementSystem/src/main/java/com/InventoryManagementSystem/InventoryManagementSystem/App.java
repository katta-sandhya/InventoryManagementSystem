package com.InventoryManagementSystem.InventoryManagementSystem;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inventory.inventorysystemmanagement.dao.ProductDAOImp1;

public class App {
    public static void main(String[] args) {
        // Create a session factory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        
        // Create DAO instances
        ProductDAOImp1 productDAO = new ProductDAOImp1(sessionFactory);
        //OrderDAO orderDAO = new OrderDAOImp1(sessionFactory);
        //SupplierDAO supplierDAO = new SupplierDAOImp1(sessionFactory);
       // InventoryItemDAO inventoryItemDAO = new InventoryItemDAOImp1(sessionFactory);

        // Perform CRUD operations
        
        // Example: Save a new product
        Product product = new Product();
        // Set product details
        product.setCategory("phone");
        product.setName("New Product");
        product.setDescription("Sample Description");
        product.setPrice(99.99);
        product.setQuantity(10);
        productDAO.saveProduct(product);

        // Example: Update a product
        Product existingProduct = productDAO.getProductById(1); // Assume product with ID 1 exists
        existingProduct.setPrice(129.99); // Update price
        productDAO.updateProduct(existingProduct);

        // Example: Delete a product
        productDAO.deleteProductById(2); // Assume product with ID 2 exists and needs to be deleted

        // Similar operations for other entities

        // Close the session factory
        sessionFactory.close();
    }
}