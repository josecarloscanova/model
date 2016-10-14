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
	protected GoogleResultItem googleResultItem;
	
	public GoogleSearchResult(){}

	public GoogleResultItem getGoogleResultItem() {
		return googleResultItem;
	}

	public void setGoogleResultItem(GoogleResultItem googleResultItem) {
		this.googleResultItem = googleResultItem;
	}

}
