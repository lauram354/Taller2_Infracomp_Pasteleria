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
        if (alto == 0 && radio == 0 && sabor == "" && color == "") {
            return -1;
        } else {
            return 1;
        }
    }

    public synchronized void hacerPedido() {

        this.alto = 10;
        this.radio = 5;
        this.sabor = "Vainilla";
        this.color = "Blanco";


    }

    
}
