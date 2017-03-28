package org.hubotek.model.rss;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.HubDocument;
import org.hubotek.model.document.LegacyDocument;
import org.hubotek.model.document.LegacyDocumentType;

@SuppressWarnings("serial")
@Entity
@Table(name="rss_document")
public class RssDocument extends LegacyDocument implements HubDocument{

	@OneToOne(cascade=CascadeType.ALL , fetch=FetchType.LAZY )
	private RssBody rssBody; 
	
	@OneToOne(cascade=CascadeType.ALL , fetch=FetchType.LAZY)
	private RssImage rssImage; 
	
	@OneToMany(cascade=CascadeType.ALL , fetch=FetchType.LAZY)
	private List<RssItem> rssItems; 
	
	public RssDocument(){
		prepare();
	}
	
	private void prepare() {
		rssItems = new ArrayList<RssItem>();	
		this.legacyDocumentyType = LegacyDocumentType.RSS;
	}

	public RssDocument(RssBody body,RssImage image,List<RssItem>items)
	{ 
		this.rssBody = body; 
		this.rssImage= image; 
		this.rssItems = items;
	}

	public RssBody getRssBody() {
		return rssBody;
	}

	public void setRssBody(RssBody rssBody) {
		this.rssBody = rssBody;
	}

	public RssImage getRssImage() {
		return rssImage;
	}

	public void setRssImage(RssImage rssImage) {
		this.rssImage = rssImage;
	}

	public List<RssItem> getRssItems() {
		return rssItems;
	}

	public void setRssItems(List<RssItem> rssItems) {
		this.rssItems = rssItems;
	}
	
}
