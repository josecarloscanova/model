package org.hubotek.model.cse;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CseEngine  extends CseBase{

	private static final long serialVersionUID = 3239192971828747679L;
	
	@Column(name="identification" , length=128 , insertable=true , updatable=true , unique=true)
	private String identification;

	@Column(name="description" , length=255 , insertable=true , updatable=true )
	private String description;
	
	@Column(name="dateCreated")
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
	public CseEngine(){}

	public CseEngine(String identification, String description, Date dateCreated) {
		super();
		this.identification = identification;
		this.description = description;
		this.dateCreated = dateCreated;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
