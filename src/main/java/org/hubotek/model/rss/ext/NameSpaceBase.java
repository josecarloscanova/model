package org.hubotek.model.rss.ext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.nanotek.LongBase;

/**
 * @author JoseCanova
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="namespace_base")
public class NameSpaceBase implements LongBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="qualified_name_space" , length=1000 , nullable=false)
	private String qualifiedNameSpace;
	
	@Enumerated 
	private NameSpaceType nameSpaceType;
	
	public NameSpaceBase(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 

	public String getQualifiedNameSpace() {
		return qualifiedNameSpace;
	}

	public void setQualifiedNameSpace(String qualifiedNameSpace) {
		this.qualifiedNameSpace = qualifiedNameSpace;
	}
	
	public NameSpaceType getNameSpaceType() {
		return nameSpaceType;
	}

	public void setNameSpaceType(NameSpaceType nameSpaceType) {
		this.nameSpaceType = nameSpaceType;
	}

}
