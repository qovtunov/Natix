package WebTests;


import org.testng.annotations.Test;

import java.io.IOException;

public class _TestTest extends MainTestWeb {

    @Test
    public void testTest() throws IOException {
        setLogger();
        //System.out.println(System.getProperty("java.util.logging.config.file"));
        //LogManager.getLogManager().readConfiguration();
        logger.finer("info");

        //logger.finer("finer");
        //logger.warning("warning");


    }


}
