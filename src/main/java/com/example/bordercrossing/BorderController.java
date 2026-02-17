package com.example.bordercrossing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routing")
public class BorderController {

	private final BorderService borderService;
	
	@Autowired
	public BorderController(BorderService borderService) {
		this.borderService=borderService;
	}
	
	@GetMapping("/{origin}/{destination}")
	public ResponseEntity<List<String>> checkRoute(@PathVariable String origin, @PathVariable String destination){
		List<String> route = borderService.findRoute(origin, destination);
		if (route == null || route.isEmpty()) {
	        return ResponseEntity.badRequest().build();
	    }
	    return ResponseEntity.ok(route);
	}
	
}
