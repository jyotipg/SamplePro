package com.lti.jasper.generator;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

/**
 * Hello world!
 */
public class ReportGeneratorFactory {

    private static final String CONFIG_FILE = "config";
    private static Properties properties;

    public static void main(String[] args) throws IOException, URISyntaxException {
     setActiveProperties(args);
        System.out.println("-------------------------------------------------------------\n\n");
        System.out.println(properties.toString());
        System.out.println("-------------------------------------------------------------\n\n");
    }


    private static void setActiveProperties(String[] args) {
        HashMap<String, String> params = convertToKeyValuePair(args);
        if (params.containsKey(CONFIG_FILE)) {
            confgProperties(params.get(CONFIG_FILE));

        }

    }

    private static HashMap<String, String> convertToKeyValuePair(String[] args) {

        HashMap<String, String> params = new HashMap<>();
        try {
            for (String arg : args) {

                String[] maps = arg.split(" ");
                for (String map : maps) {
                    String[] splitFromEqual = map.split("=");
                    String key = splitFromEqual[0];
                    String value = splitFromEqual[1];
                    params.put(key, value);
                }

            }
        }
        catch (Exception c){

        }

        return params;
    }

    public static void confgProperties(String configFilePath) {
        System.out.println("loading properties " + configFilePath);
        properties = new Properties();
        try {
            properties.load(new FileInputStream(configFilePath));

        } catch (IOException e) {

            System.err.println("Error properties " + configFilePath);
            e.printStackTrace();

        }

    }

}
