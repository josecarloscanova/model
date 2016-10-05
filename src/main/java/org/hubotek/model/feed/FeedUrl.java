package org.hubotek.model.feed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.nanotek.LongBase;

@SuppressWarnings("serial")
@Entity
@Table(name="feed_url")
public class FeedUrl implements LongBase{

	@Id
	private Long id;

	@Column(name="feed_url" , length=2000 , insertable=true , updatable=true , nullable=false)
	private String url;
	
	@Column (name="description" , length=4000 , insertable=true , updatable=true , nullable=true)
	private String description;

	public FeedUrl(){}
	
	public FeedUrl(String url) {
		super();
		this.url = url;
	}


	public FeedUrl(String url, String description) {
		super();
		this.url = url;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
