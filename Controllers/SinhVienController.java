package Controllers;

import Views.SinhVienView;
import Models.SinhVienModel;
import Object.SinhVien;

public class SinhVienController {

	    public SinhVienView view;
	    public SinhVienModel model = new SinhVienModel();

	    public SinhVienController(SinhVienModel sv, SinhVienView svw) {
	        this.model = sv;
	        this.view = svw;
	    }

	    public void updateView() {
	        view.Hienthi(model.getSinhvien());
	    }

	    public void addSV(SinhVien sv) {
	        model.addSinhvien(sv);
	    }

	    public void addManual() {
	        model.addSinhvien(new SinhVien(view.NhapMasv(), view.NhapTensv()));
	    }
	}

