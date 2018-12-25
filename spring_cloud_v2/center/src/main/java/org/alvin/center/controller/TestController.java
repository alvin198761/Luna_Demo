package org.alvin.center.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

	@RequestMapping("data")
	public Map<String, Object> getData() {
		Map<String, Object> map = new HashMap<>();
		map.put("test", "test");
		return map;
	}
}
