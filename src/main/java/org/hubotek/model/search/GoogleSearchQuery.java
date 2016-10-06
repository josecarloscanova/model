package org.hubotek.model.search;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Stored Search Query's for history purposes.
 * @author JoseCanova
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="google_search")
public class GoogleSearchQuery extends QueryBase{

	@Column(name="query" , length=2000 , insertable=true , updatable=false , nullable=false)
	private String query;
	
}
