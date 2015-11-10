package com.cor.cep.util;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class FogToCloudGateway {


    public static boolean isCloud = false;
    public static DatagramSocket gatewayclientSocket;
    public static InetAddress gatewayserverIPAddress;


    public static DatagramSocket gatewayserverSocket;






    public static void initgatewayclient()
    {
        try
        {
            gatewayclientSocket= new DatagramSocket();
            gatewayserverIPAddress = InetAddress.getByName("104.43.197.157");

        }catch(Exception e){System.out.println(e.toString());}


    }


    public static void initgatewayserver()
    {
        try
        {
            gatewayserverSocket = new DatagramSocket(55555);
            System.out.println("gateway server started....");
            final byte[] gatewayreceiveData = new byte[1024];



            ExecutorService serverExecutor = Executors.newSingleThreadExecutor();

            serverExecutor.submit(new Runnable() {
                public void run() {

                    while (true) {


                        DatagramPacket receivePacket = new DatagramPacket(gatewayreceiveData, gatewayreceiveData.length);


                        try {
                            gatewayserverSocket.receive(receivePacket);
                            String sentence = new String(receivePacket.getData());
                            System.out.println("packet recieved "+sentence);

                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }


                        Arrays.fill(gatewayreceiveData, (byte) 0);

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            //LOG.error("Thread Interrupted", e);
                        }
                    }

                }
            });
















            //gatewayserverIPAddress = InetAddress.getByName("104.43.197.157");

        }catch(Exception e){System.out.println(e.toString());}


    }




    public static boolean schedule(int priority)
    {
        if(isCloud)
        {
            return false; // schedule locally
        }
        else
        {
            if(scheduletoCloud(priority))
            {
                return true;  // schedule in cloud
            }

            else
            {
                return false; // schedule locally
            }





        }


    }


    public static boolean scheduletoCloud(int priority)
    {

        if(priority>5)
        {
            return false;
        }


    return  true;

    }



















    public static void sendtoCloud(String toSend)
    {
        byte[] sendData = new byte[1024];

        sendData = toSend.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, gatewayserverIPAddress, 55555);

        try
        {
            gatewayclientSocket.send(sendPacket);
            System.out.println("sent to cloud: " + toSend);
        }catch(Exception e){System.out.println(e.toString());}



    }
    //104.43.197.157














}
