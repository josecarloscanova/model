package org.hubotek.model.rss.ext;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.nanotek.LongBase;

/**
 * private final static QName _Relation_QNAME = new QName("http://purl.org/dc/elements/1.1/", "relation");
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
@SuppressWarnings("serial")
@Entity
@Table(name="namespace_base")
public class NameSpaceBase implements LongBase{

	private Long id;
	
	private String qualifiedNameSpace;
	
	@Enumerated 
	private NameSpaceType nameSpaceType;
	
	public NameSpaceBase(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 

	public String getQualifiedNameSpace() {
		return qualifiedNameSpace;
	}

	public void setQualifiedNameSpace(String qualifiedNameSpace) {
		this.qualifiedNameSpace = qualifiedNameSpace;
	}
	
	public NameSpaceType getNameSpaceType() {
		return nameSpaceType;
	}

	public void setNameSpaceType(NameSpaceType nameSpaceType) {
		this.nameSpaceType = nameSpaceType;
	}

}
