package com.logdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.HashMap;

@SpringBootApplication
public class Application {
    private static Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        convertToKeyValuePair(args);
        SpringApplication.run(Application.class, args);
        log.info("Application is Started {}", "log testing");
        log.debug("Debug log message");
        log.info("Info log message");
        log.warn("Warning log message");
        log.error("Error log message");
        log.fatal("Fatal log message");
    }

    private static void convertToKeyValuePair(String[] args) {
        String currentDirectory = System.getProperty("user.dir").concat("/logs");
        HashMap<String, String> params = new HashMap<>();
        for (String arg : args) {
            String[] splitFromEqual = arg.split("=");
            String key = splitFromEqual[0];
            String value = splitFromEqual[1];
            params.put(key, value);
        }
        if (params.containsKey("logPath"))
            currentDirectory = params.get("logPath");
        else {
            File directory = new File(String.valueOf(currentDirectory));
            if (!directory.exists()) {
                directory.mkdir();
            }
            currentDirectory = currentDirectory.concat("/system.log");
        }
        log.info("Application Log location  {}", currentDirectory);
        System.setProperty("log.file.path", currentDirectory);

    }
}
