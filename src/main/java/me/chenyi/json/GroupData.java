package me.chenyi.json;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yichen1976
 * Date: 3/11/2013
 * Time: 9:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class GroupData {
    private int id;
    private String name;
    private String pin1;
    private String pin2;
    private Date lastUpdate;

    public GroupData(int id, String name, String pin1, String pin2, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.pin1 = pin1;
        this.pin2 = pin2;
        this.lastUpdate = lastUpdate;
    }
}
