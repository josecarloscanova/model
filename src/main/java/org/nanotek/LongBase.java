package org.nanotek;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface LongBase extends Base<Long>{
	
		default JsonObject  toJson () 
		{ 
			return Json.createObjectBuilder().add("id", getId()).build();
		}
}
