package TSDuthiDaiHoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuyenSinh {
    private List<ThiSinh> danhSachThiSinh;

    public TuyenSinh() {
        danhSachThiSinh = new ArrayList<>();
    }

    public void themThiSinh() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Thêm mới thí sinh");
        System.out.print("Số báo danh: ");
        String soBaoDanh = scanner.nextLine();
        System.out.print("Họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Địa chỉ: ");
String diaChi = scanner.nextLine();
        System.out.print("Mức ưu tiên: ");
        int mucUuTien = Integer.parseInt(scanner.nextLine());
        System.out.print("Khối thi (A, B, C): ");
        String khoiThi = scanner.nextLine();

        if (khoiThi.equalsIgnoreCase("A")) {
            System.out.print("Điểm Toán: ");
            int diemToan = Integer.parseInt(scanner.nextLine());
            System.out.print("Điểm Lý: ");
            int diemLy = Integer.parseInt(scanner.nextLine());
            System.out.print("Điểm Hóa: ");
            int diemHoa = Integer.parseInt(scanner.nextLine());

            ThiSinhKhoiA thiSinh = new ThiSinhKhoiA(soBaoDanh, hoTen, diaChi, mucUuTien, diemToan, diemLy, diemHoa);
            danhSachThiSinh.add(thiSinh);
        } else if (khoiThi.equalsIgnoreCase("B")) {
            System.out.print("Điểm Toán: ");
            int diemToan = Integer.parseInt(scanner.nextLine());
            System.out.print("Điểm Hóa: ");
            int diemHoa = Integer.parseInt(scanner.nextLine());
            System.out.print("Điểm Sinh: ");
            int diemSinh = Integer.parseInt(scanner.nextLine());

            ThiSinhKhoiB thiSinh = new ThiSinhKhoiB(soBaoDanh, hoTen, diaChi, mucUuTien, diemToan, diemHoa, diemSinh);
            danhSachThiSinh.add(thiSinh);
        } else if (khoiThi.equalsIgnoreCase("C")) {
            System.out.print("Điểm Văn: ");
            int diemVan = Integer.parseInt(scanner.nextLine());
            System.out.print("Điểm Sử: ");
            int diemSu = Integer.parseInt(scanner.nextLine());
            System.out.print("Điểm Địa: ");
            int diemDia = Integer.parseInt(scanner.nextLine());

            ThiSinhKhoiC thiSinh = new ThiSinhKhoiC(soBaoDanh, hoTen, diaChi, mucUuTien, diemVan, diemSu, diemDia);
            danhSachThiSinh.add(thiSinh);
        } else {
            System.out.println("Khối thi không hợp lệ!");
        }

        System.out.println("Thêm mới thí sinh thành công!");
    }

    public void hienThiThongTinThiSinh() {
        System.out.println("Thông tin thí sinh và khối thi:");
        for (ThiSinh thiSinh : danhSachThiSinh) {
            System.out.println("Số báo danh: " + thiSinh.getSoBaoDanh());
            System.out.println("Họ tên: " + thiSinh.getHoTen());
            System.out.println("Địa chỉ: " + thiSinh.getDiaChi());
            System.out.println("Mức ưu tiên: " + thiSinh.getMucUuTien());

            if (thiSinh instanceof ThiSinhKhoiA) {
                ThiSinhKhoiA thiSinhKhoiA = (ThiSinhKhoiA) thiSinh;
                System.out.println("Khối thi: A");
                System.out.println("Điểm Toán: " + thiSinhKhoiA.getDiemToan());
                System.out.println("Điểm Lý: " + thiSinhKhoiA.getDiemLy());
                System.out.println("Điểm Hóa: " + thiSinhKhoiA.getDiemHoa());
            } else if (thiSinh instanceof ThiSinhKhoiB) {
ThiSinhKhoiB thiSinhKhoiB = (ThiSinhKhoiB) thiSinh;
                System.out.println("Khối thi: B");
                System.out.println("Điểm Toán: " + thiSinhKhoiB.getDiemToan());
                System.out.println("Điểm Hóa: " + thiSinhKhoiB.getDiemHoa());
                System.out.println("Điểm Sinh: " + thiSinhKhoiB.getDiemSinh());
            } else if (thiSinh instanceof ThiSinhKhoiC) {
                ThiSinhKhoiC thiSinhKhoiC = (ThiSinhKhoiC) thiSinh;
                System.out.println("Khối thi: C");
                System.out.println("Điểm Văn: " + thiSinhKhoiC.getDiemVan());
                        System.out.println("Điểm Sử: " + thiSinhKhoiC.getDiemSu());
                System.out.println("Điểm Địa: " + thiSinhKhoiC.getDiemDia());
            }

            System.out.println("----------------------");
        }
    }

    public void timKiemTheoSoBaoDanh(String soBaoDanh) {
        System.out.println("Kết quả tìm kiếm:");
        boolean timThay = false;

        for (ThiSinh thiSinh : danhSachThiSinh) {
            if (thiSinh.getSoBaoDanh().equals(soBaoDanh)) {
                System.out.println("Số báo danh: " + thiSinh.getSoBaoDanh());
                System.out.println("Họ tên: " + thiSinh.getHoTen());
                System.out.println("Địa chỉ: " + thiSinh.getDiaChi());
                System.out.println("Mức ưu tiên: " + thiSinh.getMucUuTien());

                if (thiSinh instanceof ThiSinhKhoiA) {
                    System.out.println("Khối thi: A");
                } else if (thiSinh instanceof ThiSinhKhoiB) {
                    System.out.println("Khối thi: B");
                } else if (thiSinh instanceof ThiSinhKhoiC) {
                    System.out.println("Khối thi: C");
                }

                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy thí sinh có số báo danh " + soBaoDanh);
        }
    }
}

