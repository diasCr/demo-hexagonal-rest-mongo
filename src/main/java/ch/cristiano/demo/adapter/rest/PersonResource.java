package ch.cristiano.demo.adapter.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(PersonDto person) {
        this.personService.create(person.toDomain());
        return Response.ok().build();
    }

    @GET
    @Path("/{_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIdString(@PathParam("_id") String id) {
        Person foundPerson = this.personService.readPersonByIdString(id);
        return Response.ok().entity(new PersonDto().ofDomain(foundPerson)).build();
    }

}
