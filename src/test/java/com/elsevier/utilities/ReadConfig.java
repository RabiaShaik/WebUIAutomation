package com.elsevier.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    static Properties properties = new Properties();

    public ReadConfig() {
//        File src = new File("./Configuration/config.properties");
        File src = new File("src/test/java/com/elsevier/configs/config.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(src);
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("Exception is" + e.getMessage());
        }
    }

    public String getBaseURL() {
        String url = properties.getProperty("baseURL");
        return url;
    }

    public String getUsername() {
        String username = properties.getProperty("username");
        return username;
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        return password;
    }

    public static String getBrowser() {
        String browser = properties.getProperty("browser");
        return browser;
    }

}
