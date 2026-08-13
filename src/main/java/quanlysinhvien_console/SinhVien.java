package quanlysinhvien_console;

public class SinhVien {
    private String maSV;
    private String hoTen;
    private double diemChuyenCan;
    private double diemGiuaKy;
    private double diemCuoiKy;

    // Hàm khởi tạo
    public SinhVien(String maSV, String hoTen, double diemChuyenCan, double diemGiuaKy, double diemCuoiKy) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemChuyenCan = diemChuyenCan;
        this.diemGiuaKy = diemGiuaKy;
        this.diemCuoiKy = diemCuoiKy;
    }

    // Tính điểm tổng kết
    public double tinhDiemTongKet() {
        return (this.diemChuyenCan * 0.10) + (this.diemGiuaKy * 0.30) + (this.diemCuoiKy * 0.60);
    }

    // Xếp loại
    public String xepLoai() {
        double diemTK = tinhDiemTongKet();
        if (diemTK >= 8.5) {
            return "A";
        } else if (diemTK >= 7.0) {
            return "B";
        } else if (diemTK >= 5.5) {
            return "C";
        } else if (diemTK >= 4.0) {
            return "D";
        } else {
            return "F";
        }
    }

    // Hiển thị kết quả
    public void hienThiKetQua() {
        System.out.printf("%s - %s - %.2f - %s\n", this.maSV, this.hoTen, tinhDiemTongKet(), xepLoai());
    }
}