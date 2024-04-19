package Controllers;

import java.util.ArrayList;
import java.util.List;

import Models.TheMuon;
import Views.LibraryView;

public class LibraryController {
    private List<TheMuon> danhSachTheMuon;
    private LibraryView libraryView;

    public LibraryController() {
        danhSachTheMuon = new ArrayList<>();
        libraryView = new LibraryView();
    }

    public void themTheMuon(TheMuon theMuon) {
        danhSachTheMuon.add(theMuon);
    }

    public void xoaTheMuon(String maPhieuMuon) {
        TheMuon theMuonXoa = null;
        for (TheMuon theMuon : danhSachTheMuon) {
            if (theMuon.getMaPhieuMuon().equals(maPhieuMuon)) {
                theMuonXoa = theMuon;
                break;
            }
        }
        if (theMuonXoa != null) {
            danhSachTheMuon.remove(theMuonXoa);
            System.out.println("Đã xóa thành công thẻ mượn có mã phiếu: " + maPhieuMuon);
        } else {
            System.out.println("Không tìm thấy thẻ mượn có mã phiếu: " + maPhieuMuon);
        }
}

	public void hienThiThongTinTheMuon() {
		// TODO Auto-generated method stub
		
	}}
