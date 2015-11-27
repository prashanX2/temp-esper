package com.cor.cep.util;


import java.io.PrintWriter;

public class LogData {

    /**measurement variables and all simu event logger*/
    public static PrintWriter writer;

    public static PrintWriter latencywriter;
    public static PrintWriter platencywriter;

    public static PrintWriter cputhroughputwriter;
    public static PrintWriter pcputhroughputwriter;

    public static PrintWriter netthroughputwriter;
    public static PrintWriter pnetthroughputwriter;

    public static PrintWriter eventthroughputwriter;
    public static PrintWriter peventthroughputwriter;



    /**individual event logger*/
    public static PrintWriter ACCE;
    public static PrintWriter ROTA;
    public static PrintWriter GRAV;
    public static PrintWriter ORIE;
    public static PrintWriter LUMI;

    public static PrintWriter TEMP;
    public static PrintWriter HUMI;

    public static PrintWriter DIST;


    public static PrintWriter ALUM;
    public static PrintWriter WLUM;

    public static PrintWriter AHUM;
    public static PrintWriter WHUM;

    public static PrintWriter ATEM;
    public static PrintWriter WTEM;

    public static PrintWriter ENTE;





    public static void initlogger()
    {
        try
        {


            writer = new PrintWriter("datalog.txt", "UTF-8");

            latencywriter = new PrintWriter("latency.txt", "UTF-8");
            platencywriter = new PrintWriter("platency.txt", "UTF-8");

            cputhroughputwriter = new PrintWriter("cputhroughput.txt", "UTF-8");
            pcputhroughputwriter = new PrintWriter("pcputhroughput.txt", "UTF-8");

            netthroughputwriter = new PrintWriter("netthroughput.txt", "UTF-8");
            pnetthroughputwriter = new PrintWriter("pnetthroughput.txt", "UTF-8");

            eventthroughputwriter = new PrintWriter("eventthroughput.txt", "UTF-8");
            peventthroughputwriter = new PrintWriter("peventthroughput.txt", "UTF-8");



            ACCE = new PrintWriter("ACCE.txt", "UTF-8");
            ROTA = new PrintWriter("ROTA.txt", "UTF-8");
            GRAV = new PrintWriter("GRAV.txt", "UTF-8");
            ORIE = new PrintWriter("ORIE.txt", "UTF-8");
            LUMI = new PrintWriter("LUMI.txt", "UTF-8");

            TEMP = new PrintWriter("TEMP.txt", "UTF-8");
            HUMI = new PrintWriter("HUMI.txt", "UTF-8");

            DIST = new PrintWriter("DIST.txt", "UTF-8");



            ALUM = new PrintWriter("ALUM.txt", "UTF-8");
            WLUM = new PrintWriter("WLUM.txt", "UTF-8");

            AHUM = new PrintWriter("AHUM.txt", "UTF-8");
            WHUM = new PrintWriter("WHUM.txt", "UTF-8");

            ATEM = new PrintWriter("ATEM.txt", "UTF-8");
            WTEM = new PrintWriter("WTEM.txt", "UTF-8");

            ENTE = new PrintWriter("ENTE.txt", "UTF-8");












            System.out.println("Loggers started");


        }
        catch(Exception e){System.out.println(e.toString());}
    }

    public  static void writetoFile(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            writer.println(sentence+" "+receievetime);
            //System.out.println("wrote to file");
            writer.flush();
        }
        catch(Exception e){System.out.println(e.toString());}
    }




    public static void latencyWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            latencywriter.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            latencywriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void platencyWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            platencywriter.println(sentence+" "+receievetime);
            //System.out.println("wrote to file");
            platencywriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }


    public static void cputhroughputWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            cputhroughputwriter.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            cputhroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void pcputhroughputWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            pcputhroughputwriter.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            pcputhroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }


    public static void netthroughputWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            netthroughputwriter.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            netthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void pnetthroughputWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            pnetthroughputwriter.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            pnetthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }



    public static void eventthroughputWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            eventthroughputwriter.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            eventthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void peventthroughputWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            peventthroughputwriter.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            peventthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }










    public static void ACCEWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            ACCE.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            ACCE.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void ROTAWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            ROTA.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            ROTA.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void GRAVWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            GRAV.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            GRAV.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void ORIEWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            ORIE.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            ORIE.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void LUMIWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            LUMI.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            LUMI.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }




    public static void TEMPWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            TEMP.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            TEMP.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void HUMIWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            HUMI.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            HUMI.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void DISTWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            DIST.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            DIST.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }





    public static void ALUMWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            ALUM.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            ALUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void WLUMWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            WLUM.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            WLUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void AHUMWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            AHUM.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            AHUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void WHUMWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            WHUM.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            WHUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void ATEMWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            ATEM.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            ATEM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void WTEMWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            WTEM.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            WTEM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }


    public static void ENTEWrite(String sentence, long receievetime)
    {
        try {

            receievetime = receievetime/1000000;

            ENTE.println(sentence + " " + receievetime);
            //System.out.println("wrote to file");
            ENTE.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }




















}
