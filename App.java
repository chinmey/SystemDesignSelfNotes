package Hospital;
/**
 * We're building a small hospital management application. We need to track doctors, patients, and appointments. 
 * Implement basic APIs to add and list doctors/patients, schedule an appointment, and list appointments 
 * for a doctor or patient
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Hospital.appointment.Appointment;
import Hospital.doctor.Doctor;
import Hospital.doctor.GeneralDoctor;
import Hospital.patient.Patient;

public class App {

    static List<Doctor> doctors = new ArrayList<>();
    static List<Patient> patients = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        Doctor d1 = new GeneralDoctor(1, "Eye", new ArrayList<>());
        Doctor d2 = new GeneralDoctor(2, "General", new ArrayList<>());

        doctors.add(d1);
        doctors.add(d2);
        
        while(true) {
            System.out.println("Press 1. Viewing list of doctors , 2. Viewing list of patients , 3. Scheudling a appointment , 4. For listing appointemnt , 5. For Quitting");

            int command = scanner.nextInt();

            switch(command) {
                case 1:
                // View list of doctors
                System.out.println("Viewing list of doctors");
                for (Doctor d : doctors) {
                    d.listDoctorDetails();
                }
                break;
        
                case 2:
                // View list of patients
                System.out.println("Viewing list of patients");
                 // Add your patient list logic here
                break;
        
                case 3:
                // Schedule appointment
                System.out.println("Scheduling an appointment");
                System.out.println("please give your patientId, doctorId");
                int pId = scanner.nextInt();
                int dId = scanner.nextInt();
                System.out.println("Enter appointment time (year month day hour):");
                int year = scanner.nextInt();
                int month = scanner.nextInt();
                int day = scanner.nextInt();
                int hour = scanner.nextInt();
                LocalDateTime time = LocalDateTime.of(year, month, day, hour, 0);
                for (Doctor d : doctors) {
                    if(d.getId() == dId) {
                        boolean isSuccess = d.addAppointment(pId, time);
                        if (isSuccess) {
                            System.out.println("Appointment scheduled for: " + time);
                        } else {
                            System.out.println("Is booked for this slot");
                        }
                        
                    }
                }
                break;
        
                case 4:
                 // List appointments
                System.out.println("Listing all appointments");
                // Add your appointment listing logic here
                for (Doctor d : doctors) {
                    List<Appointment> appointments = d.getListOfAppointemnet();
                    for (Appointment appointment : appointments) {
                        appointment.showAppointment();
                    }
                }
                break;
        
                case 5:
                 // Quit
                System.out.println("Exiting the program");
                System.exit(0);
                break;
        
                default:
                System.out.println("Invalid option! Please enter a number between 1 and 5");
                break;
            }
        }
    }
}
