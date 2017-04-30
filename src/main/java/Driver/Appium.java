package Driver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Appium {

    Process proc;

    public void appiumStart() throws IOException {

        //String startAppium = "appium";
        proc =  Runtime.getRuntime().exec("appium");

        // Read the output
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
        }
    }

    public void appiumDown() throws IOException {
        proc.destroy();
    }
}
