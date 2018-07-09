package org.amarques.spring.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/health")
public class HealthController {
	
	@RequestMapping(value={"/ping"}, method=RequestMethod.GET, produces = "application/json")
	public String ping () throws Exception{
		return "{\"status\": \"OK\"}";
	}
}