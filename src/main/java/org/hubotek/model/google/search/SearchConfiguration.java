package org.hubotek.model.google.search;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class SearchConfiguration {

	private Integer num; 
	
	private Integer startIndex;

	private String language; 
	
	private String safe;
	
	private String cx;
	
	private String cref;
	
	private String sort;
	
	private String filter; 
	
	private String alt;
	
	private String country;
	
}
