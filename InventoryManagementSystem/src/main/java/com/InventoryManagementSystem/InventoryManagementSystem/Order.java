package com.InventoryManagementSystem.InventoryManagementSystem;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order() {
		
	}

	@Override
	public String toString() {
		return "Order [id=" + id + "]";
	}
	
    
}