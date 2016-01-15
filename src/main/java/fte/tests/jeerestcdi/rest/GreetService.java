package fte.tests.jeerestcdi.rest;

import javax.ejb.Stateless;

@Stateless
public class GreetService {
	
	public String greet(String name) {
		return "Hello "+ name;
	}

}
