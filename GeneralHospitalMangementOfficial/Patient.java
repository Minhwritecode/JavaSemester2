package GeneralHospitalMangementOfficial;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient extends Person {
    private int patientId;
    private int diseaseId;
    private int roomId;
    private String admissionDate;
    private String dischargeDate;
    private boolean discharged;
    private int doctorId;

    public Patient(String name, int yearOfBirth, String address, int patientId, int diseaseId, int roomId, String admissionDate, String dischargeDate, boolean discharged, int doctorId) {
        super(name, yearOfBirth, address);
        this.patientId = patientId;
        this.diseaseId = diseaseId;
        this.roomId = roomId;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.discharged = discharged;
        this.doctorId = doctorId;
    }

    public Patient(String patientId2, String patientName, int age, String departmentId, String doctorId2,
			String roomId2, String disease) {
		// TODO Auto-generated constructor stub
	}

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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int newRoomId) {
        this.roomId = newRoomId;
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

    public void setDoctorId(int string) {
        this.doctorId = string;
    }

    public void dischargePatient(String dischargeDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date admission = dateFormat.parse(this.admissionDate);
            Date discharge = dateFormat.parse(dischargeDate);
            if (discharge.before(admission)) {
                System.out.println("Error: Discharge date cannot be before admission date.");
            } else {
                this.dischargeDate = dischargeDate;
                this.discharged = true;
            }
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format.");
        }
    }

    public void admitPatient(String admissionDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date admission = dateFormat.parse(admissionDate);
            Date today = new Date();
            if (admission.after(today)) {
                System.out.println("Error: Admission date cannot be in the future.");
            } else {
                this.admissionDate = admissionDate;
                this.discharged = false;
            }
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format.");
        }
    }

    public void changeDoctor(int doctorId) {
        this.doctorId = doctorId;
    }

    public void changeRoom(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPatient ID: " + patientId +
                "\nDisease ID: " + diseaseId +
                "\nRoom ID: " + roomId +
                "\nAdmission Date: " + admissionDate +
                "\nDischarge Date: " + dischargeDate +
                "\nDischarged: " + discharged +
                "\nDoctor ID: " + doctorId;
    }

	public int getAge() {
		// TODO Auto-generated method stub
		return 0;
	}
}
