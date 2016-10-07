package org.hubotek.model.google;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.nanotek.LongBase;

@MappedSuperclass
@SuppressWarnings("serial")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class GoogleBase implements LongBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
