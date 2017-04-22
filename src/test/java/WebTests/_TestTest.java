package WebTests;


import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.LogManager;

public class _TestTest extends MainTestWeb {

    @Test
    public void testTest() throws IOException {
        System.out.println(System.getProperty("java.util.logging.config.file"));
        LogManager.getLogManager().readConfiguration();
        logger.info("info");
        logger.finer("finer");
        logger.warning("warning");
    }


}
