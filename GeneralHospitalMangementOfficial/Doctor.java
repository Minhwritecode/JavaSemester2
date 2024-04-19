package GeneralHospitalMangementOfficial;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private int doctorId;
    private String departmentId;
    private List<Patient> managedPatients;

    public Doctor(String name, int yearOfBirth, String address, int doctorId, String departmentId) {
        super(name, yearOfBirth, address);
        this.doctorId = doctorId;
        this.departmentId = departmentId;
        this.managedPatients = new ArrayList<>();
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public List<Patient> getManagedPatients() {
        return managedPatients;
    }

    public void setManagedPatients(List<Patient> managedPatients) {
        this.managedPatients = managedPatients;
    }

    public void editDoctorInfo(String name, int yearOfBirth, String address) {
        setName(name);
        setYearOfBirth(yearOfBirth);
        setAddress(address);
    }

    public void changeDepartment(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDoctor ID: " + doctorId +
                "\nDepartment ID: " + departmentId +
                "\nManaged Patients: " + managedPatients.size();
    }
}
