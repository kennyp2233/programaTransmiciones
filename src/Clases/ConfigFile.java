/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author kenny
 */
public class ConfigFile {

    String configPath = "../src/config.properties";
    Properties properties = new Properties();

    public void save(String title, String value) throws IOException {
        properties.setProperty(title, value);
        properties.store(new FileOutputStream(configPath), null);
    }

    public String get(String title) throws IOException {
        properties.load(new FileInputStream(configPath));
        return properties.getProperty(title);

    }
}
