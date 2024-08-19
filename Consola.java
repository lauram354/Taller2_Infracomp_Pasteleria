public class Consola {

    private static Pastel pastel = new Pastel(0, 0, "", "");
    private Pastelero pastelero = new Pastelero(pastel);
    private Cliente cliente = new Cliente(pastel);

    public static void main(String[] args) {

        Consola consola = new Consola();
        consola.cliente.start();
        consola.pastelero.start();
        
    }

}
