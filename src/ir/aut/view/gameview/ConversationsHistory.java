package ir.aut.view.gameview;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Milad on 7/9/2017.
 */
public class ConversationsHistory extends JFrame {
    private static int lastYCor = 0;
    private static final int Y_SIZE = 30;
    private int xSize, ySize;

    public ConversationsHistory(int xCor, int yCor, int xSize, int ySize) {
        super("ConversationsHistory");
        this.xSize = xSize;
        this.ySize = ySize;
        setSize(xSize, ySize);
        setLocation(xCor, yCor);
        setPreferredSize(new Dimension(xSize, ySize));
        JScrollPane jScrollPane = new JScrollPane(this, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(xSize - 20, 0, xSize, ySize);
        add(jScrollPane);
        setLayout(null);
        setVisible(true);
    }

    public void addConversation(ChatHistory chatHistory, String name, String date, String lastMessage) {
        ConversationSchema conversationSchema = new ConversationSchema(chatHistory, name, date, lastMessage, xSize, Y_SIZE, lastYCor);
        add(conversationSchema);
        validate();
        lastYCor += Y_SIZE;
    }
}
