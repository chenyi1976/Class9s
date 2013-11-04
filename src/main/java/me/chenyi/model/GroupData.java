package me.chenyi.model;

import java.util.Date;

/**
 * Class description goes here
 *
 * @author $Author:$
 * @version $Revision:$
 */
public class GroupData
{
    private int id = -1;
    private String name;
    private String pin1;
    private String pin2;
    private Date lastUpdate;

    public GroupData(GroupEntity ge)
        throws IllegalArgumentException
    {
        if (ge == null)
            throw new IllegalArgumentException("null group entity");
        this.id = ge.getId();
        this.name = ge.getName();
        this.pin1 = ge.getPin1();
        this.pin2 = ge.getPin2();
        this.lastUpdate = ge.getLastUpdate();
    }

    public GroupData(int id, String name, String pin1, String pin2, Date lastUpdate)
    {
        this.id = id;
        this.name = name;
        this.pin1 = pin1;
        this.pin2 = pin2;
        this.lastUpdate = lastUpdate;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPin1()
    {
        return pin1;
    }

    public void setPin1(String pin1)
    {
        this.pin1 = pin1;
    }

    public String getPin2()
    {
        return pin2;
    }

    public void setPin2(String pin2)
    {
        this.pin2 = pin2;
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
