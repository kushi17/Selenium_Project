package utils;

import java.io.*;
import java.util.*;

public class propertyFileLoader {
    Properties prop=new Properties();

    public Reader loadPropertiesFile() throws IOException {
        FileReader reader = new FileReader("src/test/resources/config.properties");


        return reader;
    }

    public String getURL() throws IOException {
        String url;
        prop.load(loadPropertiesFile());
        url=prop.getProperty("URL");
        return url;
    }
}
