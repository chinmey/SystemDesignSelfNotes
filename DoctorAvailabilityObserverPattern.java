package Hospital.designPatternUsage;

/**
 * Observer Pattern Example: Notifying Patients when a famous Doctor becomes available.
 *
 * WHY:
 * ----
 * In a hospital management system, some patients may want to know when a specific doctor 
 * (e.g., a famous surgeon) becomes available for appointments. We don't want patients 
 * polling for updates repeatedly — instead, we "push" updates to them.
 *
 * The Observer Pattern allows a "Subject" (Doctor) to maintain a list of "Observers" (Patients)
 * and notify them automatically when a relevant event occurs.
 *
 * BENEFITS:
 * ---------
 * - Decouples the Doctor class from knowing about specific Patients.
 * - Scales well — adding/removing observers does not require changing Doctor code.
 * - Fits real-world publish/subscribe scenarios.
 */
public class DoctorAvailabilityObserverPattern {

    // ---- Observer Interface ----
    interface Observer {
        // Called when the Subject's state changes
        void update(Subject subject);
    }

    // ---- Subject Interface ----
    interface Subject {
        void registerObserver(Observer o);
        void removeObserver(Observer o);
        void notifyObservers();
    }

    // ---- Concrete Subject (Doctor) ----
    static class FamousDoctor implements Subject {
        private String name;
        private boolean available;
        private java.util.List<Observer> observers = new java.util.ArrayList<>();

        public FamousDoctor(String name) {
            this.name = name;
        }

        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(this);
            }
        }

        // Changing doctor availability triggers notifications
        public void setAvailable(boolean available) {
            this.available = available;
            if (available) {
                notifyObservers();
            }
        }

        public boolean isAvailable() {
            return available;
        }

        public String getName() {
            return name;
        }
    }

    // ---- Concrete Observer (Patient) ----
    static class Patient implements Observer {
        private String name;

        public Patient(String name) {
            this.name = name;
        }

        @Override
        public void update(Subject subject) {
            if (subject instanceof FamousDoctor) {
                FamousDoctor doc = (FamousDoctor) subject;
                System.out.println("Notification for " + name + ": Doctor " 
                                   + doc.getName() + " is now available!");
            }
        }
    }

    // ---- Demo / Test ----
    public static void main(String[] args) {
        FamousDoctor drA = new FamousDoctor("Dr. House");

        Patient p1 = new Patient("Alice");
        Patient p2 = new Patient("Bob");

        // Patients subscribe to doctor availability
        drA.registerObserver(p1);
        drA.registerObserver(p2);

        // Doctor becomes available
        drA.setAvailable(true);

        // Bob unsubscribes
        drA.removeObserver(p2);

        // Doctor becomes available again
        drA.setAvailable(true);
    }
}

