package me.chenyi.ws;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import me.chenyi.model.GroupData;
import me.chenyi.util.ModelUtil;

@Path("/group")
public class GroupService
{
    @GET
    @Path("/list/{start}/{count}")
    public Response list(@PathParam("start") int start, @PathParam("count") int count)
    {
        List<GroupData> groupList = ModelUtil.listGroup(start, count);
        return JsonUtil.generateJsonResponse(groupList);
    }

    @POST
    @Path("/add")
    public Response add(@FormParam("name") String name, @FormParam("pin1") String pin1, @FormParam("pin2") String pin2)
    {
        GroupData groupData = ModelUtil.createGroup(name, pin1, pin2);
        return JsonUtil.generateJsonResponse(groupData);
    }

    @POST
    @Path("/findById")
    public Response findById(@FormParam("id") int id)
    {
        GroupData groupData = ModelUtil.findGroup(id);
        return JsonUtil.generateJsonResponse(groupData);
    }

    @POST
    @Path("/findByName")
    public Response findByName(@FormParam("name") String name)
    {
        GroupData groupData = ModelUtil.findGroup(name);
        return JsonUtil.generateJsonResponse(groupData);
    }

    @POST
    @Path("/update")
    public Response update(@FormParam("id") int id, @FormParam("name") String name,
                           @FormParam("pin1") String pin1, @FormParam("pin2") String pin2)
    {
        GroupData groupData = ModelUtil.updateGroup(id, name, pin1, pin2);
        return JsonUtil.generateJsonResponse(groupData);
    }
}