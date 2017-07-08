import ir.aut.model.ChatJSON;
import ir.aut.model.MessageJSON;

/**
 * Created by Milad on 7/8/2017.
 */
public class TestJSON {
    public static void main(String[] args) {
        ChatJSON x = new ChatJSON("jafar" , "milad" , "192.168.1.1" , "12");
        x.addMessage(new MessageJSON("boro gomsho" , "12:30" , "mine"));
        x.addMessage(new MessageJSON("wear" , "12:34" , "inver"));
        System.out.println(x.getForWrite());
    }
}
