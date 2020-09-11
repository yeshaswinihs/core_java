package com.example.helloWorld.restfulwebservices.customConverters;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

public class ListToStringConverter extends DozerConverter<List, String> implements MapperAware {

	private Mapper mapper;

	public ListToStringConverter() {
		super(List.class, String.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;

	}

	@Override
	public String convertTo(List source, String destination) {
		String joinedString = String.join(",", source);
		return joinedString;
	}

	@Override
	public List convertFrom(String source, List destination) {
		List<String> lists = Stream.of(source.split(",")).map(String::trim).collect(Collectors.toList());
		return lists;
	}

}
