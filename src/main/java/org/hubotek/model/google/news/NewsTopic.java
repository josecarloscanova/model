package org.hubotek.model.google.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hubotek.model.google.GoogleBase;
import org.nanotek.LongBase;

@SuppressWarnings("serial")
@Entity
@Table(name="news_topic")
public class NewsTopic implements LongBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;

	@Column(name="topic" , length=20)
	private String topic;
	
	
	public NewsTopic(){
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
}
