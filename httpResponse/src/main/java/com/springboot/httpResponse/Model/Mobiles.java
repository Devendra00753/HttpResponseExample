package com.springboot.httpResponse.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name="mobiles")
public class Mobiles {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String mobileName;
	
	private String model;
	
	private String price;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setProce(String proce) {
		this.price = proce;
	}

	@Override
	public String toString() {
		return "httpMobiles [Id=" + Id + ", mobieName=" + mobileName + ", model=" + model + ", proce=" + price + "]";
	}
	
}
