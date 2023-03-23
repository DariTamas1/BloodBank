package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewRegister {
    public static JFrame mainFrame;
    public static  JPanel mainPanel;
    public static JTextField username;
    public static JTextField password;
    public static JTextField name;
    public static JTextField email;
    public static JTextField address;
    public static JTextField bloodType;
    public static JButton backButton;
    public static JButton registerButton;

    public ViewRegister(ActionListener backListener, ActionListener registerListener){
        initComponents();
        mainFrame.setSize(285, 270);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(mainPanel);
        mainFrame.setTitle("Register");
        mainFrame.setContentPane(mainPanel);

        JLabel l1 = new JLabel("Username: ");
        JLabel l2 = new JLabel("Password: ");
        JLabel l4 = new JLabel("Name: ");
        JLabel l6 = new JLabel("Email: ");
        JLabel l7 = new JLabel("Address: ");
        JLabel l8 = new JLabel("Blood Type: ");
        l1.setBounds(10, 10, 200, 25);
        l2.setBounds(10, 40, 200, 25);
        l4.setBounds(10, 70, 200, 25);
        l6.setBounds(10, 100, 200, 25);
        l7.setBounds(10, 130, 200, 25);
        l8.setBounds(10, 160, 200, 25);

        username.setBounds(100, 10, 150, 25);
        password.setBounds(100, 40, 150, 25);
        name.setBounds(100, 70, 150, 25);
        email.setBounds(100, 100, 150, 25);
        address.setBounds(100, 130, 150, 25);
        bloodType.setBounds(100, 160, 150, 25);
        backButton.setBounds(10, 190, 115, 25);
        backButton.addActionListener(backListener);
        registerButton.setBounds(135, 190, 115, 25);
        registerButton.addActionListener(registerListener);

        mainPanel.setLayout(null);
        mainPanel.add(registerButton);
        mainPanel.add(backButton);
        mainPanel.add(username);
        mainPanel.add(password);
        mainPanel.add(l1);
        mainPanel.add(l2);
        mainPanel.add(l4);
        mainPanel.add(l6);
        mainPanel.add(l7);
        mainPanel.add(l8);
        mainPanel.add(name);
        mainPanel.add(email);
        mainPanel.add(address);
        mainPanel.add(bloodType);
    }

    private void initComponents(){
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        registerButton = new JButton("Register");
        backButton = new JButton("Back");
        username = new JTextField();
        password = new JTextField();
        name = new JTextField();
        email = new JTextField();
        address = new JTextField();
        bloodType = new JTextField();
    }
}
