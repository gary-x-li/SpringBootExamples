package demo.springboot.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogWriter {
    private final Logger log = LoggerFactory.getLogger(getClass());

    public void write() {
        log.trace("Trace level log");
        log.debug("Debug level log");
        log.info("Info level log");
        log.warn("Warn level log");
        log.error("Error level log");
    }
}
