package Models;

public class SinhVien {
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

