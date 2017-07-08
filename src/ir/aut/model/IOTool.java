package ir.aut.model;

import org.json.JSONObject;

import java.io.*;

/**
 * Created by Milad on 7/8/2017.
 */
public class IOTool {

    private static final String path = "./history";

    public boolean writeJSON(String ip , JSONObject x){
        FileWriter writer;
        try {
            writer = new FileWriter(path + ip + ".json");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        try {
            writer.write(x.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
