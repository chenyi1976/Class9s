package me.chenyi.model;

import java.util.Date;

/**
 * Class description goes here
 *
 * @author $Author:$
 * @version $Revision:$
 */
public class ContactData
{
    private int id = -1;
    private String name;
    private String phone;
    private String phone2;
    private String email;
    private String email2;
    private String wechat;
    private String city;
    private Date lastUpdate;

    public ContactData(ContactEntity ce)
        throws IllegalArgumentException
    {
        if (ce == null)
            throw new IllegalArgumentException("null group entity");
        this.id = ce.getId();
        this.name = ce.getName();
        this.phone = ce.getPhone();
        this.phone2 = ce.getPhone2();
        this.email = ce.getEmail();
        this.email2 = ce.getEmail2();
        this.wechat = ce.getWechat();
        this.city = ce.getCity();
        this.lastUpdate = ce.getLastUpdate();
    }


    public ContactData(String name, String phone, String phone2, String email, String email2,
                       String wechat, String city, Date lastUpdate)
    {
        this.name = name;
        this.phone = phone;
        this.phone2 = phone2;
        this.email = email;
        this.email2 = email2;
        this.wechat = wechat;
        this.city = city;
        this.lastUpdate = lastUpdate;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone2()
    {
        return phone2;
    }

    public void setPhone2(String phone2)
    {
        this.phone2 = phone2;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail2()
    {
        return email2;
    }

    public void setEmail2(String email2)
    {
        this.email2 = email2;
    }

    public String getWechat()
    {
        return wechat;
    }

    public void setWechat(String wechat)
    {
        this.wechat = wechat;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public Date getLastUpdate()
    {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }
}
