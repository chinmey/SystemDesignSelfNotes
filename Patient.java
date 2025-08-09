package Hospital.patient;

import java.util.List;

import Hospital.appointment.Appointment;

public class Patient {
    
    int id;
    List<Appointment> appointments;

    public Patient(int id, List<Appointment> appointments) {
        this.id = id;
        this.appointments = appointments;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
    
}
