package com.cor.cep.util;


import java.util.*;


public final class EventTree {


    public static Map<String, Integer> eventTreeR1 = new HashMap<String, Integer>();

    public static Map<String, Integer> eventTreeR2 = new HashMap<String, Integer>();

    public static Map<String, Integer> eventTreeR3 = new HashMap<String, Integer>();

    public static List<Map> eventTreeList = new ArrayList();

    public static List<Integer> maxPriorityEvent = new ArrayList();


    public static void eventtreeinit()
    {
        eventTreeR1.put("ALUM",2);
        eventTreeR1.put("ENTE", 3);


        eventTreeR2.put("ALUM",2);
        eventTreeR2.put("ATEM",4);


        //eventTreeR3.put("ALUM",2);
        eventTreeR3.put("ATUM",3);
        eventTreeR3.put("AHUM",6);


        eventTreeList.add(eventTreeR1);
        eventTreeList.add(eventTreeR2);
        eventTreeList.add(eventTreeR3);


        for (int i = 0; i < eventTreeList.size(); i++)
        {

            Map<String, Integer> temptree = eventTreeList.get(i);

            int max = Collections.max(temptree.values());
            maxPriorityEvent.add(max);




        }


    }



    public static int getTreeValue(String eventID)
    {
        int max = 0;

        for (int i = 0; i < eventTreeList.size() ; i++)
        {
            if(eventTreeList.get(i).get(eventID) != null)
            {
                if(max <= maxPriorityEvent.get(i))
                {
                    max = maxPriorityEvent.get(i);

                }
            }

        }

        return max;


    }









}
