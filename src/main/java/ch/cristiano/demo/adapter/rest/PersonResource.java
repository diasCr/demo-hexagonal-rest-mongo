package ch.cristiano.demo.adapter.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import ch.cristiano.demo.adapter.rest.dto.PersonDto;
import ch.cristiano.demo.application.domain.Person;
import ch.cristiano.demo.application.port.in.PersonService;

@Path("/persons")
public class PersonResource {

    @Inject
    PersonService personService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        Person foundPerson = this.personService.readPersonById(id);
        return Response.ok().entity(new PersonDto().ofDomain(foundPerson)).build();
    }

}
