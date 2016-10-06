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
public class LobResultItem extends LobBase{

	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(name="REPORT")
	protected String result;
	
}
