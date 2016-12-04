package org.hubotek.model.google.search;

import javax.persistence.MappedSuperclass;

import org.nanotek.LongBase;

@MappedSuperclass
public abstract class SearchParameterBase implements LongBase{

	private static final long serialVersionUID = 1L;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
