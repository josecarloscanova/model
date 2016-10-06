package org.hubotek.model.lob;

import javax.persistence.MappedSuperclass;

import org.nanotek.LongBase;

@MappedSuperclass
@SuppressWarnings("serial")
public class LobBase implements LongBase{
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
}
