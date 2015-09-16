package com.cor.cep.util;

/**
 * Created by prashan on 9/16/15.
 */
import java.io.*;
import java.net.*;

/**
 * Created by prashan on 9/7/15.
 */
public class IPCServer {
    public static void main(String args[]) throws Exception
    {



        DatagramSocket serverSocket = new DatagramSocket(33333);

        System.out.println("Server started on: " + serverSocket.getLocalAddress()+ "@"+serverSocket.getLocalPort());

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true)
        {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            serverSocket.receive(receivePacket);



            String sentence = new String( receivePacket.getData());
            String decode[] = sentence.split(" ");

            if(decode[0].equals("H001"))
            {
                IPCServer_H001.decodeStream(decode);


            }


            System.out.println("RECEIVED: from " +receivePacket.getAddress()+" @ "+receivePacket.getPort()+ "   "+ sentence);
           /* InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);*/
        }
    }


}

