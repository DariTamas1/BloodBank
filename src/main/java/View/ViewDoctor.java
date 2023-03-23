package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewDoctor {
    public static JFrame mainFrame;
    private JPanel mainPanel;
//    public static JButton loginButton;
//    public static JButton registerButton;

    public ViewDoctor(ActionListener loginListener, ActionListener registerListener){
        initComponents();
        mainFrame.setSize(470, 170);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(mainPanel);
        mainFrame.setTitle("Doctor");
        mainFrame.setContentPane(mainPanel);

//        loginButton.setBounds(30, 30, 410, 30);
//        loginButton.addActionListener(loginListener);
//        registerButton.setBounds(30, 70, 410, 30);
//        registerButton.addActionListener(registerListener);

        mainPanel.setLayout(null);
//        mainPanel.add(loginButton);
//        mainPanel.add(registerButton);
    }

    private void initComponents(){
        mainFrame = new JFrame();
        mainPanel = new JPanel();
//        loginButton = new JButton("Login");
//        registerButton = new JButton("Register");
    }
}
