package org.hubotek.model.news.feed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.url.NamedUrl;
import org.nanotek.common.domain.DocumentType;


@SuppressWarnings("serial")
@Entity
@Table(name="feed_source")
public class FeedSource extends FeedBase{

	@Column(name="feed_name" , length=2000 , insertable=true , updatable=true , nullable=false)
	private String feedName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="document_type" , nullable=false)
	private DocumentType documentType;
	
	@Column (name="description" , length=4000 , insertable=true , updatable=true , nullable=true)
	private String description;
	
	@OneToOne(fetch=FetchType.EAGER)
	private NamedUrl feedUrl;
	
	public FeedSource() {
	}

	public String getFeedName() {
		return feedName;
	}

	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NamedUrl getFeedUrl() {
		return feedUrl;
	}

	public void setFeedUrl(NamedUrl feedUrl) {
		this.feedUrl = feedUrl;
	}

}
