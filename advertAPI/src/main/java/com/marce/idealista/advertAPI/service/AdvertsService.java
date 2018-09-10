package com.marce.idealista.advertAPI.service;

public interface AdvertsService<T, S> {
	
	public S service(T object) throws Exception;
	
}
