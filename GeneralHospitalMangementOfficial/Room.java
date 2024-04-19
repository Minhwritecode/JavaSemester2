package GeneralHospitalMangementOfficial;

public class Room {
    private String roomId;
    private String roomName;
    private int bedCount;
    private int patientCount;

    public Room(String roomId, String roomName, int bedCount) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.bedCount = bedCount;
        this.patientCount = 0;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
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
        if (patientCount >= bedCount) {
            System.out.println("Room is overloaded. Cannot add more patients.");
        } else {
            patientCount++;
        }
    }

    public void removePatient() {
        if (patientCount <= 0) {
            System.out.println("No patients in the room.");
        } else {
            patientCount--;
        }
    }

    public void editRoomInfo(String roomName, int bedCount) {
        this.roomName = roomName;
        this.bedCount = bedCount;
    }

    @Override
    public String toString() {
        return "Room ID: " + roomId +
                "\nRoom Name: " + roomName +
                "\nBed Count: " + bedCount +
                "\nPatient Count: " + patientCount;
    }
}