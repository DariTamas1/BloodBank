package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class ViewAdmin {
    public static JFrame mainFrame;
    private JPanel mainPanel;
    public static JTextField addUsername;
    public static JTextField addPassword;
    public static JTextField addName;
    public static JTextField addEmail;
    public static JTextField addAddress;
    public static JTable doctorTable;
    private static JButton addButton;
    private static JButton deleteButton;
    private static JButton editButton;
    private static JButton backButton;

    public ViewAdmin(ActionListener addListener, ActionListener deleteListener, ActionListener updateListener, ActionListener backListener){
        initComponents();
        mainFrame.setSize(960, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(mainPanel);
        mainFrame.setTitle("Admin");
        mainFrame.setContentPane(mainPanel);

        JLabel l1 = new JLabel("Add Doctor");
        JLabel l2 = new JLabel("Username: ");
        JLabel l3 = new JLabel("Password: ");
        JLabel l4 = new JLabel("Name: ");
        JLabel l5 = new JLabel("Email: ");
        JLabel l6 = new JLabel("Address: ");
        JLabel l7 = new JLabel("All Doctors");

        l1.setBounds(90, 10, 200, 25);
        l2.setBounds(10, 40, 200, 25);
        l3.setBounds(10, 70, 200, 25);
        l4.setBounds(10, 100, 200, 25);
        l5.setBounds(10, 130, 200, 25);
        l6.setBounds(10, 160, 200, 25);
        l7.setBounds(430, 10, 200, 25);
        addUsername.setBounds(100, 40, 200, 25);
        addPassword.setBounds(100, 70, 200, 25);
        addName.setBounds(100, 100, 200, 25);
        addEmail.setBounds(100, 130, 200, 25);
        addAddress.setBounds(100, 160, 200, 25);
        addButton.setBounds(80, 195, 150, 25);
        editButton.setBounds(350,260, 270, 25);
        deleteButton.setBounds(630,260, 270, 25);
        backButton.setBounds(80, 225, 150, 25);
        backButton.addActionListener(backListener);

        JScrollPane doctorScrollPane = new JScrollPane(doctorTable);
        doctorScrollPane.setBounds(350, 40, 550, 200);
        doctorTable.setBounds(350, 40, 550, 200);
        addButton.addActionListener(addListener);
        deleteButton.addActionListener(deleteListener);
        editButton.addActionListener(updateListener);

        mainPanel.setLayout(null);
        mainPanel.add(l1);
        mainPanel.add(l2);
        mainPanel.add(l3);
        mainPanel.add(l4);
        mainPanel.add(l5);
        mainPanel.add(l6);
        mainPanel.add(l7);
        mainPanel.add(addUsername);
        mainPanel.add(addPassword);
        mainPanel.add(addName);
        mainPanel.add(addEmail);
        mainPanel.add(addAddress);
        mainPanel.add(addButton);
        mainPanel.add(doctorScrollPane);
        mainPanel.add(deleteButton);
        mainPanel.add(editButton);
        mainPanel.add(backButton);
    }

    private void initComponents(){
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        addUsername = new JTextField();
        addPassword = new JTextField();
        addName = new JTextField();
        addEmail = new JTextField();
        addAddress = new JTextField();
        addButton = new JButton("Add Client");
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Address");
        model.addColumn("UserId");
        doctorTable = new JTable(model);
        deleteButton = new JButton("Delete selected client");
        editButton = new JButton("Edit selected client");
        backButton = new JButton("Back");
    }
}
