package org.hubotek.model.search;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hubotek.model.lob.GoogleQuery;


/**
 * Stored Search Query's for history purposes.
 * @author JoseCanova
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="google_search")
public class GoogleSearchQuery extends QueryBase {

	@OneToOne
	protected GoogleQuery googleQuery;

	public GoogleQuery getGoogleQuery() {
		return googleQuery;
	}

	public void setGoogleQuery(GoogleQuery googleQuery) {
		this.googleQuery = googleQuery;
	} 
	
}
