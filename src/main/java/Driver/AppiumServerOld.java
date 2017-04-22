package Driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;


public class AppiumServerOld {
    static String Appium_Node_Path="/usr/local/Cellar/node/6.2.0/bin/node";
    static String Appium_JS_Path="/Users/kovtunov/Tools/appium/bin/appium.js";
    static AppiumDriverLocalService service;
    static String service_url;

    public static void appiumStart() throws Exception{
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
                usingPort(4723).usingDriverExecutable(new File(Appium_Node_Path)).
                withAppiumJS(new File(Appium_JS_Path)));
        service.start();
        Thread.sleep(10000);
        //service_url = service.getUrl().toString();
    }

    public static void appiumStop() throws Exception{
        service.stop();

    }
}
