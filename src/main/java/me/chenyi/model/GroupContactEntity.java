package me.chenyi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: yichen1976
 * Date: 2/11/2013
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(me.chenyi.model.GroupContactEntityPK.class)
@javax.persistence.Table(name = "group_contact", schema = "", catalog = "class9")
@Entity
public class GroupContactEntity {
    private int groupId;

    @javax.persistence.Column(name = "group_id")
    @Id
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    private int contactId;

    @javax.persistence.Column(name = "contact_id")
    @Id
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

        GroupContactEntity that = (GroupContactEntity) o;

        if (contactId != that.contactId) return false;
        if (groupId != that.groupId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + contactId;
        return result;
    }
}
