package org.nanotek;

import javax.json.Json;
import javax.json.JsonObject;

@SuppressWarnings("serial")
public class StringBase implements Base<String>{

	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "StringBase [id=" + id + "]";
	} 
	
	public JsonObject toJson () 
	{ 
		return Json.createObjectBuilder().add("id", getId()).build();
	}
}
