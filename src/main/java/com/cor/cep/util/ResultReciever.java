package com.cor.cep.util;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ResultReciever {

    public static long systemStartTime = 0;

    public static void start()
    {

        ExecutorService localenginereceiverExecutor = Executors.newSingleThreadExecutor();

        localenginereceiverExecutor.submit(new Runnable() {
            public void run()
            {

                try {
                    //104.43.197.157
                    InetAddress IPAddress = InetAddress.getByName("104.43.197.157");

                    Socket clientSocket = new Socket(IPAddress, 22222);


                    String sentence = "__________________________hello from local engine";


                    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

                    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    outToServer.writeBytes(sentence + "\n");
                    System.out.println("___________________________poke sent to server");


                    String line;

                    while((line = inFromServer.readLine() ) != null)
                    {
                        String modifiedSentence = line;

                        System.out.println(modifiedSentence);

                        String decode[] = modifiedSentence.split(" ");

                        toLog(decode);

                    }


                } catch (Exception er) {
                    System.out.println(er.toString());
                }

            }
        });

    }



    public static void toLog(String decode[])
    {
        /**sensor hub 1 events (H001)*/

        if(decode[0].equals("ACCE"))
        {


            LogData.CACCEWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);



        }


        if(decode[0].equals("GRAV"))
        {


            LogData.CGRAVWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }

        if(decode[0].equals("ROTA"))
        {


            LogData.CROTAWrite(decode[2],System.nanoTime() - ResultReciever.systemStartTime);

        }

        if(decode[0].equals("ORIE"))
        {


            LogData.CORIEWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }

        if(decode[0].equals("LUMI"))
        {


            LogData.CLUMIWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }



        /**stand alone sensors 1 (STH1)*/

        if(decode[0].equals("HUMI"))
        {


            LogData.CHUMIWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }

        if(decode[0].equals("TEMP"))
        {


            LogData.CTEMPWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }


        /**stand alone sensors 2 (SD01)*/

        if(decode[0].equals("DIST"))
        {


            LogData.CDISTWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }


        /**secondary events*/

        if(decode[0].equals("ENTE"))
        {


            LogData.CENTEWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }

        // humidity secondary events
        if(decode[0].equals("AHUM"))
        {


            LogData.CAHUMWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }

        if(decode[0].equals("WHUM"))
        {


            LogData.CWHUMWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }

        // luminous secondary events
        if(decode[0].equals("ALUM"))
        {


            LogData.CALUMWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }

        if(decode[0].equals("WLUM"))
        {


            LogData.CWLUMWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }

        // temperature secondary events
        if(decode[0].equals("ATEM"))
        {


            LogData.CATEMWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }

        if(decode[0].equals("WTEM"))
        {


            LogData.CWTEMWrite(decode[2], System.nanoTime() - ResultReciever.systemStartTime);

        }







    }




}
