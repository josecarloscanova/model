package org.hubotek.model.rss.ext.purl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hubotek.model.rss.ext.NameSpaceBase;

/**
 * /**
 *  private final static QName _Relation_QNAME = new QName("http://purl.org/dc/elements/1.1/", "relation");
    private final static QName _Rights_QNAME = new QName("http://purl.org/dc/elements/1.1/", "rights");
    private final static QName _Format_QNAME = new QName("http://purl.org/dc/elements/1.1/", "format");
    private final static QName _Date_QNAME = new QName("http://purl.org/dc/elements/1.1/", "date");
    private final static QName _Type_QNAME = new QName("http://purl.org/dc/elements/1.1/", "type");
    private final static QName _Creator_QNAME = new QName("http://purl.org/dc/elements/1.1/", "creator");
    private final static QName _Publisher_QNAME = new QName("http://purl.org/dc/elements/1.1/", "publisher");
    private final static QName _Subject_QNAME = new QName("http://purl.org/dc/elements/1.1/", "subject");
    private final static QName _Language_QNAME = new QName("http://purl.org/dc/elements/1.1/", "language");
    private final static QName _Identifier_QNAME = new QName("http://purl.org/dc/elements/1.1/", "identifier");
    private final static QName _Title_QNAME = new QName("http://purl.org/dc/elements/1.1/", "title");
    private final static QName _Source_QNAME = new QName("http://purl.org/dc/elements/1.1/", "source");
    private final static QName _Coverage_QNAME = new QName("http://purl.org/dc/elements/1.1/", "coverage");
    private final static QName _Contributor_QNAME = new QName("http://purl.org/dc/elements/1.1/", "contributor");
    private final static QName _Description_QNAME = new QName("http://purl.org/dc/elements/1.1/", "description");
 * @author JoseCanova
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@SuppressWarnings("serial")
public class PurlBase extends NameSpaceBase{

	@Column(name="relation")
	private String relation;
	
	@Column(name="rights")
	private String rights;
	
	@Column(name="format")
	private String format; 

	@Column(name="date")
	private String date; 

	@Column(name="type")
	private String type; 
	
	@Column(name="creator")
	private String creator; 
	
	@Column(name="publisher")
	private String publisher; 
	
	@Column(name="subject")
	private String subject; 
	
	@Column(name="language")
	private String language; 
	
	@Column(name="identifier")
	private String identifier;
	
	@Column(name="title")
	private String title;
	
	@Column(name="source")
	private String source;
	
	
	public PurlBase(){
		prepare();
	}

	private void prepare() {
	}
	
}
