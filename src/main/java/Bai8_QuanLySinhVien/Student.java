package Bai8_QuanLySinhVien;

public class Student {
    private String maSV;
    private String hoTen;
    private double diemTB;

    public Student(String maSV, String hoTen, double diemTB) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemTB = diemTB;
    }

    public String getMaSV() { return maSV; }
    public void setMaSV(String maSV) { this.maSV = maSV; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public double getDiemTB() { return diemTB; }
    public void setDiemTB(double diemTB) { this.diemTB = diemTB; }

    // Logic tự động xếp loại
    public String getXepLoai() {
        if (diemTB >= 8.5) return "Giỏi";
        if (diemTB >= 7.0) return "Khá";
        if (diemTB >= 5.0) return "Trung bình";
        return "Yếu";
    }
}