package org.hubotek.model.document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="legacy_document")
@Inheritance(strategy=InheritanceType.JOINED)
@SuppressWarnings("serial")
public abstract class LegacyDocument extends DocumentBase {

	@Enumerated(EnumType.STRING)
	@Column(name="legacy_type" , nullable=false)
	protected LegacyDocumentType legacyDocumentyType;
	
	public LegacyDocument(){}

	public LegacyDocumentType getLegacyDocumentyType() {
		return legacyDocumentyType;
	}

	public void setLegacyDocumentyType(LegacyDocumentType legacyDocumentyType) {
		this.legacyDocumentyType = legacyDocumentyType;
	}
	
	
}
