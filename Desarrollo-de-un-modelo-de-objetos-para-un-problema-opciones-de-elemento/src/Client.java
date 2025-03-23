public class Client {
    private int clientCode;    // Identificador del cliente
    private String name;       // Nombre del cliente

    public Client(int clientCode, String name) {
        this.clientCode = clientCode;
        this.name = name;
    }

    public int getClientCode() {
        return clientCode;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cliente " + clientCode + (name != null ? " - " + name : "");
    }
}
