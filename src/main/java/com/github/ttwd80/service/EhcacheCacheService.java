package com.github.ttwd80.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class EhcacheCacheService implements CacheService {

	@Autowired
	CacheManager cacheManager;

	@Override
	public List<String> listKeys() {
		return new ArrayList<>(cacheManager.getCacheNames());
	}

}
