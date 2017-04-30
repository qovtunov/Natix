package Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    FOR SOME CHECKS
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //AppiumServerOld.appiumStart();


        /*String[] argss = new String[] {"/bin/bash", "-c", "appium"};
        Process proc = new ProcessBuilder(argss).start();
        proc.waitFor();*/


        /*String[] runAppium = { "xterm", "-e", "appium"};

        Runtime.getRuntime().exec(runAppium);*/



        String startAppium = "appium";
        String killAppium = "killall node";


        Process proc =  Runtime.getRuntime().exec(startAppium);

        // Read the output

        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
        }



        /*Thread.sleep(10000);
        System.out.println("fsdffsdfsdfsdf");
        proc.destroy();*/




    }
}
