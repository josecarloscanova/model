package org.hubotek.model.rss.ext.purl;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hubotek.model.rss.ext.NameSpaceBase;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@SuppressWarnings("serial")
public class PurlBase extends NameSpaceBase{

}
