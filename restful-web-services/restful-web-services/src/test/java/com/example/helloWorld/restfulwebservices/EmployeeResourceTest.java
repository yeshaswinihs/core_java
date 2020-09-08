package com.example.helloWorld.restfulwebservices;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import com.example.helloWorld.restfulwebservices.domain.EmployeeDomain;
import com.example.helloWorld.restfulwebservices.dto.Employee;

public class EmployeeResourceTest {
	
	DozerBeanMapper dozerBeanMapper;
	
	@Before
	public void before() throws Exception{
		dozerBeanMapper = new DozerBeanMapper();
		
	}
	
	public void configureMapper(String... mappingFileUrls) {
		dozerBeanMapper.setMappingFiles(Arrays.asList(mappingFileUrls));
	}
	
	@Test
	public void givenSourceAndDestClass_mapsFieldsNameSame() {
		configureMapper("dozer_mapping.xml");
		Employee employee = new Employee(1,"Vishwas", 25);
		EmployeeDomain employeeDomain = dozerBeanMapper.map(employee, EmployeeDomain.class);
		//assertEquals(employeeDomain.getNamo(), "Vishwas");
		assertEquals(employeeDomain.getAge(), 25);
	}
	
	@Test
	public void givenSourceAndDestClass_mapsOnlyFieldsNames() {
		configureMapper("dozer_mapping2.xml");
		Employee employee = new Employee(1,"Vishwas", 25);
		EmployeeDomain employeeDomain = dozerBeanMapper.map(employee, EmployeeDomain.class, "employeeMapOnlyFields");
		//assertEquals(employeeDomain.getNamo(), "Vishwas");
//		assertEquals(employeeDomain.getAge(), 25);
	}
	
}
