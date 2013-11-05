package me.chenyi.ws;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

import me.chenyi.model.ContactData;
import me.chenyi.util.ModelUtil;

@Path("/contact")
public class ContactService
{
    //todo: verify user before return data.

    @POST
    @Path("/list}")
    public Response list(@FormParam("groupId") int groupId)
    {
        List<ContactData> contactDataList = ModelUtil.listContactForGroup(groupId);
        return JsonUtil.generateJsonResponse(contactDataList);
    }

    @POST
    @Path("/add")
    public Response add(@FormParam("groupId") int groupId,
                        @FormParam("name") String name,
                        @FormParam("phone") String phone,
                        @FormParam("phone2") String phone2,
                        @FormParam("email") String email,
                        @FormParam("email") String email2,
                        @FormParam("wechat") String wechat,
                        @FormParam("city") String city)
    {
        ContactData contactData = ModelUtil.createContact(groupId, name, phone, phone2, email, email2, city, wechat);
        return JsonUtil.generateJsonResponse(contactData);
    }

    @POST
    @Path("/findById")
    public Response findById(@FormParam("id") int id)
    {
        ContactData contactData = ModelUtil.findContact(id);
        return JsonUtil.generateJsonResponse(contactData);
    }

    @POST
    @Path("/findByName")
    public Response findByName(@FormParam("name") String name)
    {
        ContactData contactData = ModelUtil.findContact(name);
        return JsonUtil.generateJsonResponse(contactData);
    }

    @POST
    @Path("/update")
    public Response update(@FormParam("contactId") int contactId,
                           @FormParam("name") String name,
                           @FormParam("phone") String phone,
                           @FormParam("phone2") String phone2,
                           @FormParam("email") String email,
                           @FormParam("email") String email2,
                           @FormParam("wechat") String wechat,
                           @FormParam("city") String city)
    {
        ContactData contactData = ModelUtil.updateContact(contactId, name, phone, phone2, email, email2, city, wechat);
        return JsonUtil.generateJsonResponse(contactData);
    }

    @POST
    @Path("/remove")
    public Response update(@FormParam("contactId") int contactId)
    {
        boolean deleted = ModelUtil.deleteContact(contactId);
        if (deleted)
            return Response.status(HttpServletResponse.SC_OK).build();
        else
            return Response.status(HttpServletResponse.SC_NOT_FOUND).build();
    }
}