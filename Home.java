import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JPanel controlPanel;

    public Home() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                prepareGUI();
            }
        });
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Supply Chain Management System");
        mainFrame.setBounds(100, 100, 700, 400);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().setBackground(Color.white);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        headerLabel = new JLabel("Supply Chain Management System", JLabel.CENTER);
        headerLabel.setFont(new Font(null, Font.BOLD, 27));
        headerLabel.setForeground(Color.black);
        mainFrame.add(headerLabel, BorderLayout.NORTH);

        controlPanel = new JPanel(new GridLayout(1, 5));
        mainFrame.add(controlPanel, BorderLayout.CENTER);

        addButton("Supplier Account");
        addButton("Product");
        addButton("Product Details");
        addButton("About");
        addButton("Purchase Product");

        mainFrame.setVisible(true);
    }

    private void addButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setFont(new Font(null, Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (buttonText.equals("Product Details")) {
                    showProductDetails();
                } else if (buttonText.equals("About")) {
                    showAbout();
                } else if (buttonText.equals("Supplier Account")) {
                    showSupplierAccount();
                } else if (buttonText.equals("Purchase Product")) {
                    showPurchaseProduct();
                } else if (buttonText.equals("Product")) {
                    showProduct();
                }
            }
        });
        controlPanel.add(button);
    }

private void showProduct() {
    AddProduct addProduct = new AddProduct();
    addProduct.showButtonDemo();
}

private void showPurchaseProduct() {
    PurchaseProduct purchaseProduct = new PurchaseProduct();
    purchaseProduct.showButtonDemo();
}

private void showProductDetails() {
    SearchProduct searchProduct = new SearchProduct();
    searchProduct.showButtonDemo();
}

private void showSupplierAccount() {
    Suplier supplier = new Suplier();
    supplier.showButtonDemo();
    
}

private void showAbout() {
    About about = new About();
    about.setVisible(true);
}
 public static void main(String[] args) {
        new Home();
    }
}
