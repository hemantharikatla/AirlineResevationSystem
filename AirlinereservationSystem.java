import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int capacity;
    private int seatsBooked;

    public Flight(String flightNumber, String origin, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.seatsBooked = 0;
    }

    // Getters and setters

    // ...

    public boolean hasAvailableSeats() {
        return seatsBooked < capacity;
    }

    public void bookSeat() {
        if (hasAvailableSeats()) {
            seatsBooked++;
        } else {
            throw new RuntimeException("No available seats on flight " + flightNumber);
        }
    }

    // ...

    @Override
    public String toString() {
        return "Flight " + flightNumber + " from " + origin + " to " + destination;
    }

    public String getFlightNumber() {
        return null;
    }
}

class Passenger {
    private String name;
    private String passportNumber;

    public Passenger(String name, String passportNumber) {
        UUID.randomUUID().toString();
        this.name = name;
        this.passportNumber = passportNumber;
    }

    // Getters and setters

    // ...

    @Override
    public String toString() {
        return name + " (Passport: " + passportNumber + ")";
    }

    public String getName() {
        return null;
    }
}

class Reservation {
    private String id;
    private Flight flight;
    private Passenger passenger;

    public Reservation(Flight flight, Passenger passenger) {
        this.id = UUID.randomUUID().toString();
        this.flight = flight;
        this.passenger = passenger;
    }

    public String getId() {
        return id;
    }

    // Getters and setters

    // ...

    @Override
    public String toString() {
        return "Reservation ID: " + id + " - " + passenger.getName() + " has reserved " + flight.getFlightNumber();
    }
}

class AirlineReservationSystem {
    private Map<String, Flight> flights;
    private Map<String, Reservation> reservations;

    public AirlineReservationSystem() {
        this.flights = new HashMap<>();
        this.reservations = new HashMap<>();
    }

    public void addFlight(Flight flight) {
        flights.put(flight.getFlightNumber(), flight);
    }

    public void makeReservation(Flight flight, Passenger passenger) {
        // Reservation implementation
        // ...
    }

    public void cancelReservation(String reservationId) {
        // Cancellation implementation
        // ...
    }

    public List<Flight> getFlightsWithAvailableSeats() {
    List<Flight> availableFlights = new ArrayList<>();
    for (Flight flight : flights.values()) {
        if (flight.hasAvailableSeats()) {
            availableFlights.add(flight);
        }
    }
    return availableFlights;
}


    public List<Reservation> getReservations() {
        return new ArrayList<>(reservations.values());
    }
}

public class Main {
    public static void main(String[] args) {
        AirlineReservationSystem system = new AirlineReservationSystem();

        // Create and add flights
        Flight flight1 = new Flight("AA123", "New York", "Los Angeles", 100);
        Flight flight2 = new Flight("BB456", "London", "Paris", 200);
        system.addFlight(flight1);
        system.addFlight(flight2);

        // Make reservations
        Passenger passenger1 = new Passenger("John Doe", "123456789");
        system.makeReservation(flight1, passenger1);

        Passenger passenger2 = new Passenger("Jane Smith", "987654321");
        system.makeReservation(flight1, passenger2);

        Passenger passenger3 = new Passenger("Michael Johnson", "567890123");
        system.makeReservation(flight2, passenger3);

        // Cancel a reservation
        List<Reservation> reservations = system.getReservations();
        if (!reservations.isEmpty()) {
             String reservationIdToCancel = reservations.get(0).getId();
             system.cancelReservation(reservationIdToCancel);
        } else {
             System.out.println("No reservations found.");
        }

        
        

        // Display available flights
        List<Flight> availableFlights = system.getFlightsWithAvailableSeats();
        System.out.println("Available flights:");
        for (Flight flight : availableFlights) {
            System.out.println(flight);
        }
    }
}
