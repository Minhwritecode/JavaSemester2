package Views;

import java.util.List;

import Models.TheMuon;

public class LibraryView {
    public void hienThiThongTinTheMuon(List<TheMuon> danhSachTheMuon) {
        if (danhSachTheMuon.isEmpty()) {
            System.out.println("Không có thẻ mượn nào trong hệ thống.");
            return;
        }

        System.out.println("Danh sách thẻ mượn:");
        for (TheMuon theMuon : danhSachTheMuon) {
            System.out.println("Mã phiếu mượn: " + theMuon.getMaPhieuMuon());
            System.out.println("Ngày mượn: " + theMuon.getNgayMuon());
            System.out.println("Hạn trả: " + theMuon.getHanTra());
            System.out.println("Số hiệu sách: " + theMuon.getSoHieuSach());
            System.out.println("Thông tin sinh viên mượn:");
            System.out.println(" - Mã sinh viên: " + theMuon.getSinhVienMuon().getMaSV());
            System.out.println(" - Họ tên: " + theMuon.getSinhVienMuon().getHoTen());
            System.out.println(" - Tuổi: " + theMuon.getSinhVienMuon().getTuoi());
            System.out.println(" - Lớp: " + theMuon.getSinhVienMuon().getLop());
            System.out.println("---------------------------");
        }
    }
}
