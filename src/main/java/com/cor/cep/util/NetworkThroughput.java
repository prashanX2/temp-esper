package com.cor.cep.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkThroughput {


    public static int upload;

    public static int download;


        public String executeCommand(String command)
        {

            StringBuffer output = new StringBuffer();

            Process p;
            try {
                p = Runtime.getRuntime().exec(command);
                p.waitFor();
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(p.getInputStream()));

                String line = "";
                while ((line = reader.readLine())!= null) {
                    output.append(line + "\n");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return output.toString();

        }


    public void runThroughput()
    {

        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();


        xrayExecutor.submit(new Runnable() {
            public void run() {

                while (true) {

                    String output = executeCommand("ifstat 1 1");
                    String[] out = output.split(" ");

                    int[] downup = new int[2];
                    boolean down = false;






                        //System.out.println(Arrays.asList(out));

                        for(int i=0;i<out.length;i++)
                        {
                            try
                            {
                                if(down==false)
                                {
                                    downup[0] = (int)Float.parseFloat(out[i]);
                                    down=true;
                                }
                                else
                                {
                                    downup[1] = (int)Float.parseFloat(out[i]);
                                    break;
                                }

                            }catch(Exception hh){}
                        }
                        download =  downup[0];
                        upload = downup[1];
                        LogData.netthroughputWrite(Integer.toString(download), System.nanoTime() - ResultReciever.systemStartTime);

                        System.out.println("download throughput: "+download+" || upload throughput: "+upload);


                       // download = (int)Float.parseFloat(out[23]);
                        //upload = (int)Float.parseFloat(out[29]);

                        //System.out.println(out[23]); //22
                        //System.out.println(out[29]);//28

                        //System.out.println(download); //22
                        //System.out.println(upload);




                    try {
                        Thread.sleep(1000);
                    } catch (Exception tr) {
                        System.out.println(tr);
                    }
                }
            }
        });

    }


    }



