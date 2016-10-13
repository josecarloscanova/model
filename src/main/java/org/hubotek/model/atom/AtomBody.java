package org.hubotek.model.atom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.feed.FeedUrl;

@SuppressWarnings("serial")
@Entity
@Table (name="atom_body")
public class AtomBody extends AtomBase {

	@Column(name="version" , length=10 , insertable=true , updatable=false , nullable=false)
	private String version = "1.0";

	@Column(name="atom_id" , length=255 , insertable=true , updatable=false , nullable=false)
	private String atomId;
	
	@Column(name="title" , length=255 , insertable=true , updatable=false , nullable=false)
	private String title; 
	
	@OneToOne
	private FeedUrl link; 
	
	@Column(name="rights" , length=255)
	private String rights;
	
	@Column(name="logo" , length=255)
	private String logo;
	
	@Column(name="updated" , length=30)
	private String updated;
	
	@OneToOne(fetch=FetchType.LAZY , cascade=CascadeType.ALL)
	private Author author;
	
	public AtomBody(){}
	
	public AtomBody(String id, String title, String rights, String logo, String updated) {
		super();
		this.atomId = id;
		this.title = title;
		this.rights = rights;
		this.logo = logo;
		this.updated = updated;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAtomId() {
		return atomId;
	}

	public void setAtomId(String id) {
		this.atomId = id;
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

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
