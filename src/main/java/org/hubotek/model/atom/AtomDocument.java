package org.hubotek.model.atom;

import java.util.List;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import org.hubotek.model.HubDocument;
import javax.persistence.CascadeType;

@Entity
@Table(name="atom_document")
@SuppressWarnings("serial")
public class AtomDocument extends AtomBase implements HubDocument{

	@OneToOne(cascade=CascadeType.ALL)
	private AtomBody body;
	
	@OneToMany(cascade=CascadeType.ALL)
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
