package Hospital.designPatternUsage;

/**
 * Strategy Pattern for Payment in Hospital App
 *
 * WHY:
 * ----
 * When booking an appointment, patients can pay in multiple ways (Cash, Credit Card, UPI, etc.).
 * Using Strategy Pattern allows us to add or modify payment methods without changing
 * the booking logic. Each payment method is a separate class implementing a common interface.
 */

import java.time.LocalDateTime;

// ---- Payment Strategy Interface ----
interface PaymentStrategy {
    void pay(double amount);
}

// ---- Concrete Strategies ----
class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " in cash.");
    }
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using credit card: " + cardNumber);
    }
}

class UPIPayment implements PaymentStrategy {
    private String upiId;
    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI ID: " + upiId);
    }
}

// ---- Appointment Model ----
class Appointment {
    int patientId;
    int doctorId;
    LocalDateTime time;
    double fee;
    public Appointment(int patientId, int doctorId, LocalDateTime time, double fee) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.time = time;
        this.fee = fee;
    }
    public double getFee() { return fee; }
}

// ---- Booking Service (Context Class) ----
class BookingService {
    public void bookAppointment(Appointment appointment, PaymentStrategy paymentMethod) {
        // Assume appointment booking logic here
        System.out.println("Appointment booked for patient " + appointment.patientId +
                           " with doctor " + appointment.doctorId +
                           " at " + appointment.time);
        // Process payment using chosen strategy
        paymentMethod.pay(appointment.getFee());
    }
}

// ---- Demo ----
public class PaymentStrategyDemo {
    public static void main(String[] args) {
        BookingService bookingService = new BookingService();
        Appointment appointment = new Appointment(101, 1, LocalDateTime.now().plusDays(1), 500.0);

        // Cash payment
        bookingService.bookAppointment(appointment, new CashPayment());

        // Credit card payment
        bookingService.bookAppointment(appointment, new CreditCardPayment("1234-5678-9999-0000"));

        // UPI payment
        bookingService.bookAppointment(appointment, new UPIPayment("patient@upi"));
    }
}
