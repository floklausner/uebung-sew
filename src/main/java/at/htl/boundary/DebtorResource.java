package at.htl.boundary;

import at.htl.control.DebtorRepository;
import at.htl.entity.Debtor;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/debtor")
@Produces(MediaType.APPLICATION_JSON)
public class DebtorResource {

    @Inject
    DebtorRepository debtorRepository;

    @GET
    public Response getAllDebtors() {
        return Response.ok(debtorRepository.findAll().list()).build();
    }

    @GET
    @Path("/{id}")
    public Response findDebtorById(@PathParam("id") long id) {
        return Response.ok(debtorRepository.findById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveDebtor(Debtor debtor) {
        return Response.ok(debtorRepository.save(debtor)).build();
    }

}
