package com.cor.cep.util;


import com.cor.cep.event.*;
import com.cor.cep.handler.epService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ResultSender {


    public static ServerSocket serverSocket;
    public static Socket connectionSocket;
    public static BufferedReader inFromClient;
    public static DataOutputStream outToClient;
    public static String clientaddress;

    public static void start()
    {

        ExecutorService enginesender = Executors.newSingleThreadExecutor();

        enginesender.submit(new Runnable() {
            public void run() {

                try {


                    serverSocket = new ServerSocket(22222);
                    System.out.println("--------------------------------------------------Result Server started on main: " + serverSocket.getInetAddress() + "@" + serverSocket.getLocalPort());


                    while (true) {

                        connectionSocket = serverSocket.accept();


                        clientaddress = connectionSocket.getInetAddress().toString();

                        clientaddress = clientaddress.replace("/", "");


                        System.out.println("---------------------------------------------accepted client : " + clientaddress);


                        inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                        outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                        System.out.println(inFromClient.readLine());

                        break;

                    }


                } catch (Exception ex) {
                    System.out.println(ex.toString());

                }
            }
        });

    }



    public static void send(String toSend)
    {
        try
        {
            DataOutputStream xoutToClient = new DataOutputStream(connectionSocket.getOutputStream());
            //outToServer = new DataOutputStream(gatewayclientSocket.getOutputStream());
            //outToServer.writeBytes(toSend);
            xoutToClient.writeBytes(toSend + "\n");
            xoutToClient.flush();
            //xoutToClient.close();

            //Socket clientSocket = new Socket(clientaddress, 22221);

            //DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            //BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //String sentence = toSend;
            //outToServer.writeBytes(toSend);

            //modifiedSentence = inFromServer.readLine();
            System.out.println("----------------------------------------------Sent to local engine " + toSend);
            //clientSocket.close();
        }catch(Exception e){System.out.println(e.toString());}


    }




}
