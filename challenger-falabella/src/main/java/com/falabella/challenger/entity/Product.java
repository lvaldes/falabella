package com.falabella.challenger.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

@Entity
public class Product {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuSeq")
	    @SequenceGenerator(name = "menuSeq", initialValue = 10000000, allocationSize = 1, sequenceName = "MENU_SEQUENCE")
  private long id;
       
       @NotBlank(message = "Name is mandatory")
       @Size(min = 3, max=50,   message = "El nombre debe tener largo  entre 5  y 50")
       @Column(name = "name")
       private String name;
       
       @NotBlank(message = "Brand is mandatory")
       @Size(min = 3, max=50,   message = "El brand debe tener largo  entre 5  y 50")
       @Column(name = "brand")
       private String brand;
       
       @NotBlank(message = "Size is mandatory")
       @Column(name = "size")
       private String size;
       
       @Min(value = 1 , message = "Value should be greater then equal to 1.00")
       @Max(value = 999999999 , message = "Value should be less then equal to 99999999.00")
       @Column(name = "price")
       private Double price;
       
       @URL(regexp = "^(http|ftp).*", message ="El campo debe formato url")
       @NotBlank(message = "Image is mandatory")
       @Column(name = "image")
       private String image;

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

   	public String getBrand() {
   		return brand;
   	}

   	public void setBrand(String brand) {
   		this.brand = brand;
   	}

   	public String getSize() {
   		return size;
   	}

   	public void setSize(String size) {
   		this.size = size;
   	}

   	public Double getPrice() {
   		return price;
   	}

   	public void setPrice(Double price) {
   		this.price = price;
   	}

   	public String getImage() {
   		return image;
   	}

   	public void setImage(String image) {
   		this.image = image;
   	}

   }