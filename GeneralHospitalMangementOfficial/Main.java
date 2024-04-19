package GeneralHospitalMangementOfficial;

import java.io.PrintStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();

        // Thêm khoa
        management.addDepartment("D001", "Khoa Nội tiết");
        management.addDepartment("D002", "Khoa Ngoại tiết");
        management.addDepartment("D003", "Khoa Nhi");

        // Thêm bác sĩ
        management.addDoctor("DR001", "Nguyễn Văn A", "D001");
        management.addDoctor("DR002", "Trần Thị B", "D002");
        management.addDoctor("DR003", "Lê Văn C", "D003");

        // Thêm phòng
        management.addRoom("R001", "Phòng 1", 4);
        management.addRoom("R002", "Phòng 2", 3);

        // Thêm bệnh nhân
        management.addPatient("P001", "Nguyễn Văn X", 25, "D001", "DR001", "R001", "Cảm cúm");
        management.addPatient("P002", "Trần Thị Y", 30, "D002", "DR002", "R001", "Đau dạ dày");
        management.addPatient("P003", "Lê Văn Z", 35, "D003", "DR003", "R002", "Viêm họng");

        // Xuất viện bệnh nhân
        management.dischargePatient("P001");

        // Đổi phòng cho bệnh nhân
        management.changeRoom("P002", "R002");

        // Đổi bác sĩ đảm nhiệm cho bệnh nhân
        management.changeDoctor("P002", "DR003");

        // Hiển thị danh sách bệnh nhân theo bệnh
        List<Patient> patientsByDisease = management.getPatientsByDisease("Đau dạ dày");
        System.out.println("Danh sách bệnh nhân theo bệnh:");
        for (Patient patient : patientsByDisease) {
            System.out.println(patient);
        }

        // Hiển thị danh sách bệnh nhân theo phòng
        List<Patient> patientsByRoom = management.getPatientsByRoom("R002");
        System.out.println("Danh sách bệnh nhân theo phòng:");
        for (Patient patient : patientsByRoom) {
            System.out.println(patient);
        }

        // Hiển thị danh sách bác sĩ theo khoa
        List<Doctor> doctorsByDepartment = management.getDoctorsByDepartment("D001");
        System.out.println("Danh sách bác sĩ theo khoa:");
        for (Doctor doctor : doctorsByDepartment) {
            System.out.println(doctor);
        }

        // Hiển thị danh sách bệnh nhân theo thứ tự năm sinh
        List<Patient> patientsByYearOfBirth = management.getPatientsByYearOfBirth();
        System.out.println("Danh sách bệnh nhân theo thứ tự năm sinh:");
        for (Patient patient : patientsByYearOfBirth) {
            System.out.println(patient);
        }
        

        String roomNumber = null;
		Object patients = null;
		try {
        	 int room = Integer.parseInt(roomNumber);
        	 
            return;
        } catch (NumberFormatException e) {
            // Xử lý khi chuỗi không thể chuyển đổi thành số nguyên
            System.out.println("Chuỗi không hợp lệ: " + roomNumber);
            e.printStackTrace();
            return; // Hoặc có thể trả về null hoặc một giá trị mặc định khác tùy vào yêu cầu của bạn
        }
    }
}