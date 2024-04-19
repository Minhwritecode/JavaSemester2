package QLCB;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class QLCB {
private List<CanBo> danhSachCanBo;

public QLCB() {
    danhSachCanBo = new ArrayList<>();
}

public void themMoiCanBo(CanBo canBo) {
    danhSachCanBo.add(canBo);
}

public void timKiemTheoHoTen(String hoTen) {
    boolean timThay = false;
    for (CanBo canBo : danhSachCanBo) {
        if (canBo.getHoTen().equalsIgnoreCase(hoTen)) {
            timThay = true;
            System.out.println(canBo.getClass().getSimpleName() + ": " + canBo.getHoTen());
            System.out.println("Tuổi: " + canBo.getTuoi());
            System.out.println("Giới tính: " + canBo.getGioiTinh());int heart;
			System.out.println("Địa chỉ: " + canBo.getDiaChi());
            if (canBo instanceof CongNhan) {
                CongNhan congNhan = (CongNhan) canBo;
                System.out.println("Bậc: " + congNhan.getBac());
            } else if (canBo instanceof KySu) {
                KySu kySu = (KySu) canBo;
                System.out.println("Ngành đào tạo: " + kySu.getNganhDaoTao());
            } else if (canBo instanceof NhanVien) {
                NhanVien nhanVien = (NhanVien) canBo;
                System.out.println("Công việc: " + nhanVien.getCongViec());
            }
            System.out.println("-----------------------");
        }
    }
    if (!timThay) {
        System.out.println("Không tìm thấy cán bộ có họ tên: " + hoTen);
    }
}

public void hienThiDanhSachCanBo() {
    if (danhSachCanBo.isEmpty()) {
        System.out.println("Danh sách cán bộ trống.");
    } else {
        System.out.println("Danh sách cán bộ:");
        for (CanBo canBo : danhSachCanBo) {
            System.out.println(canBo.getClass().getSimpleName() + ": " + canBo.getHoTen());
            System.out.println("Tuổi: " + canBo.getTuoi());
            System.out.println("Giới tính: " + canBo.getGioiTinh());
            System.out.println("Địa chỉ: " + canBo.getDiaChi());
            if (canBo instanceof CongNhan) {
                CongNhan congNhan = (CongNhan) canBo;
                System.out.println("Bậc: " + congNhan.getBac());
            } else if (canBo instanceof KySu) {
                KySu kySu = (KySu) canBo;
                System.out.println("Ngành đào tạo: " + kySu.getNganhDaoTao());
            } else if (canBo instanceof NhanVien) {
                NhanVien nhanVien = (NhanVien) canBo;
                System.out.println("Công việc: " + nhanVien.getCongViec());
            }
            System.out.println("-----------------------");
        }
    }
}

public static void main(String[] args) {
    QLCB qlcb = new QLCB();
    Scanner scanner = new Scanner(System.in);
    int luaChon = 0;

    do {
        System.out.println("===== Quản Lý Cán Bộ =====");
        System.out.println("1. Thêm mới cán bộ");
        System.out.println("2. Tìm kiếm theo họ tên");
        System.out.println("3. Hiển thị danh sách cán bộ");
        System.out.println("4. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
        luaChon = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ ký tự newline sau khi nhập số

        switch (luaChon) {
            case 1:
                System.out.println("=== Thêm mới cán bộ ===");System.out.print("Nhập loại cán bộ (1 - Công nhân, 2 - Kỹ sư, 3 - Nhân viên): ");
                
                int loaiCanBo = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự newline sau khi nhập số

                System.out.print("Nhập họTên của cán bộ: ");
                String hoTen = scanner.nextLine();

                System.out.print("Nhập tuổi của cán bộ: ");
                int tuoi = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự newline sau khi nhập số

                System.out.print("Nhập giới tính của cán bộ: ");
                String gioiTinh = scanner.nextLine();

                System.out.print("Nhập địa chỉ của cán bộ: ");
                String diaChi = scanner.nextLine();

                if (loaiCanBo == 1) {
                    System.out.print("Nhập bậc của công nhân: ");
                    int bac = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ ký tự newline sau khi nhập số

                    CongNhan congNhan = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac);
                    qlcb.themMoiCanBo(congNhan);
                } else if (loaiCanBo == 2) {
                    System.out.print("Nhập ngành đào tạo của kỹ sư: ");
                    String nganhDaoTao = scanner.nextLine();

                    KySu kySu = new KySu(hoTen, tuoi, gioiTinh, diaChi, nganhDaoTao);
                    qlcb.themMoiCanBo(kySu);
                } else if (loaiCanBo == 3) {
                    System.out.print("Nhập công việc của nhân viên: ");
                    String congViec = scanner.nextLine();

                    NhanVien nhanVien = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec);
                    qlcb.themMoiCanBo(nhanVien);
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                }
                break;
            case 2:
                System.out.println("=== Tìm kiếm theo họ tên ===");
                System.out.print("Nhập họ tên cần tìm kiếm: ");
                String hoTenCanTim = scanner.nextLine();
                qlcb.timKiemTheoHoTen(hoTenCanTim);
                break;
            case 3:
                System.out.println("=== Hiển thị danh sách cán bộ ===");
                qlcb.hienThiDanhSachCanBo();
                break;
            case 4:
                System.out.println("Thoát khỏi chương trình.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    } while (luaChon != 4);

    scanner.close();
}
}