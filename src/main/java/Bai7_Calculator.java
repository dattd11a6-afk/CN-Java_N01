import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Bai7_Calculator extends JFrame {
    private JTextField txtA, txtB;
    private JLabel lblResult;
    private JTextArea txtHistory;

    public Bai7_Calculator() {
        setTitle("Máy tính Mini");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 8, 8));
        inputPanel.setBorder(new EmptyBorder(16, 16, 8, 16));
        inputPanel.add(new JLabel("Số A:"));
        txtA = new JTextField();
        inputPanel.add(txtA);
        inputPanel.add(new JLabel("Số B:"));
        txtB = new JTextField();
        inputPanel.add(txtB);
        inputPanel.add(new JLabel("Kết quả:"));
        lblResult = new JLabel("0.0");
        lblResult.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(lblResult);

        JPanel btnPanel = new JPanel(new GridLayout(1, 5, 8, 8));
        btnPanel.setBorder(new EmptyBorder(0, 16, 16, 16));
        String[] ops = {"+", "-", "*", "/", "C"};
        for (String op : ops) {
            JButton btn = new JButton(op);
            btn.addActionListener(e -> calculate(op));
            btnPanel.add(btn);
        }

        txtHistory = new JTextArea();
        txtHistory.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtHistory);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lịch sử"));

        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.add(inputPanel, BorderLayout.CENTER);
        topContainer.add(btnPanel, BorderLayout.SOUTH);

        add(topContainer, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void calculate(String operator) {
        if (operator.equals("C")) {
            txtA.setText("");
            txtB.setText("");
            lblResult.setText("0");
            return;
        }

        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double res = 0;

            switch (operator) {
                case "+": res = a + b; break;
                case "-": res = a - b; break;
                case "*": res = a * b; break;
                case "/":
                    if (b == 0) {
                        JOptionPane.showMessageDialog(this, "Không thể chia cho 0!");
                        return;
                    }
                    res = a / b;
                    break;
            }
            lblResult.setText(String.valueOf(res));
            txtHistory.append(String.format("%.2f %s %.2f = %.2f\n", a, operator, b, res));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai7_Calculator().setVisible(true));
    }
}