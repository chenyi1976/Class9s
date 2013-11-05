package me.chenyi.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.chenyi.model.ContactData;
import me.chenyi.model.GroupData;

/**
 * Cache all group/contact/avator data
 *
 * @author $Author:$
 * @version $Revision:$
 */
public class DataCacheUtil
{
    //will come back once ModelUtil is working.

    //todo: need to put limitation to cache to reduce memory cost.
    private Map<Integer, GroupData> groupDataMap = new HashMap();
    private Map<Integer, ContactData> contactDataMap = new HashMap();

    private Map<Integer, List<Integer>> groupContactMap = new HashMap();

    private static DataCacheUtil instance = null;

    public static DataCacheUtil getInstance()
    {
        if (instance == null)
            instance = new DataCacheUtil();
        return instance;
    }

    public GroupData getGroupData(int groupId)
    {
        GroupData groupData = groupDataMap.get(groupId);
        if (groupData != null)
            return groupData;

        groupData = ModelUtil.findGroup(groupId);
        if (groupData != null)
            groupDataMap.put(groupId, groupData);

        return groupData;
    }
}
