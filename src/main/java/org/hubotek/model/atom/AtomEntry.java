package org.hubotek.model.atom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.feed.FeedUrl;
import org.hubotek.model.lob.AtomDocumentContent;

@SuppressWarnings("serial")
@Entity
@Table(name="atom_entry")
public class AtomEntry extends AtomBase{

	@Column(name="atom_entry_id" , nullable=false , length=255)
	private String atomEntryId;
	
	@Column(name="title" , length=255 , insertable=true , updatable=false)
	private String title;
	
	@OneToOne
	private FeedUrl link; 
	
	@OneToOne
	private AtomDocumentContent content;
	
	@Column (name="updated" , length=30 , nullable=false)
	private String updated;
	
	@Column (name="category" , length=255 , nullable=false)
	private String category;
	
	public AtomEntry(){}
	
	
	public AtomEntry(String id, String title, FeedUrl link, AtomDocumentContent content, String updated , String category) {
		super();
		this.atomEntryId = id;
		this.title = title;
		this.link = link;
		this.content = content;
		this.updated = updated;
		this.category = category;
	}
	
	public AtomEntry(String id, String title, String link, String content, String updated , String category) {
		super();
		this.atomEntryId = id;
		this.title = title;
		this.link = new FeedUrl(link);
		this.content = new AtomDocumentContent(content);
		this.updated = updated;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public FeedUrl getLink() {
		return link;
	}
	
	public void setLink(FeedUrl link) {
		this.link = link;
	}
	
	public AtomDocumentContent getContent() {
		return content;
	}

	public void setContent(AtomDocumentContent content) {
		this.content = content;
	}

	public String getUpdated() {
		return updated;
	}
	
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	public String getAtomEntryId() {
		return atomEntryId;
	}
	
	public void setAtomEntyId(String id) {
		this.atomEntryId = id;
	} 

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
