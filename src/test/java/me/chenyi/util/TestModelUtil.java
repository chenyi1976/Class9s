package me.chenyi.util;

import java.io.IOException;
import java.util.List;

import me.chenyi.model.GroupData;
import me.chenyi.model.GroupEntity;
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
}
