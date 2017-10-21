package io.orten.nano.business;

import io.orten.nano.impl.ProjectService;
import io.orten.nano.model.Project;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class ProjectAPI{
    public static List<Project> p_list = new ArrayList<Project>();

    @GET
    @Path("/get/project/{projectID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProject(@PathParam("projectID") String projectID) {
        try {
            Project project = ProjectService.getProject(projectID);
            return Response.status(200).entity(project).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @GET
    @Path("/get/projects")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjects() {
        try {
            List<Project> projects = ProjectService.getProjects();
            return Response.status(200).entity(projects).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @GET
    @Path("/get/projects/{projectName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjectsByName(@PathParam("projectName") String projectName) {
        try {
            List<Project> projects = ProjectService.getProjectsByName(projectName);
            return Response.status(200).entity(projects).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @POST
    @Path("/post/project")
    public Response saveProject(Project project) {
        try {
            ProjectService.saveProject(project);
            return Response.status(200).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @DELETE
    @Path("/delete/project/{projectID}")
    public Response deleteProject(@PathParam("projectID") String projectID) {
        try {
            ProjectService.deleteProject(projectID);
            return Response.status(200).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }
}