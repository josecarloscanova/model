package org.hubotek.model.google.cse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hubotek.model.google.GoogleBase;

/**
 * Used to store a CSE Site. 
 * 
 * Need a BiDirectional RelationShip with other entities.
 * @author JoseCanova
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="google_cse_site")
public class GoogleCseSite extends GoogleBase{

	@Column(length=30,insertable=true,updatable=false)
	private String location;

	public GoogleCseSite(){}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
