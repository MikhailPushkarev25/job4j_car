package ru.job4j.servlet;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static Properties properties = new Properties();

    public static void path() throws Exception {
        try (InputStream io = Config.class.getClassLoader()
        .getResourceAsStream("photo.properties")) {
            properties.load(io);
        }
    }

    public static String result(String res) throws Exception {
        path();
        return properties.getProperty(res);
    }
}
