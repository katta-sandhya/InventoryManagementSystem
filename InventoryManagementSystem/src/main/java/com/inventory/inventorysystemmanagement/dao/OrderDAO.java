package com.inventory.inventorysystemmanagement.dao;

import com.InventoryManagementSystem.InventoryManagementSystem.Order;

public interface OrderDAO {
    void saveOrder(Order order);
    Order getOrderById(int id); // Method signature
    void updateOrder(Order order);
    void deleteOrderById(int id);
}
