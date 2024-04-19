package TSDuthiDaiHoc;

public class ThiSinhKhoiB extends ThiSinh {
    private int diemToan;
    private int diemHoa;
    private int diemSinh;

    public ThiSinhKhoiB(String soBaoDanh, String hoTen, String diaChi, int mucUuTien, int diemToan, int diemHoa, int diemSinh) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
        this.diemToan = diemToan;
        this.diemHoa = diemHoa;
        this.diemSinh = diemSinh;
    }

    public int getDiemToan() {
        return diemToan;
    }

    public int getDiemHoa() {
        return diemHoa;
    }

    public int getDiemSinh() {
        return diemSinh;
    }
}
