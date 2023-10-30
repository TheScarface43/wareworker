package com.github.thescarface43;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/test")
	public String index() {
		return "WareWorker test page.";
	}
}