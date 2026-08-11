import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class lab03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab03: Exit App");
        frame.setSize(320, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color bgDark = new Color(46, 52, 64);
        Color accentGreen = new Color(163, 190, 140);
        Color btnText = new Color(46, 52, 64);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(bgDark);
        panel.setBorder(new EmptyBorder(32, 32, 32, 32));

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        exitButton.setBackground(accentGreen);
        exitButton.setForeground(btnText);
        exitButton.setFocusPainted(false);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        exitButton.setMargin(new Insets(8, 24, 8, 24));

        exitButton.addActionListener(e -> System.exit(0));

        panel.add(exitButton);
        frame.add(panel);

        frame.setVisible(true);
    }
}