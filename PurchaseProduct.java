import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseProduct {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JPanel controlPanel;
    private JLabel pidLabel, quantityLabel;
    private GridLayout experimentLayout = new GridLayout(0, 2);

    PurchaseProduct() {
        prepareGUI();
    }

    public static void main(String[] args) {
        PurchaseProduct purchaseProduct = new PurchaseProduct();
        purchaseProduct.showButtonDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Purchase Product");
        mainFrame.setSize(700, 400);
        mainFrame.setLayout(new GridLayout(3, 1));
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

        quantityLabel = new JLabel("Enter Quantity");
        JTextField quantityField = new JTextField();
        quantityField.setSize(100, 30);
        JButton okButton = new JButton("Place Order");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PreparedStatement pst;
                DBConnection con = new DBConnection();
                try {
                    pst = con.makeDatabase().prepareStatement("UPDATE supplychain SET f_quantity = ?, f_prize = ? WHERE f_name = ?");
                    pst.setString(3, pidField.getText());
                    pst.setDouble(2, Double.parseDouble(quantityField.getText()));
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "Product Ordered: " + pidField.getText());
                    mainFrame.setVisible(false);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        JPanel jp = new JPanel();
        jp.add(pidLabel);
        jp.add(pidField);
        jp.add(quantityLabel);
        jp.add(quantityField);
        jp.setSize(200, 200);
        jp.setLayout(experimentLayout);
        controlPanel.add(jp);
        jp.add(okButton);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}

