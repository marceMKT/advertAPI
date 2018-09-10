package com.marce.idealista.advertAPI.mapper;

public interface Mapper<T, S> {
	
	public S mapper(T source);
	
}
