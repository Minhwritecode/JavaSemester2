package TSDuthiDaiHoc;

public class ThiSinhKhoiA extends ThiSinh {
    private int diemToan;
    private int diemLy;
    private int diemHoa;

    public ThiSinhKhoiA(String soBaoDanh, String hoTen, String diaChi, int mucUuTien, int diemToan, int diemLy, int diemHoa) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public int getDiemToan() {
        return diemToan;
    }

    public int getDiemLy() {
        return diemLy;
    }

    public int getDiemHoa() {
        return diemHoa;
    }
}

