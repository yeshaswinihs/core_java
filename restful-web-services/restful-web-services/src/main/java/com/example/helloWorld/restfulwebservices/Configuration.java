package com.example.helloWorld.restfulwebservices;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public Mapper mapper() {
		//List<String> mappingFiles= Arrays.asList("dozer_mapping.xml", "dozer_mapping2.xml");
		DozerBeanMapper mapper = new DozerBeanMapper();
		//mapper.setMappingFiles(mappingFiles);
		return mapper;
	}
}
