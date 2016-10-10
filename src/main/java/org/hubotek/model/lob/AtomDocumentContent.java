package org.hubotek.model.lob;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="lob_result_item")
@SuppressWarnings("serial")
public class AtomDocumentContent extends LobBase{


	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(name="content")
	protected String content;

	
	public AtomDocumentContent(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
