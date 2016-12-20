package org.hubotek.model.cse;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CseBaseUrl extends CseBase{

	private static final long serialVersionUID = -5285861004803127248L;

	@Column(name="baseUrl" , insertable=true , unique=true , length=1000)
	private String baseUrl; 
	
}
