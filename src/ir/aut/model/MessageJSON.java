package ir.aut.model;

import org.json.JSONObject;

/**
 * Created by Milad on 7/8/2017.
 */
public class MessageJSON extends JSONObject{
    String text , time , type;
    public MessageJSON(String text , String time , String type){
        super();
        this.text = text;
        this.time = time;
        this.type = type;
        this.put("text" , text);
        this.put("time" , time);
        this.put("type" , type);
    }

}
