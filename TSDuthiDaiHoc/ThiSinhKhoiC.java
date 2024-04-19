package TSDuthiDaiHoc;

public class ThiSinhKhoiC extends ThiSinh {
    private int diemVan;
    private int diemSu;
    private int diemDia;

    public ThiSinhKhoiC(String soBaoDanh, String hoTen, String diaChi, int mucUuTien, int diemVan, int diemSu, int diemDia) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
        this.diemVan = diemVan;
        this.diemSu = diemSu;
        this.diemDia = diemDia;
    }

    public int getDiemVan() {
        return diemVan;
    }

    public int getDiemSu() {
        return diemSu;
    }

    public int getDiemDia() {
        return diemDia;
    }
}
