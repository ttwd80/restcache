package com.github.ttwd80.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.ttwd80.service.CacheService;

@RestController
public class ListController {

	@Autowired
	CacheService cacheService;

	@ResponseBody
	public List<String> list() {
		return cacheService.listKeys();
	}
}
