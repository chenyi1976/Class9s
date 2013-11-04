package me.chenyi.ws;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

import me.chenyi.model.GroupData;
import me.chenyi.util.ModelUtil;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created with IntelliJ IDEA. User: yichen1976 Date: 3/11/2013 Time: 9:30 AM To change this template use File |
 * Settings | File Templates.
 */
@Path("/group")
public class GroupService
{
    private String generateJsonString(Object obj)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private Response generateJsonResponse(Object obj)
    {
        String jsonStr = generateJsonString(obj);
        if (jsonStr != null)
            return Response.status(HttpServletResponse.SC_OK).entity(jsonStr).build();
        else
            return Response.status(HttpServletResponse.SC_NOT_FOUND).build();
    }

    @GET
    @Path("/list/{start}/{count}")
    public Response list(@PathParam("start") int start, @PathParam("count") int count)
    {
        List<GroupData> groupList = ModelUtil.listGroup(start, count);
        return generateJsonResponse(groupList);
    }

    @POST
    @Path("/add")
    public Response add(@FormParam("name") String name, @FormParam("pin1") String pin1, @FormParam("pin2") String pin2)
    {
        GroupData groupData = ModelUtil.createGroup(name, pin1, pin2);
        return generateJsonResponse(groupData);
    }

    @POST
    @Path("/findById")
    public Response findById(@FormParam("id") int id)
    {
        GroupData groupData = ModelUtil.findGroup(id);
        return generateJsonResponse(groupData);
    }

    @POST
    @Path("/findByName")
    public Response findByName(@FormParam("name") String name)
    {
        GroupData groupData = ModelUtil.findGroup(name);
        return generateJsonResponse(groupData);
    }

    @POST
    @Path("/update")
    public Response update(@FormParam("id") int id, @FormParam("name") String name,
                           @FormParam("pin1") String pin1, @FormParam("pin2") String pin2)
    {
        GroupData groupData = ModelUtil.updateGroup(id, name, pin1, pin2);
        return generateJsonResponse(groupData);
    }
}