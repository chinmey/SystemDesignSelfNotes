package Hospital.doctor;

import java.time.LocalDateTime;
import java.util.List;

import Hospital.appointment.Appointment;

public interface Doctor {
    int getId();

    String getSpecialization();

    List<Appointment> getListOfAppointemnet();

    boolean addAppointment(int patientId, LocalDateTime time);

    void listDoctorDetails();
}
