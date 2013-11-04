package me.chenyi.util;

import me.chenyi.model.GroupData;
import me.chenyi.model.GroupEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    public static GroupData createGroup(String name, String pin1, String pin2) {

        GroupData result = null;

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

            result = new GroupData(groupEntity);

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        } finally {
            entityManager.close();
        }

        return result;
    }

    public static GroupData updateGroup(int id, String name, String pin1, String pin2) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
            GroupEntity groupEntity = entityManager.find(GroupEntity.class, new Integer(id));

            if (groupEntity == null)
                return null;

            entityManager.getTransaction().begin();

            groupEntity.setName(name);
            groupEntity.setPin1(pin1);
            groupEntity.setPin2(pin2);
            groupEntity.setLastUpdate(new Timestamp(System.currentTimeMillis()));

            entityManager.persist(groupEntity);
            entityManager.getTransaction().commit();

            return new GroupData(groupEntity);
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

    public static GroupData findGroup(int id) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
            GroupEntity groupEntity = entityManager.find(GroupEntity.class, new Integer(id));
            return new GroupData(groupEntity);
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

    public static GroupData findGroup(String name) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("Select ge from GroupEntity ge where ge.name=:arg1");
            query.setParameter("arg1", name);
            GroupEntity groupEntity = (GroupEntity)query.getSingleResult();
            return new GroupData(groupEntity);
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

    public static List<GroupData> listGroup(int start, int count) {
        List<GroupData> result = new ArrayList();

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try
        {
            Query query = entityManager.createQuery("Select ge from GroupEntity ge");
            List resultList = query.getResultList();
            int from = Math.max(start, resultList.size() - count);
            int to = Math.min(start + count, resultList.size());

            for(int i = from; i < to; i++)
            {
                GroupEntity groupEntity = (GroupEntity)resultList.get(i);
                result.add(new GroupData(groupEntity));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        } finally {
            entityManager.close();
        }

        return result;
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
