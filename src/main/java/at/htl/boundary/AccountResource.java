package at.htl.boundary;

import at.htl.control.AcountRepository;
import at.htl.entity.Account;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    AcountRepository acountRepository;

    @GET
    public Response findAllAccounts() {
        return Response.ok(acountRepository.findAll().list()).build();
    }

    @GET
    @Path("{id}")
    public Response findAccountById(@PathParam("id") long id) {
        return Response.ok(acountRepository.findById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveAccount(Account account) {
        return Response.ok(acountRepository.save(account)).build();
    }

}
