package com.example.bordercrossing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.URL;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class BorderCrossingApplication {

	public static Map<String, Country> countries = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(BorderCrossingApplication.class, args);
		String dataSource = "https://raw.githubusercontent.com/mledoze/countries/master/countries.json";
		ObjectMapper mapper = new ObjectMapper();

		try {
			List<Country> countriesList = mapper.readValue(new URL(dataSource), new TypeReference<List<Country>>() {
			});
			DataSource.countries = countriesList.stream().collect(
					Collectors.toMap(Country::getCca3, country -> country, (existing, replacement) -> existing));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
