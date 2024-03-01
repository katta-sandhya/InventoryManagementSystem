package com.inventory.inventorysystemmanagement.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.InventoryManagementSystem.InventoryManagementSystem.Order; // Add this import statement

public class OrderDAOImp1 implements OrderDAO {
	private final SessionFactory sessionFactory;

    public OrderDAOImp1(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveOrder(Order order) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        }
    }
    @Override
    public Order getOrderById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Order.class, id);
        }
    }
    @Override
    public void updateOrder(Order updatedOrder) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            
            // Retrieve the existing order from the database using its ID
            Order existingOrder = session.get(Order.class, updatedOrder.getId());
            
            // Update the ID of the existing order with the new value
            existingOrder.setId(updatedOrder.getId());
            
            // Save the updated order
            session.update(existingOrder);
            
            transaction.commit();
        }
    }

    @Override
    public void deleteOrderById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            
            // Retrieve the existing inventory item from the database using its ID
            Order existingOrder = session.get(Order.class, id);
            if (existingOrder != null) {
                session.delete(existingOrder);
                System.out.println("Order with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No Order found with ID " + id + ".");
            }
            
            transaction.commit();
        }
    }

    // Other methods...
}


