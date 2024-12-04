package ru.alex.service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpLogger {
    private final HttpLoggerConfig loggerConfig;
    private final Logger logger;

    public HttpLogger(HttpLoggerConfig loggerConfig) {
        this.loggerConfig = loggerConfig;
        logger = Logger.getLogger(this.getClass().getName());

        if (loggerConfig.isEnabled()) {
            setLogLevel();
        } else {
            logger.setLevel(Level.OFF);
        }
    }

    public void error(String format, Object... args) {
        logger.log(Level.SEVERE, format, args);
    }

    public void warning(String format, Object... args) {
        logger.log(Level.WARNING, format, args);
    }

    public void info(String format, Object... args) {
        logger.log(Level.INFO, format, args);
    }

    public void config(String format, Object... args) {
        logger.log(Level.CONFIG, format, args);
    }

    public void debug(String format, Object... args) {
        logger.log(Level.FINE, format, args);
    }

    public void trace(String format, Object... args) {
        logger.log(Level.FINER, format, args);
    }

    public void finest(String format, Object... args) {
        logger.log(Level.FINEST, format, args);
    }

    private void setLogLevel() {
        switch (loggerConfig.getLevel()) {
            case "SEVERE":
                logger.setLevel(Level.SEVERE);
                break;
            case "WARNING":
                logger.setLevel(Level.WARNING);
                break;
            case "INFO":
                logger.setLevel(Level.INFO);
                break;
            case "CONFIG":
                logger.setLevel(Level.CONFIG);
                break;
            case "FINE":
                logger.setLevel(Level.FINE);
                break;
            case "FINER":
                logger.setLevel(Level.FINER);
                break;
            case "FINEST":
                logger.setLevel(Level.FINEST);
                break;
            case "OFF":
                logger.setLevel(Level.OFF);
                break;
            default:
                logger.setLevel(Level.OFF);
        }
    }
}


