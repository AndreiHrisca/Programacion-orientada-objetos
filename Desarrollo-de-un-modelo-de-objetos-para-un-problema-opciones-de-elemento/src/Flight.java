public class Flight {
    private int id;                 // ID único del vuelo
    private String origin;          // Origen
    private String destination;     // Destino
    private String departureTime;   // Hora de salida
    private double price;           // Precio

    public Flight(int id, String origin, String destination, String departureTime, double price) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.price = price;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vuelo " + id + ":\n" +
                "  Origen: " + origin + "\n" +
                "  Destino: " + destination + "\n" +
                "  Hora: " + departureTime + "\n" +
                "  Precio: " + price + " €\n";
    }
}
