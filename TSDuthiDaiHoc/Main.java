package TSDuthiDaiHoc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TuyenSinh tuyenSinh = new TuyenSinh();
        Scanner scanner = new Scanner(System.in);

        int luaChon;
        do {
            System.out.println("----- Quản lý thí sinh đại học -----");
            System.out.println("1. Thêm mới thí sinh");
            System.out.println("2. Hiển thị thông tin thí sinh và khối thi");
            System.out.println("3. Tìm kiếm theo số báo danh");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn: ");
            luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    tuyenSinh.themThiSinh();
                    break;
                case 2:
                    tuyenSinh.hienThiThongTinThiSinh();
                    break;
                case 3:
System.out.print("Nhập số báo danh cần tìm kiếm: ");
                    String soBaoDanh = scanner.nextLine();
                    tuyenSinh.timKiemTheoSoBaoDanh(soBaoDanh);
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (luaChon != 4);
    }
}
