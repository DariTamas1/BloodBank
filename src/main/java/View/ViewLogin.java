package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewLogin {
    public static JFrame mainFrame;
    private JPanel mainPanel;
    public static JTextField username;
    public static JTextField password;
    public static JButton backButton;
    public static JButton loginButton;

    public ViewLogin(ActionListener backListener, ActionListener loginListener){
        initComponents();
        mainFrame.setSize(285, 170);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(mainPanel);
        mainFrame.setTitle("Login");
        mainFrame.setContentPane(mainPanel);

        JLabel l1 = new JLabel("Username: ");
        JLabel l2 = new JLabel("Password: ");
        l1.setBounds(10, 10, 200, 25);
        l2.setBounds(10, 40, 200, 25);

        username.setBounds(100, 10, 150, 25);
        password.setBounds(100, 40, 150, 25);
        backButton.setBounds(10, 70, 115, 25);
        backButton.addActionListener(backListener);
        loginButton.setBounds(135, 70, 115, 25);
        loginButton.addActionListener(loginListener);

        mainPanel.setLayout(null);
        mainPanel.add(loginButton);
        mainPanel.add(backButton);
        mainPanel.add(username);
        mainPanel.add(password);
        mainPanel.add(l1);
        mainPanel.add(l2);
    }


    private void initComponents(){
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        loginButton = new JButton("Login");
        backButton = new JButton("Back");
        username = new JTextField();
        password = new JTextField();
    }
}
