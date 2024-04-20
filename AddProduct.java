import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddProduct {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JPanel controlPanel;
    private JLabel nameLabel, priceLabel, quantityLabel;
    private GridLayout experimentLayout = new GridLayout(0, 2);

    AddProduct() {
        prepareGUI();
    }

    public static void main(String[] args) {
        AddProduct swingControlDemo = new AddProduct();
        swingControlDemo.showButtonDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Add Product Details");
        mainFrame.setSize(700, 500);
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

        nameLabel = new JLabel("Enter Product Name");
        JTextField nameTextField = new JTextField();
        nameTextField.setSize(100, 40);

        priceLabel = new JLabel("Enter Price");
        JTextField priceTextField = new JTextField();
        priceTextField.setSize(100, 40);

        quantityLabel = new JLabel("Enter Quantity");
        JTextField quantityTextField = new JTextField();
        quantityTextField.setSize(100, 40);

        JButton okButton = new JButton("Add");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PreparedStatement pst;
                DBConnection con = new DBConnection();
                try {
                    pst = con.makeDatabase().prepareStatement("INSERT INTO supplychain(f_name, f_prize, f_quantity) VALUES (?, ?, ?)");
                    pst.setString(1, nameTextField.getText());
                    pst.setDouble(2, Double.parseDouble(priceTextField.getText()));
                    pst.setInt(3, Integer.parseInt(quantityTextField.getText()));
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Product Added: " + nameTextField.getText());
                    mainFrame.setVisible(false);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        JPanel jp = new JPanel(null);
        jp.add(nameLabel);
        jp.add(nameTextField);
        jp.add(priceLabel);
        jp.add(priceTextField);
        jp.add(quantityLabel);
        jp.add(quantityTextField);

        jp.setSize(700, 700);
        jp.setLayout(experimentLayout);
        controlPanel.add(jp);
        jp.add(okButton);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}

