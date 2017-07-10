package ir.aut.view.gameview;

import ir.aut.model.IOTool;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Milad on 7/9/2017.
 */
public class ConversationsHistory extends JFrame {
    private int lastYCor = 0;
    private static final int Y_SIZE = 30;
    private int xSize, ySize;

    public ConversationsHistory(int xCor, int yCor, int xSize, int ySize) {
        super("ConversationsHistory");
        this.xSize = xSize;
        this.ySize = ySize;
        setSize(xSize, ySize);
        setLocation(xCor, yCor);
        setPreferredSize(new Dimension(xSize, ySize));
        JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(xSize - 20, 0, xSize, ySize);
        add(jScrollPane);

        //
        JSONObject baseJSON = new JSONObject(IOTool.readJSON());
        JSONArray chatJSON = baseJSON.getJSONArray("chats");
        for (int i = 0; i < chatJSON.length(); i++) {
            JSONObject cur = chatJSON.getJSONObject(i);
            ChatHistory chatHistory = new ChatHistory(cur.getString("name"), 300, 300, 300, 600);
            JSONArray curMessages = cur.getJSONArray("messages");
            JSONObject x = new JSONObject();
            if (curMessages.length() == 0)
                continue;
            for (int j = 0; j < curMessages.length(); j++) {
                x = curMessages.getJSONObject(j);
                String ty = x.getString("type");
                int type = 1;
                if (ty.equals("mine"))
                    type = 0;
                chatHistory.addMessage(x.getString("text"), x.getString("time"), type);
            }
            this.addConversation(chatHistory, cur.getString("name"), x.getString("time"), x.getString("text"));
        }

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void addConversation(ChatHistory chatHistory, String name, String date, String lastMessage) {
        ConversationSchema conversationSchema = new ConversationSchema(chatHistory, name, date, lastMessage, xSize, Y_SIZE, lastYCor);
        add(conversationSchema);
        validate();
        lastYCor += Y_SIZE;
    }
}
