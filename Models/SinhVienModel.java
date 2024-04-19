package Models;

import java.util.*;
import Object.SinhVien;

public class SinhVienModel {
    ArrayList<SinhVien> dsSinhvien;

    public SinhVienModel() {
        dsSinhvien = new ArrayList<>();
    }

    public void addSinhvien(SinhVien sv) {
        this.dsSinhvien.add(sv);
    }

    public ArrayList<SinhVien> getSinhvien() {
        return this.dsSinhvien;
    }

    public void setDS(ArrayList<SinhVien> sv) {
        this.dsSinhvien = sv;
    }
}

