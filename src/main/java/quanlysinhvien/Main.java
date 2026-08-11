import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- NHẬP THÔNG TIN SINH VIÊN ---");

        System.out.print("Nhập mã sinh viên: ");
        String maSV = scanner.nextLine();

        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();

        // Nhập và kiểm tra dữ liệu điểm
        double diemChuyenCan = nhapDiemHopLe(scanner, "điểm chuyên cần");
        double diemGiuaKy = nhapDiemHopLe(scanner, "điểm giữa kỳ");
        double diemCuoiKy = nhapDiemHopLe(scanner, "điểm cuối kỳ");

        // Khởi tạo đối tượng sinh viên
        SinhVien sv = new SinhVien(maSV, hoTen, diemChuyenCan, diemGiuaKy, diemCuoiKy);

        System.out.println("\n--- KẾT QUẢ ---");
        sv.hienThiKetQua();

        scanner.close();
    }

    // Nhập điểm trong khoảng 0 - 10
    public static double nhapDiemHopLe(Scanner scanner, String tenLoaiDiem) {
        double diem;
        while (true) {
            System.out.print("Nhập " + tenLoaiDiem + " (0 - 10): ");
            // Kiểm tra xem người dùng có nhập đúng định dạng số không
            if (scanner.hasNextDouble()) {
                diem = scanner.nextDouble();
                if (diem >= 0 && diem <= 10) {
                    break; // hợp lệ, thoát vòng lặp
                } else {
                    System.out.println("Lỗi: Điểm phải nằm trong khoảng 0 đến 10. Vui lòng nhập lại!");
                }
            } else {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
                scanner.next(); // Xóa dữ liệu lỗi trong bộ đệm
            }
        }
        return diem;
    }
}