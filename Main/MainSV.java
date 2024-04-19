package Main;
import Controllers.SinhVienController;
import Models.SinhVienModel;
import Object.SinhVien;
import Views.SinhVienView;
import java.util.*;

public class MainSV {

	public class Main {
	    public static void main(String[] args) {
	        SinhVienModel model = new SinhVienModel();
	        model.setDS(getDataFromDB());
	        SinhVienView view = new SinhVienView();
	        SinhVienController controller = new SinhVienController(model, view);

	        controller.updateView();

	        controller.addSV(new SinhVien("22NS", "AA"));

	        controller.updateView();

	        controller.addManual();

	        controller.updateView();
	    }

	    public static ArrayList<SinhVien> getDataFromDB() {
	        ArrayList<SinhVien> sv = new ArrayList<>();
	        sv.add(new SinhVien("23NS", "ABC"));
	        sv.add(new SinhVien("23ITE", "XYZ"));
	        return sv;
	    }
	}
}

