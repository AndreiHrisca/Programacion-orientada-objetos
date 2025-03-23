import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Instanciamos los servicios
        FlightService flightService = new FlightService();
        flightService.initDefaultFlights();

        ReservationService reservationService = new ReservationService();

        boolean salir = false;
        int opcion;

        while (!salir) {
            // Mostrar menú
            System.out.println("\n========== MENÚ PRINCIPAL ==========");
            System.out.println("[1] Mostrar catálogo de vuelos");
            System.out.println("[2] Realizar reserva");
            System.out.println("[3] Listado de reservas");
            System.out.println("[0] Salir");
            System.out.print("\nElige una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    mostrarCatalogoVuelos(flightService);
                    break;
                case 2:
                    realizarReserva(sc, flightService, reservationService);
                    break;
                case 3:
                    mostrarListadoReservas(reservationService);
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intenta de nuevo.\n");
            }
        }
        sc.close();
    }

    /**
     * Muestra el catálogo de vuelos utilizando el FlightService.
     */
    private static void mostrarCatalogoVuelos(FlightService flightService) {
        List<Flight> flights = flightService.getAllFlights();
        System.out.println("-------- CATÁLOGO DE VUELOS --------");
        if (flights.isEmpty()) {
            System.out.println("No hay vuelos disponibles.");
        } else {
            for (Flight f : flights) {
                System.out.println(f);
            }
        }
        System.out.println("------------------------------------");
    }

    /**
     * Permite leer datos del usuario y realizar una reserva.
     */
    private static void realizarReserva(Scanner sc, FlightService flightService, ReservationService reservationService) {
        System.out.print("Introduce el código del cliente: ");
        int clientCode = leerEntero(sc);

        System.out.print("Introduce el nombre del cliente (opcional, presiona Enter para omitir): ");
        String name = sc.nextLine().trim();  // leer posible nombre

        if (name.isEmpty()) {
            name = "Desconocido";
        }
        Client client = new Client(clientCode, name);

        // Mostrar los vuelos disponibles
        mostrarCatalogoVuelos(flightService);

        System.out.print("Introduce el ID del vuelo que quieres reservar: ");
        int flightId = leerEntero(sc);

        Flight flight = flightService.findFlightById(flightId);

        if (flight == null) {
            System.out.println("No existe un vuelo con el ID indicado.");
            return;
        }

        // Crear la reserva
        Reservation reservation = reservationService.reserveFlight(client, flight);
        System.out.println("Reserva creada con éxito: ");
        System.out.println(reservation);
    }

    /**
     * Muestra el listado de reservas del ReservationService.
     */
    private static void mostrarListadoReservas(ReservationService reservationService) {
        List<Reservation> reservas = reservationService.getAllReservations();
        System.out.println("---------- LISTADO DE RESERVAS ---------");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            for (Reservation r : reservas) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Lee un entero de la consola, controlando posibles errores de formato.
     */
    private static int leerEntero(Scanner sc) {
        int numero = -1;
        boolean valido = false;
        while (!valido) {
            try {
                String input = sc.nextLine();
                numero = Integer.parseInt(input);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.print("Error: introduce un número entero válido: ");
            }
        }
        return numero;
    }
}
