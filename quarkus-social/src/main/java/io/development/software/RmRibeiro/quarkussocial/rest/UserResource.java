package io.development.software.RmRibeiro.quarkussocial.rest;

import io.development.software.RmRibeiro.quarkussocial.domain.model.User;
import io.development.software.RmRibeiro.quarkussocial.rest.dto.CreateUserRequest;
import io.development.software.RmRibeiro.quarkussocial.rest.dto.CreateUserResponse;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")


public class UserResource {
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser( CreateUserRequest userRequest ) {
        User user = new User();
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.persist();

        var response = new CreateUserResponse(user.getId(), user.getName(), user.getAge(), user.getEmail());
        return Response.status(201).entity(response).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllUsers() {
        return Response.ok().build();
    }
}
