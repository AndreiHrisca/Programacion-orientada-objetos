import java.util.ArrayList;
import java.util.List;

public class FlightService {
    private List<Flight> flights;

    public FlightService() {
        this.flights = new ArrayList<>();
    }

    /**
     * Inicializa algunos vuelos por defecto,
     * simulando la lógica de "inicializarVuelos()" del código original.
     */
    public void initDefaultFlights() {
        flights.add(new Flight(1, "Madrid", "Barcelona", "9:00", 157.0));
        flights.add(new Flight(2, "Barcelona", "Valencia", "12:30", 175.0));
        flights.add(new Flight(3, "Madrid", "Paris", "18:00", 162.0));
        flights.add(new Flight(4, "Paris", "Roma", "18:00", 110.0));
    }

    /**
     * Devuelve la lista de todos los vuelos.
     */
    public List<Flight> getAllFlights() {
        return flights;
    }

    /**
     * Añade un vuelo a la lista.
     */
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    /**
     * Busca un vuelo por su ID.
     */
    public Flight findFlightById(int id) {
        for (Flight f: flights) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null; // En caso de no existir
    }
}
