package me.chenyi.util;

import me.chenyi.model.GroupEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: yichen1976
 * Date: 2/11/2013
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class ModelUtil {

    //group part

    /**
     * need to check name duplication
     * pin1, pin2 can not be empty
     * return value should indicated if the group created.
     * @param name
     * @param pin1
     * @param pin2
     */
    public static void createGroup(String name, String pin1, String pin2) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            GroupEntity groupEntity = new GroupEntity();
            groupEntity.setName(name);
            groupEntity.setPin1(pin1);
            groupEntity.setPin2(pin2);
            groupEntity.setLastUpdate(new Timestamp(System.currentTimeMillis()));

            entityManager.persist(groupEntity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        } finally {
            entityManager.close();
        }
    }

    public static void updateGroup(int id, String name, String pin1, String pin2) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
            GroupEntity groupEntity = entityManager.find(GroupEntity.class, new Integer(id));

            if (groupEntity == null)
                return;

            entityManager.getTransaction().begin();

            //todo: how to get the existing group?

            groupEntity.setName(name);
            groupEntity.setPin1(pin1);
            groupEntity.setPin2(pin2);
            groupEntity.setLastUpdate(new Timestamp(System.currentTimeMillis()));

            entityManager.persist(groupEntity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        } finally {
            entityManager.close();
        }
    }

    public static GroupEntity findGroup(int id) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
            GroupEntity groupEntity = entityManager.find(GroupEntity.class, new Integer(id));

            return groupEntity;
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        } finally {
            entityManager.close();
        }
        return null;
    }

    public static GroupEntity findGroup(String name) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
            GroupEntity groupEntity = null;//entityManager.find(GroupEntity.class, new Integer(id));

            return groupEntity;
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        } finally {
            entityManager.close();
        }
        return null;
    }

    //get contact id list by group.

    //contact part

    //when contact get updated, it should update the "last update field" in group.

    //1. add contact
    //2. update contact
    //3. remove contact
    //4. find contact by id

    //avator part

    //1. add avator
    //2. update avator
    //3. remove avator
    //4. find avator by id
}
