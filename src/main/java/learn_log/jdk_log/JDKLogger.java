package learn_log.jdk_log;

import java.util.logging.Logger;

public class JDKLogger {


    public static void main(String[] args) {

        Logger logger=Logger.getLogger("jdk_log");
        logger.info("test_log");

    }

}
