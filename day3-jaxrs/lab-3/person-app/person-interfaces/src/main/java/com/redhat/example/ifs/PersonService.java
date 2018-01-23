package com.redhat.example.ifs;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.redhat.example.model.Person;

@Path("/persons")
@Consumes("text/plain")
public interface PersonService {

	@POST
	@Consumes("application/json")
	void create(Person entry) throws BusinessException;

	@GET
	@Produces("application/json")
	List<Person> findAll();

	@GET
	@Path("{id}")
	@Produces("application/json")
	Person find(@PathParam("id") int id);

	@PUT
	void update(Person entity);

	@DELETE
	@Path("{id}")
	void remove(@PathParam("id") int id);

}