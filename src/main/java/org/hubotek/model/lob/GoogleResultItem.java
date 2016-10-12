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
public class GoogleResultItem extends LobBase{

	public GoogleResultItem(){
		super();
	}
	
	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(name="result")
	protected String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
