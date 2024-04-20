import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame {
    private JLabel idLabel;
    private JLabel passLabel;
    private JLabel background;
    private JLabel headerLabel;
    private JLabel devInfo;
    private JTextField id;
    private JPasswordField pass;
    private JButton submit;

    public Login() {
        setTitle("Supply Chain Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.background = new JLabel(new ImageIcon("sup.jpeg"));
        this.init();
        add(background);
        background.setVisible(true);
        this.pack();
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
    }

    public void init() {
        headerLabel = new JLabel(); // Initialize headerLabel here
        this.headerLabel.setBounds(190, 1, 370, 150);
        this.headerLabel.setFont(new Font("Geomanist", Font.BOLD, 20));
        headerLabel.setForeground(Color.red);
        add(headerLabel);

        idLabel = new JLabel();
        this.idLabel.setText("Username");
        this.idLabel.setBounds(190, 110, 100, 50);
        this.idLabel.setFont(new Font(null, Font.BOLD, 20));
        idLabel.setForeground(Color.black);
        add(idLabel);

        passLabel = new JLabel("Password");
        this.passLabel.setBounds(190, 165, 100, 50);
        this.passLabel.setFont(new Font(null, Font.BOLD, 20));
        passLabel.setForeground(Color.black);
        add(passLabel);

        devInfo = new JLabel();
        this.devInfo.setText("");
        this.devInfo.setBounds(130, 300, 1000, 30);
        this.devInfo.setFont(new Font("Geomanist", Font.PLAIN, 15));
        devInfo.setForeground(Color.white);
        add(devInfo);

        id = new JTextField();
        this.id.setBounds(300, 125, 200, 30);
        add(id);

        pass = new JPasswordField();
        this.add(pass);
        this.pass.setBounds(300, 175, 200, 30);
        this.id.setVisible(true);

        this.submit = new JButton("Login");
        this.submit.setBounds(400, 230, 100, 25);
        add(submit);
        submit.addActionListener(this::submitActionPerformed);
    }

public void submitActionPerformed(java.awt.event.ActionEvent evt) {
    String password = new String(pass.getPassword());
    if (id.getText().equals("admin") && password.equals("admin")) {
        this.setVisible(false);
        Home home = new Home();
    } else {
        JOptionPane.showMessageDialog(null, "Invalid password!");
    }
}

    public static void main(String[] args) {
        Login l = new Login();
        l.setVisible(true);
    }
}

class Frame2new extends JFrame {
    public Frame2new() {
        setTitle("Home");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void showButtonDemo() {
        setVisible(true);
    }
}
