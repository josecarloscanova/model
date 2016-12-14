package org.hubotek.model.cse;

import java.util.Date;

import javax.ejb.Timeout;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CseKey extends CseBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6226491843014803065L;
	
	public CseKey() {}

	@Column(length=360, nullable=false , unique=true)
	private String key;
	
	@Column (nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dateCreated;
	
	public CseKey(String key, Date dateCreated) {
		super();
		this.key = key;
		this.dateCreated = dateCreated;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
