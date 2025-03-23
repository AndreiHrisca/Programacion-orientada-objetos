public class Reservation {
    private static int nextId = 1; // Para generar IDs automáticos si se desea
    private int id;
    private Client client;
    private Flight flight;

    public Reservation(Client client, Flight flight) {
        this.id = nextId++;
        this.client = client;
        this.flight = flight;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Flight getFlight() {
        return flight;
    }

    @Override
    public String toString() {
        return "Reserva " + id + ":\n" +
                "  " + client + "\n" +
                "  Vuelo reservado -> " + flight.getId() + " (" + flight.getOrigin() + " - " + flight.getDestination() + ")\n" +
                "  Hora: " + flight.getDepartureTime() + "\n" +
                "  Precio: " + flight.getPrice() + " €\n";
    }
}
