package org.hubotek.model.document;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.HubDocument;
import org.nanotek.common.domain.DocumentType;

@SuppressWarnings("serial")
@Entity
@Table(name="hubotek_document")
public class HubotekDocument extends DocumentBase implements HubDocument{

	@Enumerated(EnumType.STRING)
	@Column(name="document_type" , nullable=false)
	private DocumentType documentType; 
	
	@Column(name="lang" , length=8 , nullable=false , insertable=true , updatable=true )
	private String language; 
	
	@OneToOne(fetch=FetchType.LAZY , cascade=CascadeType.ALL)
	private LegacyDocument origin;
	
	@OneToMany(fetch=FetchType.LAZY , cascade=CascadeType.ALL)
	private List<HubotekDocumentEntry> documentEntries;
	
	public HubotekDocument(){
		prepare();
	}
	
	private void prepare() {
		documentEntries = new ArrayList<HubotekDocumentEntry>();
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getLanguage() {
		return language;
	}

 	public void setLanguage(String language) {
		this.language = language;
	}

	public LegacyDocument getOrigin() {
		return origin;
	}

	public void setOrigin(LegacyDocument origin) {
		this.origin = origin;
	}

	public List<HubotekDocumentEntry> getDocumentEntries() {
		return documentEntries;
	}

	public void setDocumentEntries(List<HubotekDocumentEntry> documentEntries) {
		this.documentEntries = documentEntries;
	}
	
}
