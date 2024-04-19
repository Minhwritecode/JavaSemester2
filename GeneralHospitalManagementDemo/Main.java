package GeneralHospitalManagementDemo;
import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int yearOfBirth;
    private String address;

    public Person(String name, int yearOfBirth, String address) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nYear of Birth: " + yearOfBirth + "\nAddress: " + address;
    }
}

class Patient extends Person {
    private int patientId;
    private int diseaseId;
    private int roomNumber;
    private String admissionDate;
    private String dischargeDate;
    private boolean discharged;
    private int doctorId;

    public Patient(String name, int yearOfBirth, String address, int patientId, int diseaseId, int roomNumber,
            String admissionDate, String dischargeDate, boolean discharged, int doctorId) {
        super(name, yearOfBirth, address);
        this.patientId = patientId;
        this.diseaseId = diseaseId;
        this.roomNumber = roomNumber;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.discharged = discharged;
        this.doctorId = doctorId;
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void dischargePatient(String dischargeDate) {
        if (this.admissionDate.compareTo(dischargeDate) > 0) {
            System.out.println("Error: Discharge date cannot be before admission date.");
        } else {
            this.dischargeDate = dischargeDate;
            this.discharged = true;
        }
    }

    public void admitPatient(String admissionDate) {
        this.admissionDate = admissionDate;
        this.dischargeDate = "";
        this.discharged = false;
    }

    public void changeDoctor(int doctorId) {
        this.doctorId = doctorId;
    }

    public void changeRoom(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPatient ID: " + patientId + "\nDisease ID: " + diseaseId + "\nRoom Number: "
                + roomNumber + "\nAdmission Date: " + admissionDate + "\nDischarge Date: " + dischargeDate
                + "\nDischarged: " + discharged + "\nDoctor ID: " + doctorId;
    }
}

class Doctor extends Person {
    private int doctorId;
    private String department;
    private List<Integer> patientIds;

    public Doctor(String name, int yearOfBirth, String address, int doctorId, String department) {
        super(name, yearOfBirth, address);
        this.doctorId = doctorId;
        this.department = department;
        this.patientIds = new ArrayList<>();
    }

    // Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Integer> getPatientIds() {
        return patientIds;
    }

    public void setPatientIds(List<Integer> patientIds) {
        this.patientIds = patientIds;
    }

    public void addPatient(int patientId) {
        patientIds.add(patientId);
    }

    public void removePatient(int patientId) {
        patientIds.remove(Integer.valueOf(patientId));
    }

    @Override
    public String toString() {
        return super.toString() + "\nDoctor ID: " + doctorId + "\nDepartment: " + department + "\nPatient IDs: "
                + patientIds;
    }
}

class Department {
    private int departmentId;
    private String departmentName;
    private List<Doctor> doctors;

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.doctors = new ArrayList<>();
    }

    // Getters and Setters
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    @Override
    public String toString() {
        return "Department ID: " + departmentId + "\nDepartment Name: " + departmentName + "\nDoctors: " + doctors;
    }
}

class Room {
    private int roomId;
    private String roomName;
    private int bedCount;
    private int patientCount;

    public Room(int roomId, String roomName, int bedCount, int patientCount) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.bedCount = bedCount;
        this.patientCount = patientCount;
    }

    // Getters and Setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }

    public void addPatient() {
        if (patientCount < bedCount) {
            patientCount++;
        } else {
            System.out.println("Error: Room is overloaded.");
        }
    }

    public void removePatient() {
        if (patientCount > 0) {
            patientCount--;
        }
    }

    @Override
    public String toString() {
        return "Room ID: " + roomId + "\nRoom Name: " + roomName + "\nBed Count: " + bedCount + "\nPatient Count: "
                + patientCount;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a department
        Department department = new Department(1, "Department of Internal Medicine");

        // Create doctors
        Doctor doctor1 = new Doctor("John Smith", 1975, "123 Main St", 1001, "Cardiology");
        Doctor doctor2 = new Doctor("Emily Johnson", 1980, "456 Elm St", 1002, "Neurology");

        // Add doctors to the department
        department.addDoctor(doctor1);
        department.addDoctor(doctor2);

        // Create patients
        Patient patient1 = new Patient("David Brown", 1990, "789 Oak St", 2001, 1, 101, "01/01/2024", "", false, 1001);
        Patient patient2 = new Patient("Sarah Davis", 1985, "321 Pine St", 2002, 2, 102, "02/02/2024", "", false, 1002);

        // Add patients to the doctor's patient list
     // Add patients to the doctor's patient list
        doctor1.addPatient(patient1.getPatientId());
        doctor2.addPatient(patient2.getPatientId());

        // Create rooms
        Room room1 = new Room(101, "Cardiology Ward", 10, 0);
        Room room2 = new Room(102, "Neurology Ward", 8, 0);

        // Admit patients to rooms
        room1.addPatient();
        room2.addPatient();

        // Print department information
        System.out.println("Department Information:\n" + department);

        // Print doctor information
        System.out.println("\nDoctor 1 Information:\n" + doctor1);
        System.out.println("\nDoctor 2 Information:\n" + doctor2);

        // Print patient information
        System.out.println("\nPatient 1 Information:\n" + patient1);
        System.out.println("\nPatient 2 Information:\n" + patient2);

        // Print room information
        System.out.println("\nRoom 1 Information:\n" + room1);
        System.out.println("\nRoom 2 Information:\n" + room2);

        // Discharge patient
        patient1.dischargePatient("02/28/2024");

        // Change doctor for patient
        patient2.changeDoctor(1001);

        // Change room for patient
        patient2.changeRoom(101);

        // Print updated patient information
        System.out.println("\nUpdated Patient 1 Information:\n" + patient1);
        System.out.println("\nUpdated Patient 2 Information:\n" + patient2);

        // Remove patient from room
        room1.removePatient();

        // Print updated room information
        System.out.println("\nUpdated Room 1 Information:\n" + room1);
    }
}