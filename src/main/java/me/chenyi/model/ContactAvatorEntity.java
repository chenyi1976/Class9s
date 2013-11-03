package me.chenyi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: yichen1976
 * Date: 2/11/2013
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(me.chenyi.model.ContactAvatorEntityPK.class)
@javax.persistence.Table(name = "contact_avator", schema = "", catalog = "class9")
@Entity
public class ContactAvatorEntity {
    private int contactId;
    private int avatorId;

    @javax.persistence.Column(name = "contact_id")
    @Id
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @javax.persistence.Column(name = "avator_id")
    @Id
    public int getAvatorId() {
        return avatorId;
    }

    public void setAvatorId(int avatorId) {
        this.avatorId = avatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactAvatorEntity that = (ContactAvatorEntity) o;

        if (avatorId != that.avatorId) return false;
        if (contactId != that.contactId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactId;
        result = 31 * result + avatorId;
        return result;
    }
}
