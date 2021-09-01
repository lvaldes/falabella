package com.falabella.challenger.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

@Entity
public class Image {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuSeq")
	    @SequenceGenerator(name = "menuSeq", initialValue = 10000000, allocationSize = 1, sequenceName = "MENU_SEQUENCE")
  private long id;
       
       @NotBlank(message = "Name is mandatory")
       @Size(min = 3, max=50,   message = "El nombre debe tener largo  entre 5  y 50")
       @Column(name = "name")
       private String name;
 
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
  
    /** GET and SET */
   }