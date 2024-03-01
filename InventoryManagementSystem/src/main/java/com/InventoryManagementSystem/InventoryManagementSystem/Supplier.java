package com.InventoryManagementSystem.InventoryManagementSystem;
import javax.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String contactInfo;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContactInfo() {
			return contactInfo;
		}
		public void setContactInfo(String contactInfo) {
			this.contactInfo = contactInfo;
		}
		public Supplier() {
			
		}
		@Override
		public String toString() {
			return "Supplier [id=" + id + ", name=" + name + ", contactInfo=" + contactInfo + "]";
		}

		 

}
