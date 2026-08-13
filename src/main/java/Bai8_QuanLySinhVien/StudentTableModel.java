package Bai8_QuanLySinhVien;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    private List<Student> students;
    private final String[] columnNames = {"Mã SV", "Họ tên", "Điểm TB", "Xếp loại"};

    public StudentTableModel() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
        fireTableRowsInserted(students.size() - 1, students.size() - 1);
    }

    public void updateStudent(int rowIndex, Student s) {
        students.set(rowIndex, s);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void deleteStudent(int rowIndex) {
        students.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public Student getStudentAt(int rowIndex) {
        return students.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student s = students.get(rowIndex);
        switch (columnIndex) {
            case 0: return s.getMaSV();
            case 1: return s.getHoTen();
            case 2: return s.getDiemTB();
            case 3: return s.getXepLoai(); // Tự động lấy xếp loại
            default: return null;
        }
    }
}