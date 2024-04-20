import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    public About() {
        setTitle("About");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        JLabel headerLabel = new JLabel("Supply Chain Management System", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headerLabel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("This is a Supply Chain Management System developed by:\n\n" +
                         "1. Vaibhav Pratap Singh (Lead Dev)\n" +
                         "2. Shobhit Shukla\n" +
                         "3. Kundan Kumar Mahato\n" +
                         "4. Nitesh Tiwari\n" +
                         "5. Sachin Singh Adhikari\n\n" +
                         "Features:\n" +
                         "- Add new products\n" +
                         "- Search for product details\n" +
                         "- Purchase products\n" +
                         "- Manage supplier accounts\n\n" +
                         "Version: 1.0\n" +
                         "CopyLeft 🄯 [2024]");
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                About about = new About();
                about.setVisible(true);
            }
        });
    }
}
