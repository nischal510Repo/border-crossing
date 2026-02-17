package com.example.bordercrossing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class BorderService {
	
	public List<String> findRoute(String origin,String destination){
		if(!DataSource.countries.containsKey(origin) || !DataSource.countries.containsKey(destination)) {
			return null;
		}
		Map<String,String> entry = new HashMap<>();
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		
		queue.add(origin);
		visited.add(origin);
		
		while(queue.size()>0) {
			String current = queue.remove();
			if(current.equalsIgnoreCase(destination)) {
				break;
			}
			for(String visit : DataSource.countries.get(current).getBorders()) {
				if(visited.contains(visit)) {
					continue;
				}
				queue.add(visit);
				visited.add(visit);
				entry.put(visit, current);
			}
		}
		List<String> route = new ArrayList<>();
		route.add(destination);
		String walkBack = destination;
		while(!walkBack.equalsIgnoreCase(origin)) {
			if (entry.get(walkBack) == null) {
				return null;
			}
			route.add(entry.get(walkBack));
			walkBack = entry.get(walkBack);
		}
		
		List<String> reversedRoute = new ArrayList<>(route);
		Collections.reverse(reversedRoute);
		return reversedRoute;
	}
	
}
