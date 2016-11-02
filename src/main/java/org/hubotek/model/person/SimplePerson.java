package org.hubotek.model.person;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@SuppressWarnings("serial")
public class SimplePerson extends PersonBase{

	
	@Column(name="name" , insertable=true , updatable=false , nullable=false, length=2500)
	protected String name;
	
	
}
