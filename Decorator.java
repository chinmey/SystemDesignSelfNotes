package Hospital.designPatternUsage;

// Base interface for booking
interface Booking {
    void book();
}

// Concrete booking (basic appointment)
class BasicAppointmentBooking implements Booking {
    @Override
    public void book() {
        System.out.println("Basic appointment booked.");
    }
}

// Abstract decorator
abstract class BookingDecorator implements Booking {
    protected Booking booking;
    public BookingDecorator(Booking booking) {
        this.booking = booking;
    }
    @Override
    public void book() {
        booking.book();
    }
}

// Concrete decorators
class LabTestDecorator extends BookingDecorator {
    public LabTestDecorator(Booking booking) {
        super(booking);
    }
    @Override
    public void book() {
        super.book();
        System.out.println("Added lab tests to booking.");
    }
}

class HomeVisitDecorator extends BookingDecorator {
    public HomeVisitDecorator(Booking booking) {
        super(booking);
    }
    @Override
    public void book() {
        super.book();
        System.out.println("Added home visit to booking.");
    }
}


public class Decorator {
    
}
