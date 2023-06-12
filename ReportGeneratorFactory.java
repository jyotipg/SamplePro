package com.lti.jasper.generator;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.qoppa.pdfText.PDFText;
/**
 * Hello world!
 */
public class ReportGeneratorFactory {

    private static final String BAL_KEY = "balKey";
    private static final String REPORT_PROP = "ReportProperties";
    private static final String JASPER_PATH = "JasperReportPath";

    private static String BAL_KEY_VALUE = "balance_sheet_detailed";
    private static String REPORT_PROP_VALUE = "BeanCollectionReportGeneratorClasses.properties";
    private static String JASPER_PATH_VALUE = "e:\\itc\\app\\eod\\moz\fcc\\ca\\BOReportrefresh\\common\\JasperReport";

    public static void main(String[] args) throws IOException, URISyntaxException {
        setPropertyHeaders(args);
        System.out.println("BAL_KEY_VALUE : " + BAL_KEY_VALUE);
        System.out.println("REPORT_PROP_VALUE : " + REPORT_PROP_VALUE);
        System.out.println("JASPER_PATH_VALUE : " + JASPER_PATH_VALUE);
       printFileContent("config.txt");
    }


    private static void setPropertyHeaders(String[] args) {
        HashMap<String, String> params = convertToKeyValuePair(args);
        if (params.containsKey(BAL_KEY)) {
            if ((params.get(BAL_KEY) != null) && params.get(BAL_KEY).length() != 0) {
                System.out.println("REPORT_PROP : " + params.get(BAL_KEY));
                BAL_KEY_VALUE = params.get(BAL_KEY);
            }
        }
        if (params.containsKey(JASPER_PATH)) {
            if ((params.get(JASPER_PATH) != null) && params.get(JASPER_PATH).length() != 0) {
                System.out.println("REPORT_PROP : " + params.get(JASPER_PATH));
                JASPER_PATH_VALUE = params.get(JASPER_PATH);
            }
        }

        if (params.containsKey(REPORT_PROP)) {
            if ((params.get(REPORT_PROP) != null) && params.get(REPORT_PROP).length() != 0) {

                System.out.println("REPORT_PROP : " + params.get(REPORT_PROP));
                REPORT_PROP_VALUE = params.get(REPORT_PROP);
            }
        }
    }

    private static HashMap<String, String> convertToKeyValuePair(String[] args) {

        HashMap<String, String> params = new HashMap<>();

        for (String arg : args) {

            String[] maps = arg.split(" ");
            for (String map : maps) {
                String[] splitFromEqual = map.split("=");
                String key = splitFromEqual[0];
                String value = splitFromEqual[1];
                params.put(key, value);
            }

        }

        return params;
    }

    private static void printFileContent(String fileName) throws IOException, URISyntaxException {
        String jarPath = ReportGeneratorFactory.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toURI()
                .getPath();
        File file = new File(jarPath.replace("BBMJasperBOFCCBatch.jar" ,"classes/"+fileName));
        String content = new String(Files.readAllBytes(file.toPath()));
        System.out.println(content);
    }


}
