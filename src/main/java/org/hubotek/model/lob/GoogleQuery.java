package org.hubotek.model.lob;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

//TODO: Refactor 
@SuppressWarnings("serial")
@Entity
@Table(name="google_query")
public class GoogleQuery extends LobBase{

	
	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(name="description")
	protected String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
