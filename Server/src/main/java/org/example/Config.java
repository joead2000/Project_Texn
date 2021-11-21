package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Config {
    public static Config getInstance;

    Map<String, String> values = new HashMap<>();

    public Config() throws IOException {
        getInstance = this;
        readConfigFile();
    }

    void readConfigFile() throws IOException {
        String file = System.getProperty("user.dir") + "/config.properties";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) continue;

                String[] parts = line.split("=", 2);
                if (parts.length != 2) continue;

                String key = parts[0].trim().toLowerCase(Locale.ROOT);
                String value = parts[1].trim();
                values.put(key, value);
            }
        }
        catch (IOException ex) {
            System.out.println("readConfigFile exception: " + ex.getMessage());
        }
    }

    public String get(String key) {
        if (key == null || key.length() == 0) return "";
        if (values.containsKey(key)) return values.get(key.toLowerCase(Locale.ROOT));
        else return "";
    }
    public int getInt(String key) {
        String value = get(key);
        if (value.length() == 0) return 0;
        else return Integer.parseInt(value);
    }
    public float getFloat(String key) {
        String value = get(key);
        if (value.length() == 0) return 0;
        else return Float.parseFloat(value);
    }
}
