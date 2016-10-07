package org.hubotek.model.url;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.nanotek.LongBase;

/**
 * Intend to store "url instances" or ined addresses. 
 * For administrative purposes.
 * 
 * @author JoseCanova
 *
 */

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class BaseUrl implements LongBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@Column(name="url",insertable=true,updatable=false,length=2000)
	protected String url;
	
	@Column(name="hash",insertable=true,updatable=false,length=36)
	protected String hash;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	} 
	
}
