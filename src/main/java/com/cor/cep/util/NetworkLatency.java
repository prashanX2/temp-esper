package com.cor.cep.util;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkLatency {

    public static boolean isServer = false;
    public static long latency = 400;

    public void clientLatency()
    {


        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();


        xrayExecutor.submit(new Runnable() {
            public void run() {





                    while (true) {

                        try {

                           InetAddress IPAddress = InetAddress.getByName("104.43.197.157");
                            //DatagramSocket clientSocket = new DatagramSocket();
                            Socket clientSocket = new Socket(IPAddress, 44444);
                            long c = System.nanoTime();
                            byte[] sendData = new byte[1024];
                            byte[] receiveData = new byte[1024];

                            String sentence = "ADD";
                            //System.out.println(sentence);
                            //sendData = sentence.getBytes();
                            Arrays.fill(sendData, (byte) 10);

                            //104.43.197.157

                            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                            //sentence = inFromUser.readLine();
                            outToServer.writeInt(sendData.length);
                            outToServer.write(sendData);
                            long d = System.nanoTime();


                            String modifiedSentence = inFromServer.readLine();
                            long f = System.nanoTime();
                            //System.out.println("FROM SERVER: " + modifiedSentence);

                            clientSocket.close();


                            // DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 44444);

                            //System.out.println(sendData.length);


                            //clientSocket.send(sendPacket);

                            //DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                            //clientSocket.receive(receivePacket);

                            //String modifiedSentence = new String(receivePacket.getData());

                                //latency=900;

                            latency = (f - d) / 1000000;

                           System.out.println("Latency to :" + IPAddress + ": " + latency);
                            LogData.latencyWrite(Long.toString(latency), System.nanoTime() - ResultReciever.systemStartTime);

                            Thread.sleep(1000);

                            //clientSocket.close();

                        }catch(Exception er){
                            //System.out.println(" in latency sock " +er.toString());
                        }
                    }





            }
        });
    }

}
