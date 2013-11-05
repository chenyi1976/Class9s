package me.chenyi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import me.chenyi.model.*;

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

    //contact part

    public static ContactData createContact(int groupId, String name, String phone, String phone2, String email,
                                          String email2, String city, String weChat)
    {
        ContactData result = null;

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try
        {
            entityManager.getTransaction().begin();

            Timestamp lastUpdate = new Timestamp(System.currentTimeMillis());

            ContactEntity contactEntity = new ContactEntity();
            contactEntity.setName(name);
            contactEntity.setPhone(phone);
            contactEntity.setPhone2(phone2);
            contactEntity.setEmail(email);
            contactEntity.setEmail2(email2);
            contactEntity.setCity(city);
            contactEntity.setWechat(weChat);
            contactEntity.setLastUpdate(lastUpdate);

            entityManager.persist(contactEntity);

            //force save
            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();

            GroupContactEntity gce = new GroupContactEntity();
            gce.setContactId(contactEntity.getId());
            gce.setGroupId(groupId);
            entityManager.persist(gce);

            GroupEntity groupEntity = entityManager.find(GroupEntity.class, new Integer(groupId));
            groupEntity.setLastUpdate(lastUpdate);

            entityManager.persist(groupEntity);

            result = new ContactData(contactEntity);

            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            try
            {
                entityManager.getTransaction().rollback();
            }
            catch(Exception e)
            {
            }
        }
        finally
        {
            entityManager.close();
        }

        return result;
    }

    public static ContactData updateContact(int contactId, String name, String phone, String phone2, String email,
                                          String email2, String city, String weChat)
    {
        ContactData result = null;

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try
        {

            ContactEntity contactEntity = entityManager.find(ContactEntity.class, new Integer(contactId));
            if (contactEntity == null)
                return null;

            entityManager.getTransaction().begin();

            Timestamp lastUpdate = new Timestamp(System.currentTimeMillis());

            contactEntity.setName(name);
            contactEntity.setPhone(phone);
            contactEntity.setPhone2(phone2);
            contactEntity.setEmail(email);
            contactEntity.setEmail2(email2);
            contactEntity.setCity(city);
            contactEntity.setWechat(weChat);
            contactEntity.setLastUpdate(lastUpdate);

            entityManager.persist(contactEntity);


            Query query = entityManager.createQuery("Select gce from GroupContactEntity gce where gce.contactId=:arg1");
            query.setParameter("arg1", contactId);
            GroupContactEntity gce = (GroupContactEntity)query.getSingleResult();

            if (gce != null)
            {
                GroupEntity groupEntity = entityManager.find(GroupEntity.class, new Integer(gce.getGroupId()));
                groupEntity.setLastUpdate(lastUpdate);

                entityManager.persist(groupEntity);
            }

            result = new ContactData(contactEntity);

            entityManager.getTransaction().commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            try
            {
                entityManager.getTransaction().rollback();
            }
            catch(Exception e)
            {
            }
        }
        finally
        {
            entityManager.close();
        }

        return result;
    }

    public static ContactData findContact(int id) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
            ContactEntity contactEntity = entityManager.find(ContactEntity.class, new Integer(id));
            return new ContactData(contactEntity);
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

    public static ContactData findContact(String name) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("Select ce from ContactEntity ce where ce.name=:arg1");
            query.setParameter("arg1", name);
            ContactEntity contactEntity = (ContactEntity)query.getSingleResult();
            return new ContactData(contactEntity);
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

    public static boolean deleteContact(int contactId) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("Select gce from GroupContactEntity gce where gce.contactId=:arg1");
            query.setParameter("arg1", contactId);
            GroupContactEntity gce = (GroupContactEntity)query.getSingleResult();
            entityManager.remove(gce);

            ContactEntity contactEntity = entityManager.find(ContactEntity.class, new Integer(contactId));
            entityManager.remove(contactEntity);

            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        } finally {
            entityManager.close();
        }
        return false;
    }

    //when contact get updated, it should update the "last update field" in group.

    //group and contact

    public static List<ContactData> listContactForGroup(int groupId)
    {
        List<ContactData> result = new ArrayList();

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = managerFactory.createEntityManager();
        try
        {
            Query query = entityManager.createQuery("Select gce from GroupContactEntity gce where gce.groupId=:arg1");
            query.setParameter("arg1", groupId);
            List resultList = query.getResultList();
            for(int i = 0; i < resultList.size(); i++)
            {
                GroupContactEntity gce = (GroupContactEntity)resultList.get(i);
                int contactId = gce.getContactId();
                ContactData contactData = findContact(contactId);
                if(contactData != null)
                    result.add(contactData);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            try
            {
                entityManager.getTransaction().rollback();
            }
            catch(Exception e)
            {
            }
        }
        finally
        {
            entityManager.close();
        }

        return result;
    }



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
