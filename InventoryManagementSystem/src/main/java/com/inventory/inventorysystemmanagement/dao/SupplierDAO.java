package com.inventory.inventorysystemmanagement.dao;
import com.InventoryManagementSystem.InventoryManagementSystem.Supplier;

public interface SupplierDAO {
    void saveSupplier(Supplier s);
    Supplier getSupplierById(int id);
    void updateSupplier(Supplier s);
	void deleteSupplier(int id);
   
}
