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


        eventTreeR2.put("ATEM",2);
        eventTreeR2.put("ENTE",3);




        eventTreeR3.put("ENTE",3);
        eventTreeR3.put("WTEM",5);

        eventTreeList.add(eventTreeR1);
        eventTreeList.add(eventTreeR2);
        eventTreeList.add(eventTreeR3);


        for (int i = 0; i < eventTreeList.size(); i++)
        {

            Map<String, Integer> temptree = eventTreeList.get(i);

            int max = Collections.max(temptree.values());
            maxPriorityEvent.add(max);

            System.out.println("evetn tree root priority "+max);


        }

        System.out.println("Event tree initialized");


    }



    public static int getTreeValue(int priority, String eventID)
    {
        int max = priority;



        for (int i = 0; i < eventTreeList.size() ; i++)
        {
            if(eventTreeList.get(i).get(eventID) != null)
            {

                if(eventID.equals("ALUM")) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + i);
            }
                if(max <= maxPriorityEvent.get(i))
                {
                    max = maxPriorityEvent.get(i);

                }
            }

        }

        return max;


    }









}
