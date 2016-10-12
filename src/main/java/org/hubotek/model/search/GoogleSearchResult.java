package org.hubotek.model.search;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.lob.GoogleResultItem;

@Entity
@Table(name="google_search_result")
@SuppressWarnings("serial")
public class GoogleSearchResult extends ResultBase{

	@OneToOne
	protected GoogleResultItem lobResultItem;
	
	public GoogleSearchResult(){}

	public GoogleResultItem getLobResultItem() {
		return lobResultItem;
	}

	public void setLobResultItem(GoogleResultItem lobResultItem) {
		this.lobResultItem = lobResultItem;
	}

}
