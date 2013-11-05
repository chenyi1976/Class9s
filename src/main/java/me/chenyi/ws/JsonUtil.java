package me.chenyi.ws;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil
{
    static String generateJsonString(Object obj)
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

    static Response generateJsonResponse(Object obj)
    {
        String jsonStr = generateJsonString(obj);
        if(jsonStr != null)
        {
            return Response.status(HttpServletResponse.SC_OK).entity(jsonStr).build();
        }
        else
        {
            return Response.status(HttpServletResponse.SC_NOT_FOUND).build();
        }
    }
}