package Views;
import java.util.Scanner;
import Object.SinhVien;
import java.util.*;

public class SinhVienView {

	    private Scanner k = new Scanner(System.in);

	    public void Hienthi(ArrayList<SinhVien> sv) {
	        for (SinhVien s : sv) {
	            System.out.println("Ma sinh vien: " + s.getId());
	            System.out.println("Ho ten sinh vien: " + s.getName());
	        }
	    }

	    public String NhapMasv() {
	        System.out.print("Nhap ma sinh vien: ");
	        return k.nextLine();
	    }

	    public String NhapTensv() {
	        System.out.print("Nhap ho ten sinh vien: ");
	        return k.nextLine();
	    }
	}

