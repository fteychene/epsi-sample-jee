package fte.tests.jeerestcdi.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fte.tests.jeerestcdi.rest.entity.Address;
import fte.tests.jeerestcdi.rest.service.AddressService;

@Path("/address")
public class AddressController {
	
	@Inject
	private AddressService service;
	
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Address> getAll() {
		return service.findAll();
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Address get(@PathParam("id") Long id) {
		return service.find(id);
	}
	
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Address> create(List<Address> addresses) {
		return addresses.stream().map(service::save).collect(Collectors.toList());
	}
	
	@Path("/{id}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Address create(@PathParam("id") Long id, Address address) {
		address.setId(id);
		return service.save(address);
	}
	
	@Path("/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Address update(@PathParam("id") Long id, Address address) {
		address.setId(id);
		return service.update(address);
	}
	
	@Path("/{id}")
	@DELETE
	@Transactional
	public void delete(@PathParam("id") Long id) {
		service.delete(id);
	}
}
