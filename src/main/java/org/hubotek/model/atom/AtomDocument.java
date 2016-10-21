package org.hubotek.model.atom;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.document.LegacyDocument;
import org.hubotek.model.document.LegacyDocumentType;

@Entity
@Table(name="atom_document")
@SuppressWarnings("serial")
public class AtomDocument extends LegacyDocument {

	@OneToOne(cascade=CascadeType.ALL)
	private AtomBody body;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<AtomEntry> entries;
	
	public AtomDocument(){
		prepare();
	}
	
	private void prepare() {
		this.legacyDocumentyType = LegacyDocumentType.ATOM;
		entries = new ArrayList<AtomEntry>();
	}

	public AtomBody getBody() {
		return body;
	}

	public void setBody(AtomBody body) {
		this.body = body;
	}

	public List<AtomEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<AtomEntry> entries) {
		this.entries = entries;
	}

}
