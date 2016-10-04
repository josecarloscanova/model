package org.nanotek;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface LongBase extends Base<Long>{
	
		//TODO: Fix the default method.
		default JsonObject  toJson () 
		{ 
			return Json.createObjectBuilder().add("id", getId()).build();
		}
}
