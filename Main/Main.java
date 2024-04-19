package Main;

import Controllers.LibraryController;
import Models.SinhVien;
import Models.TheMuon;

public class Main {
    public static void main(String[] args) {
        LibraryController libraryController = new LibraryController();

        // Thêm thẻ mượn sách
        SinhVien sinhVien1 = new SinhVien("SV001", "Nguyen Van A", 20, "K23");
        TheMuon theMuon1 = new TheMuon("PM001", 1, 7, "S001", sinhVien1);
        libraryController.themTheMuon(theMuon1);
        SinhVien sinhVien2 = new SinhVien("SV162", "Michael", 18, "K23");
        TheMuon theMuon2 = new TheMuon("PM006", 1, 7, "S001", sinhVien2);

        // Xoá thẻ mượn sách dựa trên mã phiếu mượn
        libraryController.xoaTheMuon("PM001");

        // Hiển thị thông tin các thẻ mượn sách
        libraryController.hienThiThongTinTheMuon();
     // Ví dụ thêm một thẻ mượn sách
        SinhVien sinhVien = new SinhVien("SV001", "Tran Thi B", 20, "K24");
        TheMuon theMuon = new TheMuon("PM001", 1, 7, "S001", sinhVien);
        libraryController.themTheMuon(theMuon1);

        // Ví dụ xoá thẻ mượn sách dựa trên mã phiếu mượn
        libraryController.xoaTheMuon("PM001");

        // Ví dụ hiển thị thông tin các thẻ mượn sách
        libraryController.hienThiThongTinTheMuon();
    
    }
}