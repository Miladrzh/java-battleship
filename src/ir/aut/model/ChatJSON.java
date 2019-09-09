package ir.aut.model;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Milad on 7/8/2017.
 */
public class ChatJSON extends JSONObject {
    String name , ip , id;
    int messageCounter;
    JSONArray messages;

    public ChatJSON (){
        super();
        ip = "";
        name = "";
        id = "";
        messages = new JSONArray();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMessage(MessageJSON x){
        messages.put(x);
    }

    public JSONObject getForWrite(String name , String ip , String id){
        JSONObject ret = this;
        ret.put("id" , id);
        ret.put("ip", ip);
        ret.put("name" , name);
        ret.put("messages" , messages);
        return ret;
    }

}
