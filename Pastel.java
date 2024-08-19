import java.util.Scanner;
import java.util.Random;

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

    public synchronized int consultarDetallesPedido() {

        // -1 si no hay pedido aún y 1 si ya está listo 
        
        if (alto == 0 && radio == 0 && sabor == "" && color == "") {
            return -1;
        } else {
            return 1;
        }
    }

    public synchronized void hacerPedido() {

        // Pastel ejemplo

        this.alto = 10;
        this.radio = 5;
        this.sabor = "Vainilla";
        this.color = "Blanco";


    }

    
}
