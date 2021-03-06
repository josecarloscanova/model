package org.hubotek.model.google.cse;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.google.GoogleBase;
import org.hubotek.model.url.NamedUrl;

/**
 * Class storing the basic attributes by a "CSE"configured with 
 * Google AdSense for search. 
 * 
 * @author JoseCanova
 *
 */
@Entity
@Table(name="gse_base")
@SuppressWarnings("serial")
public class GoogleSearchEngine extends GoogleBase{

	@Column(name="name" , length=255 , insertable=true , unique=true , updatable=false , nullable=false)
	private String name;
	
	@Column(name="cx" , length=255 , insertable=true , unique=true , updatable=false , nullable=false)
	private String cx;

	@Column(name="description" , length=250 , insertable=true , updatable=true , nullable=true)
	private String description;
	
	@OneToOne(fetch=FetchType.EAGER)
	private NamedUrl searchEngineUrl;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<GoogleCseSite> sites;

	public GoogleSearchEngine(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCx() {
		return cx;
	}

	public void setCx(String cx) {
		this.cx = cx;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NamedUrl getSearchEngineUrl() {
		return searchEngineUrl;
	}

	public void setSearchEngineUrl(NamedUrl searchEngineUrl) {
		this.searchEngineUrl = searchEngineUrl;
	}

	public List<GoogleCseSite> getSites() {
		return sites;
	}

	public void setSites(List<GoogleCseSite> sites) {
		this.sites = sites;
	} 
	

}
