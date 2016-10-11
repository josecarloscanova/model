package org.hubotek.model.lob;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="rss_document_description")
@SuppressWarnings("serial")
public class RssItemDescription extends LobBase{

	
	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(name="description")
	protected String description;

	public RssItemDescription(){}
	
	public RssItemDescription(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
