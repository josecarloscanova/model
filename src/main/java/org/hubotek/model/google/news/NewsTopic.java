package org.hubotek.model.google.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hubotek.model.google.GoogleBase;

@Entity
@SuppressWarnings("serial")
@Table(name="news_topic")
public class NewsTopic extends GoogleBase{

	@Column(name="topic" , length=20)
	private String topic;
	
	
	public NewsTopic(){
		super();
	}
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
}
