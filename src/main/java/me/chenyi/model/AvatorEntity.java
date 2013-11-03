package me.chenyi.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: yichen1976
 * Date: 2/11/2013
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "avator", schema = "", catalog = "class9")
@Entity
public class AvatorEntity {
    private int id;
    private String file;
    private Timestamp lastUpdate;

    @javax.persistence.Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "file")
    @Basic
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @javax.persistence.Column(name = "last_update")
    @Basic
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvatorEntity that = (AvatorEntity) o;

        if (id != that.id) return false;
        if (file != null ? !file.equals(that.file) : that.file != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (file != null ? file.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
