package ir.aut.view.gameview;

import ir.aut.game.GameFrameCallBack;
import ir.aut.logic.messages.ChatMessage;
import ir.aut.model.ChatJSON;
import ir.aut.model.IOTool;
import ir.aut.model.MessageJSON;
import ir.aut.view.ChatPanel;
import ir.aut.view.MessagePanel;
import ir.aut.view.gameview.sea.EnemySeaPanel;
import ir.aut.view.gameview.sea.MasterSeaPanel;
import ir.aut.view.gameview.sea.MySeaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Milad on 6/14/2017.
 */
public class GameFrame extends JFrame implements ChatPanelCallBack, MenuBarCallBack {
    public MasterSeaPanel enemyMasterSea;
    public EnemySeaPanel enemySea;
    public MasterSeaPanel myMasterSea;
    public MySeaPanel mySea;
    public MenuBar menuBar;
    public InGameBottomPanel inGameBottomPanel;
    public BeforeGameBottomPanel beforeGameBottomPanel;
    public GameFrameCallBack gameFrameCallBack;
    public JLabel chatToLbl;
    public ChatPanel chatPanel;
    private JTextField typeTextField;
    public ChatJSON chatJSON;
    public static JLabel turn;

    public GameFrame(GameFrameCallBack gameFrameCallBack, int xCor, int yCor, int xSize, int ySize) {
        super("Battle Ship :)");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        chatJSON = new ChatJSON();
        this.gameFrameCallBack = gameFrameCallBack;
        myMasterSea = new MasterSeaPanel(92, 65, 438, 438, false);
        enemyMasterSea = new MasterSeaPanel(92, 65, 438, 438, true);
        mySea = (MySeaPanel) myMasterSea.seaPanel;
        enemySea = (EnemySeaPanel) enemyMasterSea.seaPanel;
        enemySea.setVisible(false);

        turn = new JLabel("Your Turn");
        turn.setSize(100 , 30);
        turn.setLocation(10 , 30);
        turn.setFont(new Font("Arial" , 0 , 14));
        this.add(turn);

        menuBar = new MenuBar(this, 0, 0, 666, 30);
        inGameBottomPanel = new InGameBottomPanel(gameFrameCallBack.getEnemyName(), 0, 550, 666, 150);
        inGameBottomPanel.setGameFrameCallBack(gameFrameCallBack);
        beforeGameBottomPanel = new BeforeGameBottomPanel(0, 550, 666, 150);

        inGameBottomPanel.setVisible(false);
        beforeGameBottomPanel.setVisible(true);

        chatToLbl = new JLabel("  Chat to: " + gameFrameCallBack.getEnemyName());
        chatToLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chatToLbl.setBounds(667, 0, 332, 660 / 12);
        add(chatToLbl);

        typeTextField = new JTextField("Type here ...", 50);
        typeTextField.setBounds(667, 660 * 5 / 6 + 30, 332, 660 / 12);
        typeTextField.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() != "") {
                    typeTextField.setText("");
                    chatPanel.addMessage(e.getActionCommand(), new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date()), MessagePanel.ME);
                    gameFrameCallBack.sendMessage(new ChatMessage(gameFrameCallBack.getMyName(), e.getActionCommand()));
                    chatPanel.validate();
                }
            }
        });

        typeTextField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                typeTextField.setText("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(typeTextField);

        chatPanel = new ChatPanel(this, 1, 1, gameFrameCallBack.getEnemyName());
        chatPanel.setBounds(667, 660 / 12, 332, 660 * 3 / 4);
        add(chatPanel);

        this.setLayout(null);
        this.setLocation(xCor, yCor);
        this.setSize(xSize, ySize);

        this.add(enemySea);
        this.add(mySea);
        this.add(menuBar);
        this.add(inGameBottomPanel);
        this.add(beforeGameBottomPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        chatPanel.setPreferredSize(new Dimension(1800, 3800));
        JScrollPane scrollPane = new JScrollPane(chatPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.setLocation(667, 60);
        scrollPane.setSize(332, 520);
        this.add(scrollPane);
        inGameBottomPanel.setGameFrameCallBack(gameFrameCallBack);
    }

    public void sendReady() {
        gameFrameCallBack.sendReady();
    }

    public void sendChat(ChatMessage chatMessage) {
        gameFrameCallBack.sendMessage(chatMessage);
    }

    @Override
    public void saveChatHistory() {
        IOTool.writeChatJSON(chatJSON.getForWrite(gameFrameCallBack.getEnemyName(), gameFrameCallBack.getEnemyIp(), new SimpleDateFormat("HH:mm:ss").format(new Date())));
        System.out.println("save chat history");
    }

    public void changePanelStates() {
        if (turn.getText().equals("Your Turn : "))
            turn.setText("Enemy Turn : ");
        else
            turn.setText("Your Turn : ");
        inGameBottomPanel.setVisible(true);
        beforeGameBottomPanel.setVisible(false);
        enemySea.setVisible(!enemySea.isVisible());
        mySea.setVisible(!mySea.isVisible());
    }

    public void resetBeforeBottomPanel() {
        beforeGameBottomPanel.setVisible(false);
        mySea.setVisible(false);

        myMasterSea = new MasterSeaPanel(92, 65, 438, 438, false);
        mySea = (MySeaPanel) myMasterSea.seaPanel;
        beforeGameBottomPanel = new BeforeGameBottomPanel(0, 550, 666, 150);
        beforeGameBottomPanel.setMaster(this);

        this.add(mySea);
        this.add(beforeGameBottomPanel);
    }

    public void showMySea() {
        enemySea.setVisible(false);
        mySea.setVisible(true);
    }

    public void addMessageJSON(MessageJSON x) {
        chatJSON.addMessage(x);
    }

    public void showEnemySea() {
        mySea.setVisible(false);
        enemySea.setVisible(true);
    }


    public BeforeGameBottomPanel getBeforeGameBottomPanel() {
        return beforeGameBottomPanel;
    }

    public InGameBottomPanel getInGameBottomPanel() {
        return inGameBottomPanel;
    }
}
