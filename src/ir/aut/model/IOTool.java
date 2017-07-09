package ir.aut.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Milad on 7/8/2017.
 */
public class IOTool {
    public static final String PATH = System.getProperty("user.dir") + "/src/ir/aut/model/history.json";
    public static String readJSON(){
        BufferedReader reader = null;
        String ret = "";
        System.out.println("huuuuuy");
        try {
            reader = new BufferedReader(new FileReader(PATH));
            System.out.println(PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ret = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e2){
            e2.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static void writeChatJSON(JSONObject chatJSON){
        JSONObject old = new JSONObject(readJSON());
        JSONArray oldArray = old.getJSONArray("chats");
        oldArray.put(chatJSON);
        System.out.println(old);
        try {
            FileWriter writer = new FileWriter(PATH , false);
            writer.write(old.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ;
    }
}
