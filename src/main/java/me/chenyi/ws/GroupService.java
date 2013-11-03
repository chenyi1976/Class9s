package me.chenyi.ws;

import me.chenyi.model.GroupEntity;
import me.chenyi.util.ModelUtil;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: yichen1976
 * Date: 3/11/2013
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/group")
public class GroupService {
    @POST
    @Path("/add")
    public Response add(@FormParam("name") String name,
                        @FormParam("pin1") String pin1, @FormParam("pin2") String pin2) {
        ModelUtil.createGroup(name, pin1, pin2);
        //should return different code based on different result;
        return Response.status(200).entity("OK, created").build();
    }

    @POST
    @Path("/get")
    public Response get(@FormParam("id") int id) {
        GroupEntity group = ModelUtil.findGroup(id);
        //need to work out how to generate json object and return
        return Response.status(200).entity("OK, got.").build();
    }

    @POST
    @Path("/update")
    public Response update(@FormParam("id") int id, @FormParam("name") String name,
                           @FormParam("pin1") String pin1, @FormParam("pin2") String pin2) {
        ModelUtil.updateGroup(id, name, pin1, pin2);
        //should return different code based on different result;
        return Response.status(200).entity("OK, got.").build();
    }

}