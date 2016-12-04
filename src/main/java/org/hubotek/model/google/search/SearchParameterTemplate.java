package org.hubotek.model.google.search;

import javax.persistence.Entity;


/**
 * "https://www.googleapis.com/customsearch/v1?q={searchTerms}&num={count?}
 * &start={startIndex?}&lr={language?}&safe={safe?}
 * &cx={cx?}&cref={cref?}&sort={sort?}&filter={filter?}
 * &gl={gl?}&cr={cr?}&googlehost={googleHost?}
 * &c2coff={disableCnTwTranslation?}
 * &hq={hq?}
 * &hl={hl?}
 * &siteSearch={siteSearch?}
 * &siteSearchFilter={siteSearchFilter?}
 * &exactTerms={exactTerms?}
 * &excludeTerms={excludeTerms?}
 * &linkSite={linkSite?}
 * &orTerms={orTerms?}&relatedSite={relatedSite?}
 * &dateRestrict={dateRestrict?}
 * &lowRange={lowRange?}
 * &highRange={highRange?}
 * &searchType={searchType}
 * &fileType={fileType?}&rights={rights?}
 * &imgSize={imgSize?}
 * &imgType={imgType?}
 * &imgColorType={imgColorType?}
 * &imgDominantColor={imgDominantColor?}&alt=json"
 * @author JoseCanova
 *
 */
@Entity
public class SearchParameterTemplate {
	
	private String searchTerms; 
	
	private Integer num; 
	
	private Integer startIndex;

	private String language; 
	
	private String safe;
	
	private String cx;
	
	private String cref;
	
	private String sort;
	
	private String filter; 
	
	private String alt;
	
	private String country;
	
	
	public String getSearchTerms() {
		return searchTerms;
	}

	public void setSearchTerms(String searchTerms) {
		this.searchTerms = searchTerms;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSafe() {
		return safe;
	}

	public void setSafe(String safe) {
		this.safe = safe;
	}

	public String getCx() {
		return cx;
	}

	public void setCx(String cx) {
		this.cx = cx;
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
}
