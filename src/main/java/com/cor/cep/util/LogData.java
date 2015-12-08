package com.cor.cep.util;


import java.io.PrintWriter;

public class LogData {

   public static double divide = 1000000000;

    /**measurement variables and all simu event logger*/
    public static PrintWriter writer;

    public static PrintWriter latencywriter;
    public static PrintWriter platencywriter;
    public static PrintWriter p3latencywriter;
    public static PrintWriter p4latencywriter;

    public static PrintWriter cputhroughputwriter;
    public static PrintWriter pcputhroughputwriter;
    public static PrintWriter p3cputhroughputwriter;
    public static PrintWriter p4cputhroughputwriter;

    public static PrintWriter netthroughputwriter;
    public static PrintWriter pnetthroughputwriter;
    public static PrintWriter p3netthroughputwriter;
    public static PrintWriter p4netthroughputwriter;

    public static PrintWriter eventthroughputwriter;
    public static PrintWriter peventthroughputwriter;
    public static PrintWriter p3eventthroughputwriter;
    public static PrintWriter p4eventthroughputwriter;


    public static PrintWriter primaryeventthroughputwriter;
    public static PrintWriter secondaryeventthroughputwriter;
    public static PrintWriter tiertarythroughputwriter;

    public static PrintWriter cloudeventwriter;
    public static PrintWriter localeventwriter;

    public static PrintWriter lprimaryeventwriter;
    public static PrintWriter lcriticaleventwriter;
    public static PrintWriter lnoncriticaleventwriter;
    public static PrintWriter lnormaleventwriter;

    public static PrintWriter cprimaryeventwriter;
    public static PrintWriter ccriticaleventwriter;
    public static PrintWriter cnoncriticaleventwriter;
    public static PrintWriter cnormaleventwriter;


    public static PrintWriter LACCE;
    public static PrintWriter CCACCE;

    public static PrintWriter LROTA;
    public static PrintWriter CCROTA;

    public static PrintWriter LGRAV;
    public static PrintWriter CCGRAV;

    public static PrintWriter LORIE;
    public static PrintWriter CCORIE;

    public static PrintWriter LLUMI;
    public static PrintWriter CCLUMI;




    public static PrintWriter LTEMP;
    public static PrintWriter CCTEMP;

    public static PrintWriter LHUMI;
    public static PrintWriter CCHUMI;



    public static PrintWriter LDIST;
    public static PrintWriter CCDIST;




    public static PrintWriter LALUM;
    public static PrintWriter CCALUM;

    public static PrintWriter LWLUM;
    public static PrintWriter CCWLUM;



    public static PrintWriter LAHUM;
    public static PrintWriter CCAHUM;

    public static PrintWriter LWHUM;
    public static PrintWriter CCWHUM;



    public static PrintWriter LATEM;
    public static PrintWriter CCATEM;

    public static PrintWriter LWTEM;
    public static PrintWriter CCWTEM;



    public static PrintWriter LENTE;
    public static PrintWriter CCENTE;









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
            p3latencywriter = new PrintWriter("p3latency.txt", "UTF-8");
            p4latencywriter = new PrintWriter("p4latency.txt", "UTF-8");

            cputhroughputwriter = new PrintWriter("cputhroughput.txt", "UTF-8");
            pcputhroughputwriter = new PrintWriter("pcputhroughput.txt", "UTF-8");
            p3cputhroughputwriter = new PrintWriter("p3cputhroughput.txt", "UTF-8");
            p4cputhroughputwriter = new PrintWriter("p4cputhroughput.txt", "UTF-8");

            netthroughputwriter = new PrintWriter("netthroughput.txt", "UTF-8");
            pnetthroughputwriter = new PrintWriter("pnetthroughput.txt", "UTF-8");
            p3netthroughputwriter = new PrintWriter("p3netthroughput.txt", "UTF-8");
            p4netthroughputwriter = new PrintWriter("p4netthroughput.txt", "UTF-8");

            eventthroughputwriter = new PrintWriter("eventthroughput.txt", "UTF-8");
            peventthroughputwriter = new PrintWriter("peventthroughput.txt", "UTF-8");
            p3eventthroughputwriter = new PrintWriter("p3eventthroughput.txt", "UTF-8");
            p4eventthroughputwriter = new PrintWriter("p4eventthroughput.txt", "UTF-8");

            primaryeventthroughputwriter = new PrintWriter("primaryeventthroughput.txt", "UTF-8");
            secondaryeventthroughputwriter = new PrintWriter("secondaryeventthroughput.txt", "UTF-8");
            tiertarythroughputwriter = new PrintWriter("tiertaryeventthroughput.txt", "UTF-8");

            cloudeventwriter = new PrintWriter("cloudeventwriter.txt", "UTF-8");
            localeventwriter = new PrintWriter("localeventwriter.txt", "UTF-8");



            lprimaryeventwriter = new PrintWriter("lprimaryeventwriter.txt", "UTF-8");
            lcriticaleventwriter = new PrintWriter("lcriticaleventwriter.txt", "UTF-8");
            lnoncriticaleventwriter = new PrintWriter("lnoncriticaleventwriter.txt", "UTF-8");
            lnormaleventwriter = new PrintWriter("lnormaleventwriter.txt", "UTF-8");

            cprimaryeventwriter = new PrintWriter("cprimaryeventwriter.txt", "UTF-8");
            ccriticaleventwriter = new PrintWriter("ccriticaleventwriter.txt", "UTF-8");
            cnoncriticaleventwriter = new PrintWriter("cnoncriticaleventwriter.txt", "UTF-8");
            cnormaleventwriter = new PrintWriter("cnormaleventwriter.txt", "UTF-8");





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


            /**local vs cloud*/


            LACCE = new PrintWriter("LACCE.txt", "UTF-8");
            CCACCE = new PrintWriter("CCACCE.txt", "UTF-8");

            LROTA = new PrintWriter("LROTA.txt", "UTF-8");
            CCROTA = new PrintWriter("CCROTA.txt", "UTF-8");

            LGRAV = new PrintWriter("LGRAV.txt", "UTF-8");
            CCGRAV = new PrintWriter("CCGRAV.txt", "UTF-8");

            LORIE = new PrintWriter("LORIE.txt", "UTF-8");
            CCORIE = new PrintWriter("CCORIE.txt", "UTF-8");

            LLUMI = new PrintWriter("LLUMI.txt", "UTF-8");
            CCLUMI = new PrintWriter("CCLUMI.txt", "UTF-8");




            LTEMP = new PrintWriter("LTEMP.txt", "UTF-8");
            CCTEMP = new PrintWriter("CCTEMP.txt", "UTF-8");

            LHUMI = new PrintWriter("LHUMI.txt", "UTF-8");
            CCHUMI = new PrintWriter("CCHUMI.txt", "UTF-8");



            LDIST = new PrintWriter("LDIST.txt", "UTF-8");
            CCDIST = new PrintWriter("CCDIST.txt", "UTF-8");





            LALUM = new PrintWriter("LALUM.txt", "UTF-8");
            CCALUM = new PrintWriter("CCALUM.txt", "UTF-8");

            LWLUM = new PrintWriter("LWLUM.txt", "UTF-8");
            CCWLUM = new PrintWriter("CCWLUM.txt", "UTF-8");



            LAHUM = new PrintWriter("LAHUM.txt", "UTF-8");
            CCAHUM = new PrintWriter("CCAHUM.txt", "UTF-8");

            LWHUM = new PrintWriter("LWHUM.txt", "UTF-8");
            CCWHUM = new PrintWriter("CCWHUM.txt", "UTF-8");



            LATEM = new PrintWriter("LATEM.txt", "UTF-8");
            CCATEM = new PrintWriter("CATEM.txt", "UTF-8");

            LWTEM = new PrintWriter("LWTEM.txt", "UTF-8");
            CCWTEM = new PrintWriter("CCWTEM.txt", "UTF-8");



            LENTE = new PrintWriter("LENTE.txt", "UTF-8");
            CCENTE = new PrintWriter("CCENTE.txt", "UTF-8");







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
    public static void p3latencyWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            p3latencywriter.println(sentence+" "+rtime);
            //System.out.println("wrote to file");
            p3latencywriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void p4latencyWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            p4latencywriter.println(sentence+" "+rtime);
            //System.out.println("wrote to file");
            p4latencywriter.flush();
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
    public static void p3cputhroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            p3cputhroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            p3cputhroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void p4cputhroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            p4cputhroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            p4cputhroughputwriter.flush();
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
    public static void p3netthroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            p3netthroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            p3netthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void p4netthroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            p4netthroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            p4netthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }



    public static void primaryeventthroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            primaryeventthroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            primaryeventthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }


    public static void secondaryeventthroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            secondaryeventthroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            secondaryeventthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void tiertaryeventthroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            tiertarythroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            tiertarythroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void cloudeventWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            cloudeventwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            cloudeventwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void localeventWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            localeventwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            localeventwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void lprimaryeventWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            lprimaryeventwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            lprimaryeventwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void cprimaryeventWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            cprimaryeventwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            cprimaryeventwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }

    public static void lcriticaleventWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            lcriticaleventwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            lcriticaleventwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void ccriticaleventWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            ccriticaleventwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            ccriticaleventwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void lnoncriticaleventWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            lnoncriticaleventwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            lnoncriticaleventwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void cnoncriticaleventWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            cnoncriticaleventwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            cnoncriticaleventwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void lnormaleventWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            lnormaleventwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            lnormaleventwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void cnormaleventWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            cnormaleventwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            cnormaleventwriter.flush();
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
    public static void p3eventthroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            p3eventthroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            p3eventthroughputwriter.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void p4eventthroughputWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            p4eventthroughputwriter.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            p4eventthroughputwriter.flush();
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
    public static void LACCEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LACCE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LACCE.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }
    public static void CCACCEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCACCE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCACCE.flush();
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

    public static void LROTAWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LROTA.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LROTA.flush();
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
    public static void CCROTAWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCROTA.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCROTA.flush();
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
    public static void LGRAVWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LGRAV.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LGRAV.flush();
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
    public static void CCGRAVWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCGRAV.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCGRAV.flush();
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
    public static void LORIEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LORIE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LORIE.flush();
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
    public static void CCORIEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCORIE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCORIE.flush();
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
    public static void LLUMIWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LLUMI.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LLUMI.flush();
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
    public static void CCLUMIWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCLUMI.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCLUMI.flush();
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
    public static void LTEMPWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LTEMP.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LTEMP.flush();
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
    public static void CCTEMPWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCTEMP.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCTEMP.flush();
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
    public static void LHUMIWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LHUMI.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LHUMI.flush();
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
    public static void CCHUMIWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCHUMI.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCHUMI.flush();
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
    public static void LDISTWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LDIST.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LDIST.flush();
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
    public static void CCDISTWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCDIST.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCDIST.flush();
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
    public static void LALUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LALUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LALUM.flush();
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
    public static void CCALUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCALUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCALUM.flush();
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
    public static void LWLUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LWLUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LWLUM.flush();
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
    public static void CCWLUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCWLUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCWLUM.flush();
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
    public static void LAHUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LAHUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LAHUM.flush();
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
    public static void CCAHUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCAHUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCAHUM.flush();
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
    public static void LWHUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LWHUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LWHUM.flush();
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
    public static void CCWHUMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCWHUM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCWHUM.flush();
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
    public static void LATEMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LATEM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LATEM.flush();
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
    public static void CCATEMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCATEM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCATEM.flush();
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
    public static void LWTEMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LWTEM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LWTEM.flush();
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
    public static void CCWTEMWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCWTEM.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCWTEM.flush();
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
    public static void LENTEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            LENTE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            LENTE.flush();
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
    public static void CCENTEWrite(String sentence, long receievetime)
    {
        try {

            Double rtime = receievetime/divide;

            CCENTE.println(sentence + " " + rtime);
            //System.out.println("wrote to file");
            CCENTE.flush();
        }
        catch(Exception e){System.out.println(e.toString());}

    }



















}
