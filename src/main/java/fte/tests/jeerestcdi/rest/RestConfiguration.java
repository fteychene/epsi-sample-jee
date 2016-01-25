package fte.tests.jeerestcdi.rest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fte.tests.jeerestcdi.rest.controller.AddressController;
import fte.tests.jeerestcdi.rest.service.AddressService;

@ApplicationPath("/rest")
public class RestConfiguration extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return new HashSet<Class<?>>(Arrays.asList(GreetController.class, AddressController.class));
	}

	
}
