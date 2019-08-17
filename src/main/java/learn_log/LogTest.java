package learn_log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

    private static Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {

        logger.info("hello {}", "info");
        logger.error("hello {}", "error");
        logger.trace("hello {}", "trace");
        logger.debug("hello {}", "debug");
        logger.warn("hello {}", "warn");


    }

}
