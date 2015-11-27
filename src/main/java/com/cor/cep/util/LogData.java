package com.cor.cep.util;


import java.io.PrintWriter;

public class LogData {

   public static double divide = 1000000000;

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
    public static PrintWriter CACCE;

    public static PrintWriter ROTA;
    public static PrintWriter CROTA;

    public static PrintWriter GRAV;
    public static PrintWriter CGRAV;

    public static PrintWriter ORIE;
    public static PrintWriter CORIE;

    public static PrintWriter LUMI;
    public static PrintWriter CLUMI;




    public static PrintWriter TEMP;
    public static PrintWriter CTEMP;

    public static PrintWriter HUMI;
    public static PrintWriter CHUMI;



    public static PrintWriter DIST;
    public static PrintWriter CDIST;




    public static PrintWriter ALUM;
    public static PrintWriter CALUM;

    public static PrintWriter WLUM;
    public static PrintWriter CWLUM;



    public static PrintWriter AHUM;
    public static PrintWriter CAHUM;

    public static PrintWriter WHUM;
    public static PrintWriter CWHUM;



    public static PrintWriter ATEM;
    public static PrintWriter CATEM;

    public static PrintWriter WTEM;
    public static PrintWriter CWTEM;



    public static PrintWriter ENTE;
    public static PrintWriter CENTE;





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
            CACCE = new PrintWriter("CACCE.txt", "UTF-8");

            ROTA = new PrintWriter("ROTA.txt", "UTF-8");
            CROTA = new PrintWriter("CROTA.txt", "UTF-8");

            GRAV = new PrintWriter("GRAV.txt", "UTF-8");
            CGRAV = new PrintWriter("CGRAV.txt", "UTF-8");

            ORIE = new PrintWriter("ORIE.txt", "UTF-8");
            CORIE = new PrintWriter("CORIE.txt", "UTF-8");

            LUMI = new PrintWriter("LUMI.txt", "UTF-8");
            CLUMI = new PrintWriter("CLUMI.txt", "UTF-8");




            TEMP = new PrintWriter("TEMP.txt", "UTF-8");
            CTEMP = new PrintWriter("CTEMP.txt", "UTF-8");

            HUMI = new PrintWriter("HUMI.txt", "UTF-8");
            CHUMI = new PrintWriter("CHUMI.txt", "UTF-8");



            DIST = new PrintWriter("DIST.txt", "UTF-8");
            CDIST = new PrintWriter("CDIST.txt", "UTF-8");





            ALUM = new PrintWriter("ALUM.txt", "UTF-8");
            CALUM = new PrintWriter("CALUM.txt", "UTF-8");

            WLUM = new PrintWriter("WLUM.txt", "UTF-8");
            CWLUM = new PrintWriter("CWLUM.txt", "UTF-8");



            AHUM = new PrintWriter("AHUM.txt", "UTF-8");
            CAHUM = new PrintWriter("CAHUM.txt", "UTF-8");

            WHUM = new PrintWriter("WHUM.txt", "UTF-8");
            CWHUM = new PrintWriter("CWHUM.txt", "UTF-8");



            ATEM = new PrintWriter("ATEM.txt", "UTF-8");
            CATEM = new PrintWriter("CATEM.txt", "UTF-8");

            WTEM = new PrintWriter("WTEM.txt", "UTF-8");
            CWTEM = new PrintWriter("CWTEM.txt", "UTF-8");



            ENTE = new PrintWriter("ENTE.txt", "UTF-8");
            CENTE = new PrintWriter("CENTE.txt", "UTF-8");












            System.out.println("Loggers started");


        }
        catch(Exception e){System.out.println(e.toString());}
    }

    public  static void writetoFile(String sentence, long receievetime)
    {
        try {



            Double rtime = receievetime/divide;

            writer.println(sentence+" "+rtime);
            //System.out.println("wrote to file");
            writer.flush();
        }
        catch(Exception e){System.out.println(e.toString());}
    }




    public static void latencyWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            latencywriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            latencywriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void platencyWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            platencywriter.println(sentence+" "+rtime);
            //System.out.println("wrote to file");
            platencywriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }


    public static void cputhroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            cputhroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            cputhroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void pcputhroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            pcputhroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            pcputhroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }


    public static void netthroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            netthroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            netthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void pnetthroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            pnetthroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            pnetthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }



    public static void eventthroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            eventthroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            eventthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void peventthroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            peventthroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            peventthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }










    public static void ACCEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            ACCE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            ACCE.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CACCEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CACCE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CACCE.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void ROTAWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            ROTA.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            ROTA.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CROTAWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CROTA.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CROTA.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void GRAVWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            GRAV.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            GRAV.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CGRAVWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CGRAV.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CGRAV.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void ORIEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            ORIE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            ORIE.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CORIEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CORIE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CORIE.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void LUMIWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LUMI.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LUMI.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CLUMIWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CLUMI.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CLUMI.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }




    public static void TEMPWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            TEMP.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            TEMP.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CTEMPWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CTEMP.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CTEMP.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void HUMIWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            HUMI.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            HUMI.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CHUMIWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CHUMI.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CHUMI.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void DISTWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            DIST.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            DIST.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CDISTWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CDIST.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CDIST.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }





    public static void ALUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            ALUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            ALUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CALUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CALUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CALUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void WLUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            WLUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            WLUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CWLUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CWLUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CWLUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void AHUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            AHUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            AHUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CAHUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CAHUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CAHUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void WHUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            WHUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            WHUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CWHUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CWHUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CWHUM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void ATEMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            ATEM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            ATEM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CATEMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CATEM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CATEM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void WTEMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            WTEM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            WTEM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CWTEMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CWTEM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CWTEM.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }


    public static void ENTEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            ENTE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            ENTE.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CENTEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CENTE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CENTE.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }




















}
