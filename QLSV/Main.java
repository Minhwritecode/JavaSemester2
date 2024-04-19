package QLSV;

import java.util.ArrayList;
import java.util.List;

	class SinhVien {
	    private String maSV;
	    private String hoTen;
	    private int tuoi;
	    private String lop;

	    public SinhVien(String maSV, String hoTen, int tuoi, String lop) {
	        this.maSV = maSV;
	        this.hoTen = hoTen;
	        this.tuoi = tuoi;
	        this.lop = lop;
	    }

	    public String getMaSV() {
	        return maSV;
	    }

	    public String getHoTen() {
	        return hoTen;
	    }

	    public int getTuoi() {
	        return tuoi;
	    }

	    public String getLop() {
	        return lop;
	    }
	}

	class TheMuon {
	    private String maPhieuMuon;
	    private int ngayMuon;
	    private int hanTra;
	    private String soHieuSach;
	    private SinhVien sinhVienMuon;

	    public TheMuon(String maPhieuMuon, int ngayMuon, int hanTra, String soHieuSach, SinhVien sinhVienMuon) {
	        this.maPhieuMuon = maPhieuMuon;
	        this.ngayMuon = ngayMuon;
	        this.hanTra = hanTra;
	        this.soHieuSach = soHieuSach;
	        this.sinhVienMuon = sinhVienMuon;
	    }

	    public String getMaPhieuMuon() {
	        return maPhieuMuon;
	    }

	    public int getNgayMuon() {
	        return ngayMuon;
	    }

	    public int getHanTra() {
	        return hanTra;
	    }

	    public String getSoHieuSach() {
	        return soHieuSach;
	    }

	    public SinhVien getSinhVienMuon() {
	        return sinhVienMuon;
	    }
	}

	class LibrarySystem {
	    private List<TheMuon> danhSachTheMuon;

	    public LibrarySystem() {
	        danhSachTheMuon = new ArrayList<>();
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

	public class Main {
	    public static void main(String[] args) {
	        SinhVien sinhVien1 = new SinhVien("SV001", "Nguyen Van A", 20, "K23");
	        SinhVien sinhVien2 = new SinhVien("SV002", "Tran Thi B",21, "K24");
	        
	        TheMuon theMuon1 = new TheMuon("PM001", 1, 7, "SH001", sinhVien1);
	        TheMuon theMuon2 = new TheMuon("PM002", 3, 10, "SH002", sinhVien2);
	        
	        LibrarySystem librarySystem = new LibrarySystem();
	        librarySystem.themTheMuon(theMuon1);
	        librarySystem.themTheMuon(theMuon2);
	        
	        librarySystem.hienThiThongTinTheMuon();
	        
	        librarySystem.xoaTheMuon("PM001");
	        
	        librarySystem.hienThiThongTinTheMuon();
	    }
	}
