import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchProduct {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JPanel controlPanel;
    private JLabel pidLabel;
    private GridLayout experimentLayout = new GridLayout(0, 2);

    SearchProduct() {
        prepareGUI();
    }

    public static void main(String[] args) {
        SearchProduct swingControlDemo = new SearchProduct();
        swingControlDemo.showButtonDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Search Product");
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

        pidLabel = new JLabel("Enter Product Id");
        JTextField pidField = new JTextField();
        pidField.setSize(100, 30);

        JButton okButton = new JButton("Search Product");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PreparedStatement pst;
                DBConnection con = new DBConnection();
                try {
                    pst = con.makeDatabase().prepareStatement("SELECT f_quantity, f_prize FROM supplychain WHERE f_name = ?");
                    pst.setString(1, pidField.getText());
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        int quantity = rs.getInt("f_quantity");
                        double price = rs.getDouble("f_prize");
                        JOptionPane.showMessageDialog(null, "Product Details: \nQuantity: " + quantity + "\nPrice: " + price);
                    } else {
                        JOptionPane.showMessageDialog(null, "Product not found!");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        JPanel jp = new JPanel();
        jp.add(pidLabel);
        jp.add(pidField);
        jp.setSize(200, 200);
        jp.setLayout(experimentLayout);
        controlPanel.add(jp);
        jp.add(okButton);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
