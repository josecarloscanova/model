package org.hubotek.model.rss;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.lob.RssItemDescription;

@SuppressWarnings("serial")
@Entity
@Table(name="rss_item")
public class RssItem extends RssBase
{ 

	@Column(name="title" , length=255 , insertable=true, updatable=false)
	private String title; 
	@Column(name="link" , length=1000 , insertable=true, updatable=false)
	private String link; 
	@Column(name="guid" , length=80 , insertable=true, updatable=false)
	private String guid; 
	@Column(name="category" , length=255 , insertable=true, updatable=false)
	private String category;
	@Column(name="pub_date" , length=55 , insertable=true, updatable=false)
	private String pubDate;
	
	@OneToOne(fetch=FetchType.LAZY)
	private RssItemDescription description;
	
	public RssItem(){}
	
	
	public RssItem(String title, String link, String guid, String category, String pubDate, String description) {
		super();
		this.title = title;
		this.link = link;
		this.guid = guid;
		this.category = category;
		this.pubDate = pubDate;
		this.description = new RssItemDescription(description);
	}

	
	public RssItem(String title, String link, String guid, String category, String pubDate, RssItemDescription description) {
		super();
		this.title = title;
		this.link = link;
		this.guid = guid;
		this.category = category;
		this.pubDate = pubDate;
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public RssItemDescription getDescription() {
		return description;
	}

	public void setDescription(RssItemDescription description) {
		this.description = description;
	}
	
}