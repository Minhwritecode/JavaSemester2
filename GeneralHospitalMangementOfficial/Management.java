package GeneralHospitalMangementOfficial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Management {
    private Map<String, Department> departments;
    private Map<String, Doctor> doctors;
    private Map<String, Room> rooms;
    private List<Patient> patients;

    public Management() {
        departments = new HashMap<>();
        doctors = new HashMap<>();
        rooms = new HashMap<>();
        patients = new ArrayList<>();
    }

    public void addDepartment(String departmentId, String departmentName) {
        if (!departments.containsKey(departmentId)) {
            Department department = new Department(departmentId, departmentName);
            departments.put(departmentId, department);
        }
    }

    public void addDoctor(String doctorId, String doctorName, String departmentId) {
        if (!doctors.containsKey(doctorId) && departments.containsKey(departmentId)) {
            Doctor doctor = new Doctor(doctorId, 0, doctorName, 0, departmentId);
            doctors.put(doctorId, doctor);
        }
    }

    public void addRoom(String roomId, String roomName, int bedCount) {
        if (!rooms.containsKey(roomId)) {
            Room room = new Room(roomId, roomName, bedCount);
            rooms.put(roomId, room);
        }
    }

    public void addPatient(String patientId, String patientName, int age, String departmentId, String doctorId, String roomId, String disease) {
    	if (!patients.stream().anyMatch(p -> Integer.valueOf(p.getPatientId()).equals(patientId))) {
            if (departments.containsKey(departmentId) && doctors.containsKey(doctorId) && rooms.containsKey(roomId)) {
                Patient patient = new Patient(patientId, patientName, age, departmentId, doctorId, roomId, disease);
                patients.add(patient);
                rooms.get(roomId).addPatient();
            }
        }
    }

    public void dischargePatient(String patientId) {
        patients.stream()
                .filter(p -> Integer.valueOf(p.getPatientId()).equals(patientId))
                .findFirst()
                .ifPresent(p -> {
                    rooms.get(p.getRoomId()).removePatient();
                    patients.remove(p);
                });
    }
    public void changeRoom(String patientId, int newRoomId) {
        patients.stream()
                .filter(p -> Integer.valueOf(p.getPatientId()).equals(patientId))
                .findFirst()
                .ifPresent(p -> {
                    rooms.get(p.getRoomId()).removePatient();
                    rooms.get(newRoomId).addPatient();
                    p.setRoomId(newRoomId);
                });
    }

    public void changeDoctor(String patientId, int string) {
        patients.stream()
                .filter(p -> Integer.valueOf(p.getPatientId()).equals(patientId))
                .findFirst()
                .ifPresent(p -> p.setDoctorId(string));
    }

    public List<Patient> getPatientsByDisease(String disease) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
        	if (Objects.equals(patient.getDiseaseId(), disease)) {
                result.add(patient);
            }
        }
        return result;
    }

    private Object getDiseaseId() {
		// TODO Auto-generated method stub
		return null;
	}

    public List<Patient> getPatientsByRoom(String roomId) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            if (Integer.valueOf(patient.getRoomId()).equals(Integer.valueOf(roomId))) {
                result.add(patient);
            }
        }
        return result;
    }

    public List<Doctor> getDoctorsByDepartment(String departmentId) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : doctors.values()) {
            if (doctor.getDepartmentId().equals(departmentId)) {
                result.add(doctor);
            }
        }
        return result;
    }

    public List<Patient> getPatientsByYearOfBirth() {
        patients.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        return patients;
    }

	public void changeRoom(String patientId, String string) {
		// TODO Auto-generated method stub
		
	}

	public void changeDoctor(String patientId, String string) {
		// TODO Auto-generated method stub
		
	
	
	}
}