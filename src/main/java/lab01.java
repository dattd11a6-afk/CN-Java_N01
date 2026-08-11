import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class lab01 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First Swing App");

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Màu sắc Nordic
        Color bgDark = new Color(46, 52, 64);
        Color textWhite = new Color(236, 239, 244);

        frame.getContentPane().setBackground(bgDark);

        JLabel label = new JLabel("Xin chào Đỗ Phát Đạt", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 32));
        label.setForeground(textWhite);

        label.setBorder(new EmptyBorder(24, 24, 24, 24));

        frame.add(label, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}