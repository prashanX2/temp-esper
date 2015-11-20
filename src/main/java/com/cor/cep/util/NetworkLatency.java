package com.cor.cep.util;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkLatency {

    public static boolean isServer = false;
    public static long latency;

    public void clientLatency()
    {


        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();


        xrayExecutor.submit(new Runnable() {
            public void run() {


                try {


                    while (true) {

                        DatagramSocket clientSocket = new DatagramSocket();

                        long c = System.nanoTime();


                        //104.43.197.157
                        InetAddress IPAddress = InetAddress.getByName("104.43.197.157");


                        byte[] sendData = new byte[1024];
                        byte[] receiveData = new byte[1024];

                        String sentence = "ADD";
                        //System.out.println(sentence);
                        //sendData = sentence.getBytes();
                        Arrays.fill(sendData, (byte) 10);


                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 44444);

                        //System.out.println(sendData.length);

                        long d = System.nanoTime();
                        clientSocket.send(sendPacket);

                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        clientSocket.receive(receivePacket);

                        String modifiedSentence = new String(receivePacket.getData());
                        long f = System.nanoTime();

                        latency = (f - d) / 1000000;

                        System.out.println("Latency to :" + IPAddress + ": " + latency);
                        Thread.sleep(2000);

                        //clientSocket.close();


                    }


                } catch (Exception e) {

                    System.out.println(e.toString());
                }


            }
        });
    }

}
