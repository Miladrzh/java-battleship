package ir.aut.model;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Milad on 7/8/2017.
 */
public class ChatJSON extends JSONObject {
    String fileName , name , ip , id;
    int messageCounter;
    JSONArray messages;
    public ChatJSON (String fileName , String name , String ip , String id){
        super();
        this.fileName = fileName;
        this.name = name;
        this.ip = ip;
        this.id = id;
        this.append("name" , name);
        this.append("ip" , ip);
        this.append("id" , id);
        messages = new JSONArray();
    }

    public String getFileName() {
        return fileName;
    }

    public void addMessage(MessageJSON x){
        messages.put(x);
    }

    public JSONObject getForWrite(){
        JSONObject ret = this;
        ret.put("messages" , messages);
        return ret;
    }

}
