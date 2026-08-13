import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Bai6_LoginForm extends JFrame {
    public Bai6_LoginForm() {
        setTitle("Đăng nhập hệ thống");
        setSize(360, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Background: 60%
        getContentPane().setBackground(new Color(244, 247, 249));
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 1, 8, 8));
        formPanel.setOpaque(false);
        formPanel.setBorder(new EmptyBorder(24, 24, 24, 24));

        formPanel.add(new JLabel("Tên đăng nhập:"));
        JTextField txtUser = new JTextField();
        formPanel.add(txtUser);

        formPanel.add(new JLabel("Mật khẩu:"));
        JPasswordField txtPass = new JPasswordField();
        formPanel.add(txtPass);

        JPanel optionPanel = new JPanel(new GridLayout(1, 2, 8, 8));
        optionPanel.setOpaque(false);
        JCheckBox chkRemember = new JCheckBox("Ghi nhớ");
        chkRemember.setOpaque(false);
        JComboBox<String> cbRole = new JComboBox<>(new String[]{"Admin", "User"});
        optionPanel.add(chkRemember);
        optionPanel.add(cbRole);
        formPanel.add(optionPanel);

        // Nút bấm: 30% (Màu chủ đạo xanh)
        JButton btnLogin = new JButton("Đăng nhập");
        btnLogin.setBackground(new Color(0, 122, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.setOpaque(false);
        btnPanel.setBorder(new EmptyBorder(0, 24, 24, 24));
        btnPanel.add(btnLogin, BorderLayout.CENTER);

        add(formPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        btnLogin.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());
            String role = cbRole.getSelectedItem().toString();

            if (user.equals("admin") && pass.equals("123456")) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công với quyền " + role);
            } else {
                JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai6_LoginForm().setVisible(true));
    }
}