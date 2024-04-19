package Models;

public class TheMuon {
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

