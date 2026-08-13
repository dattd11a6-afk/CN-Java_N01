import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Bai3_PhuongTrinhBacNhat extends JFrame {
    private JTextField txtA, txtB;
    private JLabel lblResult;

    public Bai3_PhuongTrinhBacNhat() {
        setTitle("Giải phương trình bậc nhất");
        setSize(320, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 8, 8));
        panel.setBorder(new EmptyBorder(16, 16, 16, 16));
        panel.setBackground(new Color(244, 247, 249));

        panel.add(new JLabel("Nhập a:"));
        txtA = new JTextField();
        panel.add(txtA);

        panel.add(new JLabel("Nhập b:"));
        txtB = new JTextField();
        panel.add(txtB);

        JButton btnSolve = new JButton("Giải PT");
        btnSolve.setBackground(new Color(0, 122, 255));
        btnSolve.setForeground(Color.WHITE);
        panel.add(new JLabel("")); // Spacer
        panel.add(btnSolve);

        panel.add(new JLabel("Kết quả:"));
        lblResult = new JLabel("...", SwingConstants.CENTER);
        lblResult.setForeground(Color.RED);
        panel.add(lblResult);

        add(panel);

        btnSolve.addActionListener(e -> {
            try {
                double a = Double.parseDouble(txtA.getText());
                double b = Double.parseDouble(txtB.getText());
                if (a == 0) {
                    if (b == 0) lblResult.setText("Vô số nghiệm");
                    else lblResult.setText("Vô nghiệm");
                } else {
                    double x = -b / a;
                    lblResult.setText("x = " + String.format("%.2f", x));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai3_PhuongTrinhBacNhat().setVisible(true));
    }
}