package com.github.ttwd80.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import net.sf.ehcache.Ehcache;

@Service
public class EhcacheCacheService implements CacheService {

	@Autowired
	CacheManager cacheManager;

	private final String cacheName = "default-cache";

	@Override
	public List<String> listKeys() {
		List<?> list = getNativeCache().getKeys();
		List<String> keys = new ArrayList<>();
		for (Object object : list) {
			keys.add(object.toString());
		}
		return keys;
	}

	private Cache getCache() {
		return cacheManager.getCache(cacheName);
	}

	private Ehcache getNativeCache() {
		return (Ehcache) getCache().getNativeCache();
	}

}
