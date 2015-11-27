package com.cor.cep.util;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CpuThroughput {

    public static float cpuLoad;

    public static int cpuCores = 0;



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


    public void runCpuThroughput()
    {

        ExecutorService xrayExecutor = Executors.newSingleThreadExecutor();


        xrayExecutor.submit(new Runnable() {
            public void run() {

                while (true) {

                    String output = executeCommand("uptime");


                    String[] out = output.split(", ");

                    String last = "";

                    for(int i=0; i <out.length;i++)
                    {
                        if(out[i].startsWith(" load average: "))
                        {
                            String[] cout = out[i].split(" load average: ");
                            last+= cout[1];
                        }
                    }

                  //  System.out.println(Arrays.asList(out));
                    //System.out.println(out.length);

                    cpuLoad = Float.parseFloat(last);
                    cpuLoad = (cpuLoad/cpuCores)*100;
                    LogData.cputhroughputWrite(Float.toString(cpuLoad),System.nanoTime() - ResultReciever.systemStartTime);
                    System.out.println("CPU USAGE LOAD AVERAGE 1 MINUTE "+cpuLoad);





                   // System.out.println(output);
                   // System.out.println(Arrays.asList(out));



                    // download = (int)Float.parseFloat(out[23]);
                    //upload = (int)Float.parseFloat(out[29]);

                    //System.out.println(out[23]); //22
                    //System.out.println(out[29]);//28

                    //System.out.println(download); //22
                    //System.out.println(upload);




                    try {
                        Thread.sleep(3000);
                    } catch (Exception tr) {
                        System.out.println(tr);
                    }
                }
            }
        });

    }



}
