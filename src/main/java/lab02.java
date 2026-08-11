import javax.swing.*;
import java.awt.*;

public class lab02 {
    public static void main(String[] args) {

        // Tùy chỉnh màu sắc hệ thống
        Color bgDark = new Color(46, 52, 64);
        Color textWhite = new Color(236, 239, 244);
        Color accentGreen = new Color(163, 190, 140);

        UIManager.put("OptionPane.background", bgDark);
        UIManager.put("Panel.background", bgDark);
        UIManager.put("OptionPane.messageForeground", textWhite);
        UIManager.put("Button.background", accentGreen);
        UIManager.put("Button.foreground", new Color(46, 52, 64));
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 16));

        JFrame frame = new JFrame("Welcome");
        frame.setSize(320, 240);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);

        // Hiển thị Dialog
        JOptionPane.showMessageDialog(
                frame,
                "Welcome Do Phat Dat",
                "Lab02: Welcome",
                JOptionPane.INFORMATION_MESSAGE
        );

        System.exit(0);
    }
}