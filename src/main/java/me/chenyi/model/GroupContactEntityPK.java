package me.chenyi.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: yichen1976
 * Date: 2/11/2013
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class GroupContactEntityPK implements Serializable {
    private int groupId;
    private int contactId;

@Id@Column(name = "group_id")
public int getGroupId() {
    return groupId;
}

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Id@Column(name = "contact_id")
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupContactEntityPK that = (GroupContactEntityPK) o;

        if (contactId != that.contactId) return false;
        if (groupId != that.groupId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + contactId;
        return result;
}}
