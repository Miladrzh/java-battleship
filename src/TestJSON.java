import ir.aut.model.ChatJSON;
import ir.aut.model.IOTool;
import ir.aut.model.MessageJSON;

/**
 * Created by Milad on 7/8/2017.
 */
public class TestJSON {
    public static void main(String[] args) {
        System.out.println(IOTool.readJSON());
        System.out.println();
        ChatJSON chatJSON = new ChatJSON();
        chatJSON.addMessage(new MessageJSON("salam " , "2012" , "2013"));
        IOTool.writeChatJSON(chatJSON.getForWrite("milad" , "ip" , "id"));
//        MasterGameFrame x = new MasterGameFrame(null , 50 ,50 ,1000 , 700 );
//        ChatJSON x = new ChatJSON("jafar" , "milad" , "192.168.1.1" , "12");
//        x.addMessage(new MessageJSON("boro gomsho" , "12:30" , "mine"));
//        x.addMessage(new MessageJSON("wear" , "12:34" , "inver"));
//        System.out.println(x.getForWrite());
    }
}
