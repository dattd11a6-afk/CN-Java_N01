package Bai8_QuanLySinhVien;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Bai8_QuanLySinhVien extends JFrame {
    private JTextField txtMaSV, txtHoTen, txtDiemTB;
    private JTable table;
    private StudentTableModel tableModel;

    // Thiết lập màu sắc giao diện
    private final Color COLOR_BG = new Color(244, 247, 249);
    private final Color COLOR_PRIMARY = new Color(0, 122, 255);
    private final Color COLOR_DANGER = new Color(255, 59, 48);
    private final Color COLOR_WARNING = new Color(255, 149, 0);

    public Bai8_QuanLySinhVien() {
        setTitle("Quản Lý Sinh Viên");
        setSize(720, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR_BG);
        setLayout(new BorderLayout(16, 16));

        // 1. Panel Nhập liệu
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 8, 16));
        formPanel.setOpaque(false);
        formPanel.setBorder(new EmptyBorder(24, 24, 8, 24));

        formPanel.add(new JLabel("Mã sinh viên:"));
        txtMaSV = new JTextField();
        formPanel.add(txtMaSV);

        formPanel.add(new JLabel("Họ tên:"));
        txtHoTen = new JTextField();
        formPanel.add(txtHoTen);

        formPanel.add(new JLabel("Điểm trung bình (0-10):"));
        txtDiemTB = new JTextField();
        formPanel.add(txtDiemTB);

        // 2. Panel Nút bấm
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 16, 8));
        btnPanel.setOpaque(false);
        btnPanel.setBorder(new EmptyBorder(0, 24, 16, 24));

        JButton btnAdd = createBtn("Thêm", COLOR_PRIMARY);
        JButton btnEdit = createBtn("Sửa", COLOR_WARNING);
        JButton btnDelete = createBtn("Xóa", COLOR_DANGER);
        JButton btnReset = createBtn("Làm mới", Color.GRAY);

        btnPanel.add(btnAdd);
        btnPanel.add(btnEdit);
        btnPanel.add(btnDelete);
        btnPanel.add(btnReset);

        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.setOpaque(false);
        topContainer.add(formPanel, BorderLayout.CENTER);
        topContainer.add(btnPanel, BorderLayout.SOUTH);

        tableModel = new StudentTableModel();
        table = new JTable(tableModel);
        table.setRowHeight(32);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 24, 24, 24));
        scrollPane.getViewport().setBackground(Color.WHITE);

        add(topContainer, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                Student s = tableModel.getStudentAt(row);
                txtMaSV.setText(s.getMaSV());
                txtMaSV.setEditable(false); // Khóa mã SV, không cho sửa khóa chính
                txtHoTen.setText(s.getHoTen());
                txtDiemTB.setText(String.valueOf(s.getDiemTB()));
            }
        });

        // Xử lý Thêm
        btnAdd.addActionListener(e -> {
            try {
                if (txtMaSV.getText().trim().isEmpty() || txtHoTen.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ Mã SV và Họ tên!");
                    return;
                }
                double diem = Double.parseDouble(txtDiemTB.getText());
                if (diem < 0 || diem > 10) throw new NumberFormatException();

                tableModel.addStudent(new Student(txtMaSV.getText(), txtHoTen.getText(), diem));
                btnReset.doClick();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Điểm phải là số hợp lệ từ 0 đến 10!");
            }
        });

        // Xử lý Sửa
        btnEdit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                try {
                    double diem = Double.parseDouble(txtDiemTB.getText());
                    if (diem < 0 || diem > 10) throw new NumberFormatException();

                    Student s = new Student(txtMaSV.getText(), txtHoTen.getText(), diem);
                    tableModel.updateStudent(row, s);
                    btnReset.doClick();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Điểm phải là số hợp lệ từ 0 đến 10!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn một dòng trong bảng để sửa!");
            }
        });

        // Xử lý Xóa
        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                int confirm = JOptionPane.showConfirmDialog(this, "Xóa sinh viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    tableModel.deleteStudent(row);
                    btnReset.doClick();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn một dòng trong bảng để xóa!");
            }
        });

        // Xử lý Làm mới
        btnReset.addActionListener(e -> {
            txtMaSV.setText("");
            txtMaSV.setEditable(true); // Mở lại ô nhập Mã SV
            txtHoTen.setText("");
            txtDiemTB.setText("");
            table.clearSelection();
        });
    }

    // Hàm tạo giao diện nút bấm
    private JButton createBtn(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(8, 24, 8, 24));
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai8_QuanLySinhVien().setVisible(true));
    }
}