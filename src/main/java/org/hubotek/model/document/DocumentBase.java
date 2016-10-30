package org.hubotek.model.document;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hubotek.model.HubDocument;
import org.nanotek.LongBase;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class DocumentBase  implements LongBase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_insert")
	protected Date dateInsert;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	} 
}
