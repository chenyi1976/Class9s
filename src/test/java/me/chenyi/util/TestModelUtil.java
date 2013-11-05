package me.chenyi.util;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

import me.chenyi.model.ContactData;
import me.chenyi.model.ContactEntity;
import me.chenyi.model.GroupData;
import me.chenyi.model.GroupEntity;
import me.chenyi.ws.ContactService;
import me.chenyi.ws.GroupService;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: yichen1976
 * Date: 2/11/2013
 * Time: 7:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestModelUtil {

    @Test
    public void testCreateGroup()
    {
        ModelUtil.createGroup("Sean", "1234", "5678");
    }

    @Test
    public void testListGroup()
    {
        List<GroupData> groupEntities = ModelUtil.listGroup(0, 10);

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            String s = mapper.writeValueAsString(groupEntities);
            System.out.println("s = " + s);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("groupEntities.size() = " + groupEntities.size());
    }

    @Test
    public void testFindGroupByName()
    {
        GroupData groupData = ModelUtil.findGroup("Sean");

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            String s = mapper.writeValueAsString(groupData);
            System.out.println("s = " + s);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateContact()
    {
        ModelUtil.createContact(1, "SeanUser2", "phone1", "phone2", "email", "email2", "city", "wechat");
        ModelUtil.createContact(1, "SeanUser3", "phone1", "phone2", "email", "email2", "city", "wechat");
    }

    @Test
    public void testListContactForGroup()
    {
        List<ContactData> contactDatas = ModelUtil.listContactForGroup(1);
        System.out.println("contactDatas = " + contactDatas);

        ContactService cs = new ContactService();
        Response response = cs.list(1);
        Object entity = response.getEntity();
        System.out.println("entity = " + entity);
    }

    @Test
    public void testContactData()
    {
        ContactEntity contactData = new ContactEntity();
        System.out.println("contactData.getId() = " + contactData.getId());
        contactData = new ContactEntity();
        System.out.println("contactData.getId() = " + contactData.getId());
    }


}
