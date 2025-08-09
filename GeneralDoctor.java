package Hospital.doctor;

import java.time.LocalDateTime;
import java.util.List;

import Hospital.appointment.Appointment;

public class GeneralDoctor implements Doctor {

    int id;
    String specialization;
    List<Appointment> appointments;

    public GeneralDoctor(int id, String specialization, List<Appointment> appointments) {
        this.id = id;
        this.specialization = specialization;
        this.appointments = appointments;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getSpecialization() {
        return specialization;
    }

    @Override
    public List<Appointment> getListOfAppointemnet() {
        return appointments;
    }

    @Override
    public boolean addAppointment(int patientId, LocalDateTime time) {
        // We can use synchronized keyword in java to maintain concurrency between threads 

        // For distributed systems that is multiple machines we can use Centralised locking by redis/Zookeeper etc
        for(Appointment appointment : getListOfAppointemnet()) {
            if(appointment.getLocalDateTime().equals(time)) {
                return false;
            }
        }

        appointments.add(new Appointment(patientId, id, time));
        return true;
    }

    @Override
    public void listDoctorDetails() {
        System.out.println("Doctor is " + getId() + " and specialization is " + getSpecialization());
    }
    
}
