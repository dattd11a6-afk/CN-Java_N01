import javax.swing.*;
import java.awt.*;

public class bai2_tinhtong {
    public static void main(String[] args) {
        // Khởi tạo cửa sổ
        JFrame frame = new JFrame("Tính Tổng Hai Số");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Căn giữa màn hình

        frame.setLayout(new GridLayout(4, 2, 8, 8));

        // Khởi tạo các thành phần giao diện
        JLabel lblNum1 = new JLabel("Nhập số thứ nhất:");
        JTextField txtNum1 = new JTextField();

        JLabel lblNum2 = new JLabel("Nhập số thứ hai:");
        JTextField txtNum2 = new JTextField();

        JButton btnCalculate = new JButton("Tính Tổng");
        JLabel lblResult = new JLabel("Kết quả: ");
        lblResult.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Thêm các thành phần vào cửa sổ
        frame.add(lblNum1);
        frame.add(txtNum1);

        frame.add(lblNum2);
        frame.add(txtNum2);

        frame.add(new JLabel(""));
        frame.add(btnCalculate);

        frame.add(new JLabel("")); // Ô trống
        frame.add(lblResult);

        // Tính toán và bắt lỗi nhập liệu
        btnCalculate.addActionListener(e -> {
            try {
                // Ép kiểu dữ liệu từ String (văn bản) >> Double (số thực)
                double num1 = Double.parseDouble(txtNum1.getText().trim());
                double num2 = Double.parseDouble(txtNum2.getText().trim());

                double sum = num1 + num2;
                lblResult.setText("Kết quả: " + sum);
                lblResult.setForeground(new Color(34, 139, 34)); // Màu xanh lá

            } catch (NumberFormatException ex) {

                lblResult.setText("Kết quả: Lỗi!");
                lblResult.setForeground(Color.RED); // Màu đỏ cảnh báo

                // Hiển thị hộp thoại báo lỗi
                JOptionPane.showMessageDialog(
                        frame,
                        "Vui lòng chỉ nhập số hợp lệ!\nKhông được nhập chữ hoặc để trống.",
                        "Lỗi Nhập Liệu",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        // Hiển thị form
        frame.setVisible(true);
    }
}