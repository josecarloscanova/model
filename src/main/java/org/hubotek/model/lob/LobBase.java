package org.hubotek.model.lob;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.nanotek.LongBase;

/**
 * Just a superclass for other lob specialized classes.
 * 
 * @author JoseCanova
 *
 */
@MappedSuperclass
@SuppressWarnings("serial")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class LobBase implements LongBase{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
}
