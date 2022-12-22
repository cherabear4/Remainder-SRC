package me.geesy.remainder.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Configuration {
	
	private File file;
    public Map<String, Object> options;

    public Configuration(File file, Map<String, Object> options) {
        this.file = file;
        this.options = options;
    }

    public Configuration(File file) {
        this.file = file;
        this.options = new HashMap<String, Object>();
    }

    public Object get(String pos) {
        return options.get(pos);
    }

    public void set(String key, Object value) {
        options.put(key, value);
    }

    public void save() throws IOException {
        JSONObject jsonObject = new JSONObject(options);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(jsonObject.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}
