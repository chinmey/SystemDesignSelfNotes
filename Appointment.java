package Hospital.appointment;

import java.time.LocalDateTime;

public class Appointment {

    int patientId;

    int doctorId;

    LocalDateTime localDateTime;

    public void showAppointment() {
         System.out.println("Appointment is between doctor " + doctorId + 
        " and patient " + patientId + " at time " + localDateTime);
    }

    public Appointment(int patientId, int doctorId, LocalDateTime localDateTime) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    
}
