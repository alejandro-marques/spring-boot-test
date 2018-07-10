package org.amarques.spring.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/health")
public class HealthController {
	private static final Logger logger = LoggerFactory.getLogger(HealthController.class);
	
	@RequestMapping(value={"/ping"}, method=RequestMethod.GET, produces = "application/json")
	public String ping () throws Exception{
		logger.info("Received health request");
		return "{\"status\": \"OK\"}";
	}
}