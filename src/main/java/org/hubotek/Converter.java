package org.hubotek;

@FunctionalInterface
public interface Converter<T,O> {

	T convert (O origin);
	
}
