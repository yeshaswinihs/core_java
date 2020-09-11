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
//		List<String> mappingFiles = Arrays.asList("dozer_mapping.xml");
		DozerBeanMapper mapper = new DozerBeanMapper();
//		mapper.setMappingFiles(mappingFiles);
		return mapper;
	}

	// To be Fix

//	getting ClassCastException User cannot be cast to User, for http://localhost:8080/submitUser
//		when dozer reading custom dozer_mapping.xml mapping, but test class works. So commented the above lines, But default dozer works.
}
