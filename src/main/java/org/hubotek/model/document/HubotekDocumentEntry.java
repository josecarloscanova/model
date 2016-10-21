package org.hubotek.model.document;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.lob.HubotekDocumentContent;

@SuppressWarnings("serial")
@Entity
@Table(name="hubotek_document_entry")
public class HubotekDocumentEntry extends DocumentEntry{

	@OneToOne(fetch=FetchType.LAZY , cascade=CascadeType.ALL)
	private HubotekDocumentContent documentContent; 
	
	public HubotekDocumentEntry(){}
	
	public HubotekDocumentEntry(HubotekDocumentContent documentContent) {
		super();
		this.documentContent = documentContent;
	}

	public HubotekDocumentContent getDocumentContent() {
		return documentContent;
	}

	public void setDocumentContent(HubotekDocumentContent documentContent) {
		this.documentContent = documentContent;
	}
}
