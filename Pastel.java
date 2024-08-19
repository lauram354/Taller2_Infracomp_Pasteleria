import java.util.Scanner;

public class Pastel {

    private int alto;
    private int radio;
    private String sabor;
    private String color;

    public Pastel(int alto, int radio, String sabor, String color) {
        this.alto = alto;
        this.radio = radio;
        this.sabor = sabor;
        this.color = color;
    }

    public synchronized Pastel consultarDetallesPedido() {
        return this;
    }

    public synchronized void hacerPedido() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el alto del pastel: ");
        alto = scanner.nextInt();

        System.out.println("Ingrese el radio del pastel: ");
        radio = scanner.nextInt();

        System.out.println("Ingrese el sabor del pastel: ");
        sabor = scanner.next();

        System.out.println("Ingrese el color del pastel: ");
        color = scanner.next();

        scanner.close();

        System.out.println("Pedido realizado con éxito.");


    }

    
}
