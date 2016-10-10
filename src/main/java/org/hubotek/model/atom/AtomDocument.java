package org.hubotek.model.atom;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.HubDocument;

@Entity
@Table(name="atom_document")
@SuppressWarnings("serial")
public class AtomDocument extends AtomBase implements HubDocument{

	@OneToOne
	private AtomBody body;
	
	@OneToMany
	private List<AtomEntry> entries;
	
	public AtomDocument(){}
	
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
