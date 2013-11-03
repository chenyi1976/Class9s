package me.chenyi.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: yichen1976
 * Date: 2/11/2013
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContactAvatorEntityPK implements Serializable {
    private int contactId;
    private int avatorId;

@Id@Column(name = "contact_id")
public int getContactId() {
    return contactId;
}

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Id@Column(name = "avator_id")
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

        ContactAvatorEntityPK that = (ContactAvatorEntityPK) o;

        if (avatorId != that.avatorId) return false;
        if (contactId != that.contactId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactId;
        result = 31 * result + avatorId;
        return result;
}}
