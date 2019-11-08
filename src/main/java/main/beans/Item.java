package main.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name, location;
	
	public Item() {
		super();
	}
	
	public Item(String name) {
		super();
		this.name = name;
	}
	
	public Item(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	public Item(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
}
