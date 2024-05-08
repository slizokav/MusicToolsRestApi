package com.slizokav.MusicToolsRestApi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MusicToolsRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicToolsRestApiApplication.class, args);
	}
	@Bean
	public ModelMapper ModelMapper() {
		return new ModelMapper();
	}

}
