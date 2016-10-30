package org.hubotek.model.person;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.nanotek.LongBase;


@MappedSuperclass
@SuppressWarnings("serial")
public class PersonBase implements LongBase{

	@Id
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
