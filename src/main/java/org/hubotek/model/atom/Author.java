package org.hubotek.model.atom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="author")
public class Author extends AtomBase{
	
	@Column(name="name" , insertable=true , updatable=false , nullable=false, length=2500)
	private String name; 
	
	@Column(name="email" , nullable=true , length=3500 )
	private String email;
	
	public Author(){}
	
	public Author(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
	
}
