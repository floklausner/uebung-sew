package at.htl.boundary;

import at.htl.control.EntryRepository;
import at.htl.entity.Entry;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/entry")
public class EntryResource {

    @Inject
    EntryRepository entryRepository;

    @GET
    public Response findAllEntries() {
        return Response.ok(entryRepository.findAll().list()).build();
    }

    @GET
    @Path("/{id}")
    public Response findEntryById(@PathParam("id") long id) {
        return Response.ok(entryRepository.findById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveEntry(Entry entry) {
        return Response.ok(entryRepository.save(entry)).build();
    }

}
