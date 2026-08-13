import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.math.BigInteger;

public class Bai5_Fibonacci extends JFrame {
    private JTextField txtN;
    private JTextArea txtAreaResult;

    public Bai5_Fibonacci() {
        setTitle("Dãy Fibonacci");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        topPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
        topPanel.add(new JLabel("Nhập n:"));
        txtN = new JTextField(10);
        topPanel.add(txtN);

        JButton btnGen = new JButton("Hiển thị");
        topPanel.add(btnGen);

        txtAreaResult = new JTextArea();
        txtAreaResult.setLineWrap(true);
        txtAreaResult.setWrapStyleWord(true);
        txtAreaResult.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaResult);
        scrollPane.setBorder(new EmptyBorder(8, 16, 16, 16));

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        btnGen.addActionListener(e -> {
            try {
                int n = Integer.parseInt(txtN.getText());
                if (n <= 0) throw new NumberFormatException();

                StringBuilder sb = new StringBuilder();
                BigInteger f0 = BigInteger.ZERO;
                BigInteger f1 = BigInteger.ONE;

                for (int i = 1; i <= n; i++) {
                    if (i == 1) sb.append(f0).append(", ");
                    else if (i == 2) sb.append(f1).append(", ");
                    else {
                        BigInteger fn = f0.add(f1);
                        sb.append(fn).append(i == n ? "" : ", ");
                        f0 = f1;
                        f1 = fn;
                    }
                }
                txtAreaResult.setText(sb.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập n nguyên dương hợp lệ!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai5_Fibonacci().setVisible(true));
    }
}