package org.hubotek.model.search;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.lob.LobResultItem;

@Entity
@Table(name="google_search_result")
@SuppressWarnings("serial")
public class GoogleSearchResult extends ResultBase{

	@OneToOne
	protected LobResultItem lobResultItem;
	
	public GoogleSearchResult(){}

	public LobResultItem getLobResultItem() {
		return lobResultItem;
	}

	public void setLobResultItem(LobResultItem lobResultItem) {
		this.lobResultItem = lobResultItem;
	}
	
}
