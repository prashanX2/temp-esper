package com.cor.cep.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkThroughput {




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
                    try {


                        String output = executeCommand("ifstat 1 1");
                        String[] out = output.split(" ");

                        //System.out.println(Arrays.asList(out));

                        System.out.println(out[23]);
                        System.out.println(out[29]);

                    } catch (Exception e) {

                        System.out.println(e);
                    }

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



