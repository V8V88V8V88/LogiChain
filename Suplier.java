import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Suplier {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JPanel controlPanel;
    private JLabel nameLabel, emailLabel, passwordLabel;
    private GridLayout experimentLayout = new GridLayout(0, 2);

    Suplier() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Suplier swingControlDemo = new Suplier();
        swingControlDemo.showButtonDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Create Supplier Account");
        mainFrame.setSize(700, 400);
        mainFrame.setLayout(new GridLayout(2, 1));
        mainFrame.getContentPane().setBackground(Color.green);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                mainFrame.setVisible(false);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    public void showButtonDemo() {
        headerLabel.setText("Supply Chain Management System");
        headerLabel.setFont(new Font(null, Font.BOLD, 27));
        headerLabel.setForeground(Color.black);

        nameLabel = new JLabel("Enter Supplier Name");
        JTextField nameField = new JTextField();
        nameField.setSize(100, 30);

        emailLabel = new JLabel("Enter Mail Id");
        JTextField emailField = new JTextField();
        emailField.setSize(100, 30);

        passwordLabel = new JLabel("Enter Password");
        JTextField passwordField = new JTextField();
        passwordField.setSize(100, 30);

        JButton okButton = new JButton("Create");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PreparedStatement pst;
                DBConnection con = new DBConnection();
                try {
                    pst = con.makeDatabase().prepareStatement("INSERT INTO suppliers (name, email, password) VALUES (?, ?, ?)");
                    pst.setString(1, nameField.getText());
                    pst.setString(2, emailField.getText());
                    pst.setString(3, passwordField.getText());
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "Supplier Account Created!");
                    mainFrame.setVisible(false);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        JPanel jp = new JPanel();
        jp.add(nameLabel);
        jp.add(nameField);
        jp.add(emailLabel);
        jp.add(emailField);
        jp.add(passwordLabel);
        jp.add(passwordField);
        jp.setSize(200, 200);
        jp.setLayout(experimentLayout);
        controlPanel.add(jp);
        jp.add(okButton);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
