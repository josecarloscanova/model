package org.nanotek;

import javax.json.Json;
import javax.json.JsonObject;

public interface LongBase extends Base<Long>{
	
		default JsonObject  toJson () 
		{ 
			return Json.createObjectBuilder().add("id", getId()).build();
		}
}
