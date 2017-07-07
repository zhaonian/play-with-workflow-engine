package com.luan.activitispring;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ActivitiSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiSpringApplication.class, args);
	}
	
	@RestController
	public static class MyRestController {
		
		@Autowired
		private RuntimeService runtimeService;
		
		@RequestMapping(value="/start", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public void startProcess() {
			runtimeService.startProcessInstanceByKey("TestProecss");
			System.out.println("# process: " + runtimeService.createProcessInstanceQuery().count());
		}
	}
}


