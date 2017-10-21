package io.orten.nano.business;

import io.orten.nano.impl.OrganizationService;
import io.orten.nano.model.Organization;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/org")
public class OrganizationAPI {

    @POST
    @Path("/saveOrg")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveInDatabase(Organization org)
    {
        return new OrganizationService().save(org);
    }

    @PUT
    @Path("/updateOrg")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrg(Organization org)
    {
      return new OrganizationService().update(org);
    }
}