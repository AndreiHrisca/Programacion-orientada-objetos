import java.io.*;
import java.util.Vector;
public class ReservaVuelos {
    private BufferedReader br; // Acceso a laentrada estándar
    private Vector origenes; // Almacenador origenes
    private Vector destinos; // Almacenador de destinos
    private Vector horas; // Almacenador de horas
    private Vector precios; // Almacenador de precios
    private Vector codigosCliente; // Almacenador de códigos de clientes
    private Vector reservas; // Almacenador de reservas

    // Constructor
    public ReservaVuelos() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        origenes = new Vector();
        destinos = new Vector();
        horas = new Vector();
        precios = new Vector();
        codigosCliente = new Vector();
        reservas = new Vector();
    }

    // Inicialización del catalogo de vuelos
    public void inicializarVuelos() {
        // Primer vuelo
        origenes.addElement("Madrid");
        destinos.addElement("Barcelona");
        horas.addElement("9:00");
        precios.addElement(new Double(157));

        // Segundo vuelo
        origenes.addElement("Barcelona");
        destinos.addElement("Madrid");
        horas.addElement("12:30");
        precios.addElement(new Double(175));

        // Tercer vuelo
        origenes.addElement("Madrid");
        destinos.addElement("Barcelona");
        horas.addElement("18:00");
        precios.addElement(new Double(162));
    }

    // Catálogo de vuelos
    public String catalogoVuelos() {
        String listado = "--------- Vuelos ---------";
        String origen, destino, hora;
        double precio;

        for (int i = 0; i < origenes.size(); ++i) {
            origen = ((String) origenes.elementAt(i)).toString();
            destino = ((String) destinos.elementAt(i)).toString();
            hora = ((String) horas.elementAt(i)).toString();
            precio = ((Double) precios.elementAt(i)).doubleValue();
            listado += "\n--- Vuelo Número " + (i+1)
                    + " ---\n"; listado += "Origen: " + origen
                    + "\n"; listado += "Destino: " + destino
                    + "\n";
            listado += "Hora: " + hora + "\n";
            listado += "Precio: " + precio + "\n";
            listado += "\n----------------------";
        }
        listado += "\n------- Fin Vuelos -------\n";
        return listado;
    }

    // Reserva un vuelo para un código de cliente, indicando la posición del vuelo en la lista, en reservas
    public void reservarVuelo(int codigoCliente, int codigoVuelo) {
        codigosCliente.addElement(new Integer(codigoCliente));
        reservas.addElement(new Integer(codigoVuelo));
    }

    // Listado de reservas
    public String listadoReservas() {
        String listado = "--------- Reservas ---------";
        int cliente, reserva;
        String origen, destino, hora;
        double precio;
        for (int i = 0; i < codigosCliente.size(); ++i) {
            cliente = ((Integer)
                    codigosCliente.elementAt(i)).intValue();
            reserva = ((Integer)
                    reservas.elementAt(i)).intValue();
            origen = ((String)
                    origenes.elementAt(reserva)).toString();
            destino = ((String)
                    destinos.elementAt(reserva)).toString();
            hora = ((String)
                    horas.elementAt(reserva)).toString();
            precio = ((Double)
                    precios.elementAt(reserva)).doubleValue();
            listado += "\n--- Reserva Número " +
                    (i+1) + " ---\n";
            listado += "Cliente: " + cliente + "\n";
            listado += "Origen: " + origen + "\n";
            listado += "Destino: " + destino + "\n";
            listado += "Hora: " + hora +
                    "\n"; listado += "Precio: " +
                    precio + "\n"; listado += "\n------------------------";
        }
        listado += "\n------ Fin Reservas ------\n";
        return listado;
    }

    // Lectura de datos para hacer reservas
    public int leerCodigoCliente() throws IOException {
        String entrada;
        int codigo;
        System.out.print("Codigo cliente: ");
        entrada = br.readLine();
        codigo = Integer.parseInt(entrada);
        return codigo;
    }

    public int leerNumeroVuelo() throws
            IOException { String entrada;
        int numeroVuelo;
        System.out.print("Numero Vuelo: ");
        entrada = br.readLine();
        numeroVuelo =
                Integer.parseInt(entrada);
        return numeroVuelo;
    }

    // Menu principal
    public int menuPrincipal() throws IOException {
        int opcion = 0;
        String entrada;
        System.out.println("[1] Mostrar catálogo de vuelos.");
        System.out.println("[2] Realizar reserva.");
        System.out.println("[3] Listado de reservas.");
        System.out.println("[0] Salir.");
        System.out.print("Elige una opcion: ");
        entrada = br.readLine();
        opcion = Integer.parseInt(entrada);
        return opcion;
    }

    // Metodo principal de gestión
    public void buclePrincipal() throws IOException {
        boolean salir = false;
        int opcion;
        int codigo, numeroVuelo;
        while (!salir) {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    System.out.println(this.catalogoVuelos());
                    break;
                case 2: codigo
                        =
                        this.leerCodigoCliente();
                    numeroVuelo
                            =
                            this.leerNumeroVuelo();
                    this.reservarVuelo(codigo,numeroVuelo-1); break;
                case 3:
                    System.out.println(this.listadoReservas());
                    break;
                default: salir = true;
            }
        }
    }
    // Programa principal
    public static void main(String[] arg) throws IOException
    {
        ReservaVuelos reservas = new ReservaVuelos();
        reservas.inicializarVuelos();
        reservas.buclePrincipal();
    }
}
