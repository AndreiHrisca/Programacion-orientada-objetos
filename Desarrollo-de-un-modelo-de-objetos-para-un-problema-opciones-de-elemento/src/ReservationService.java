import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private List<Reservation> reservations;

    public ReservationService() {
        this.reservations = new ArrayList<>();
    }

    /**
     * Crea una reserva y la añade a la lista.
     */
    public Reservation reserveFlight(Client client, Flight flight) {
        Reservation newReservation = new Reservation(client, flight);
        reservations.add(newReservation);
        return newReservation;
    }

    /**
     * Devuelve todas las reservas.
     */
    public List<Reservation> getAllReservations() {
        return reservations;
    }

    /**
     * Busca una reserva por su ID.
     */
    public Reservation findReservationById(int id) {
        for (Reservation r : reservations) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }
}
